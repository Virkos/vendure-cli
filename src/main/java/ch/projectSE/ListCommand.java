package ch.projectSE;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "list",
        description = "Displays the list of Vendure products",
        mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {
    @Option(
            names = {"-u", "--url"},
            description = "URL of the GraphQL Vendure API",
            defaultValue = "http://localhost:3000/shop-api")
    private String url;

    @Option(
            names = {"-f", "--format"},
            description = "Display format : table (default) or json",
            defaultValue = "table")
    private String format;

@Override
public void run() {
    try {
    VendureClient client = new VendureClient(url);
    ProductList productList = client.execute(new ProductsQuery());

    Formatter formatter = format.equals("json") ? new JsonFormatter() : new TableFormatter();
        System.out.println(formatter.format(productList.getItems()));

        System.out.printf("%nTotal : %d produit(s)%n", productList.getTotalItems());
        } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error connecting to the Vendure server : " + e.getMessage());
    }
}
}