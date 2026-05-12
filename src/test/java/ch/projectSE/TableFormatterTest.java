package ch.projectSE;

import ch.projectSE.Product;
import ch.projectSE.TableFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import ch.projectSE.Formatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableFormatterTest {
    private List<Product>  products;

    @BeforeEach
    public void setUp(){
        products = new ArrayList<>();
        products.add(new Product("1", "Monitor", "monitor", "A great monitor"));
        products.add(new Product("2", "Keyboard", "keyboard", "A mechanical keyboard"));
    }
    @Test
    public void testContainsProductName(){
        Formatter formatter = new TableFormatter();
        String result = formatter.format(products);
        assertTrue(result.contains("Monitor"));

    }
    @Test
    public void testContainsSlug() {
        Formatter formatter = new TableFormatter();
        String result = formatter.format(products);
        assertTrue(result.contains("keyboard"));
    }
    @Test
    public void testEmptyList(){
        Formatter formatter = new TableFormatter();
        String result = formatter.format(new ArrayList<>());
        assertFalse(result.isEmpty());
    }
}
