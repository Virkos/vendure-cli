package ch.projectSE;

import java.util.List;

public class JsonFormatter implements Formatter {
    @Override
    public String format(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            sb.append("  {\n");
            sb.append("    \"name\": \"").append(p.getName()).append("\",\n");
            sb.append("    \"price\": ").append(p.getPrice()).append("\n");
            sb.append("  }");
            if (i < products.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}