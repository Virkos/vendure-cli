package ch.projectSE;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProductQuery extends GraphQLQuery<Product> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final String id;

    public ProductQuery(String id) {
        this.id = id;
    }

    @Override
    public String getQuery() {
        return "query { product(id: \"" + id + "\") { id name slug description } }";
    }

    @Override
    public Product parseResponse(String json) throws Exception {
        JsonNode root = MAPPER.readTree(json);
        JsonNode productNode = root.path("data").path("product");
        return MAPPER.treeToValue(productNode, Product.class);
    }
}
