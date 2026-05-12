package ch.projectSE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonFormatterTest {
    private List<Product> products;

    @BeforeEach
    public void setUp() {
        products = new ArrayList<>();
        products.add(new Product("1", "Monitor", "monitor", "A great monitor"));
        products.add(new Product("2", "Keyboard", "keyboard", "A mechanical keyboard"));
    }
    @Test
    public void testContainsProductName() {
        JsonFormatter jsonFormatter = new JsonFormatter();
        String result = jsonFormatter.format(products);
        assertTrue(result.contains("Monitor"));
    }
    @Test
    public void testContainsSlug() {
        JsonFormatter jsonFormatter = new JsonFormatter();
        String result = jsonFormatter.format(products);
        assertTrue(result.contains("keyboard"));
    }
    @Test
    public void testOutputIsValidJson() {
        JsonFormatter jsonFormatter = new JsonFormatter();
        String result = jsonFormatter.format(products);
        assertTrue(result.startsWith("[") && result.endsWith("]"));
    }
}
