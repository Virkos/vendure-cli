package ch.projectSE;

import java.util.List;

public class TableFormatter implements Formatter {
    @Override
    public String format(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %s%n", "Name", "Price"));
        sb.append("-".repeat(30)).append("\n");
        for (Product p : products) {
            sb.append(String.format("%-20s %d%n", p.getName(), p.getPrice()));
        }
        return sb.toString();
    }
}
