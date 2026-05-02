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
        products.add(new Product("Monitor", 999));
        products.add(new Product("Keyboard", 100));
    }
    @Test
    public void testContainsProductName() {
        JsonFormatter jsonFormatter = new JsonFormatter();
        String result = jsonFormatter.format(products);
        assertTrue(result.contains("Monitor"));
    }
    @Test
    public void testContainsPrice() {
        JsonFormatter jsonFormatter = new JsonFormatter();
        String result = jsonFormatter.format(products);
        assertTrue(result.contains("999"));
    }
    @Test
    public void testOutputIsValidJson() {
        JsonFormatter jsonFormatter = new JsonFormatter();
        String result = jsonFormatter.format(products);
        assertTrue(result.startsWith("[") && result.endsWith("]"));
    }
}
