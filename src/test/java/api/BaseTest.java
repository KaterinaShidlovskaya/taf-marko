package api;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {
    protected final AuthenticationRequests AUTHENTICATION_REQUESTS = AuthenticationRequests.getInstance();
    protected final SearchRequests SEARCH_REQUESTS = SearchRequests.getInstance();

    public enum Messages {
        STATUS_ERROR_MESSAGE("{\"status\":\"error\",\"text\":\"\\u041e\\u0448\\u0438\\u0431\\u043a\\u0430 \\u0434\\u0430\\u043d\\u043d\\u044b\\u0445!\"}"),
        STATUS_OK_MESSAGE("{\"status\":\"ok\"}"),
        SEARCH_EMPTY_RESULTS("Пустой поисковый запрос"),
        SEARCH_VALID_RESULTS("Результаты поиска по запросу"),
        SEARCH_INVALID_RESULTS("По данному запросу ничего не найдено");

        private String messageText;

        Messages(String messageText) {
            this.messageText = messageText;
        }

        @Override
        public String toString() {
            return messageText;
        }
    }

    public enum Users {
        EMPTY_USER_DATA("login=password="),
        REGISTERED_USER_DATA("form_data=login%3D%252B375%2520(29)%2520510-93-19%26password%3DKaterina1993510"),
        UNREGISTERED_USER_DATA("login=%2B375%20(29)%20655-00-09&password=1q2w3e4r");

        private String userData;

        Users(String userData) {
            this.userData = userData;
        }

        @Override
        public String toString() {
            return userData;
        }
    }
}