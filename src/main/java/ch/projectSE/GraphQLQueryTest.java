package ch.projectSE;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphQLQueryTest {

    @Test
    public void productsQueryContainsProducts() {
        ProductsQuery query = new ProductsQuery();
        assertTrue(query.getQuery().contains("products"));
    }

    @Test
    public void productsQueryContainsItems() {
        ProductsQuery query = new ProductsQuery();
        assertTrue(query.getQuery().contains("items"));
    }

    @Test
    public void productsQueryContainsTotalItems() {
        ProductsQuery query = new ProductsQuery();
        assertTrue(query.getQuery().contains("totalItems"));
    }

    @Test
    public void productQueryContainsId() {
        ProductQuery query = new ProductQuery("42");
        assertTrue(query.getQuery().contains("42"));
    }

    @Test
    public void productQueryContainsProduct() {
        ProductQuery query = new ProductQuery("1");
        assertTrue(query.getQuery().contains("product"));
    }

    @Test
    public void productsQueryParsesItemsCorrectly() throws Exception {
        String json =
                "{"
                        + "\"data\": {"
                        + "  \"products\": {"
                        + "    \"items\": ["
                        + "      {\"id\": \"1\", \"name\": \"Laptop\", \"slug\": \"laptop\","
                        + "       \"description\": \"A laptop\"},"
                        + "      {\"id\": \"2\", \"name\": \"Phone\",  \"slug\": \"phone\","
                        + "       \"description\": \"A phone\"}"
                        + "    ],"
                        + "    \"totalItems\": 2"
                        + "  }"
                        + "}"
                        + "}";

        ProductsQuery query = new ProductsQuery();
        ProductList result = query.parseResponse(json);

        assertEquals(2, result.getTotalItems());
        assertEquals(2, result.getItems().size());
        assertEquals("Laptop", result.getItems().get(0).getName());
        assertEquals("phone", result.getItems().get(1).getSlug());
    }

    @Test
    public void productsQueryParsesEmptyList() throws Exception {
        String json =
                "{\"data\": {\"products\": {\"items\": [], \"totalItems\": 0}}}";

        ProductsQuery query = new ProductsQuery();
        ProductList result = query.parseResponse(json);

        assertEquals(0, result.getTotalItems());
        assertTrue(result.getItems().isEmpty());
    }

    @Test
    public void productQueryParsesProductCorrectly() throws Exception {
        String json =
                "{"
                        + "\"data\": {"
                        + "  \"product\": {"
                        + "    \"id\": \"1\","
                        + "    \"name\": \"Laptop\","
                        + "    \"slug\": \"laptop\","
                        + "    \"description\": \"A great laptop\""
                        + "  }"
                        + "}"
                        + "}";

        ProductQuery query = new ProductQuery("1");
        Product result = query.parseResponse(json);

        assertEquals("1", result.getId());
        assertEquals("Laptop", result.getName());
        assertEquals("laptop", result.getSlug());
        assertEquals("A great laptop", result.getDescription());
    }

    @Test
    public void productQueryIgnoresExtraJsonFields() throws Exception {
        // Vérifie que @JsonIgnoreProperties(ignoreUnknown = true) fonctionne
        String json =
                "{"
                        + "\"data\": {"
                        + "  \"product\": {"
                        + "    \"id\": \"5\","
                        + "    \"name\": \"Monitor\","
                        + "    \"slug\": \"monitor\","
                        + "    \"description\": \"A monitor\","
                        + "    \"unknownField\": \"someValue\""
                        + "  }"
                        + "}"
                        + "}";

        ProductQuery query = new ProductQuery("5");
        Product result = query.parseResponse(json);

        assertEquals("Monitor", result.getName());
    }
}
