package ch.projectSE;

public abstract class GraphQLQuery<T> {

    public abstract String getQuery();

    public abstract T parseResponse(String json) throws Exception;
}
