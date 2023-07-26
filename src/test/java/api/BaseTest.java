package api;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {
    protected final AuthenticationRequests AUTHENTICATION_REQUESTS = AuthenticationRequests.getInstance();
    protected final SearchRequests SEARCH_REQUESTS = SearchRequests.getInstance();
    protected ValidatableResponse validatableResponse;
}