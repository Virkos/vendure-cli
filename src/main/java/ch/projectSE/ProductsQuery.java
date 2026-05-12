package ch.projectSE;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductsQuery extends GraphQLQuery<ProductList> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public String getQuery() {
        return "query { products { items { id name slug description } totalItems } }"; }

    @Override
    public ProductList parseResponse(String json) throws Exception {
        JsonNode root = MAPPER.readTree(json);
        JsonNode productsNode = root.path("data").path("products");
        return MAPPER.treeToValue(productsNode, ProductList.class);
    }
}

