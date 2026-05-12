package ch.projectSE;

import java.util.List;

public class TableFormatter implements Formatter {
    @Override
    public String format(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-25s %s%n", "ID", "Nom", "Slug"));
        sb.append("-".repeat(50)).append("\n");
        for (Product p : products) {
            sb.append(String.format("%-5s %-25s %s%n", p.getId(), p.getName(), p.getSlug()));
        }
        return sb.toString();
    }
}
