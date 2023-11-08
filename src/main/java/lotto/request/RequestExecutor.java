package lotto.request;

import java.util.List;
import lotto.view.ErrorView;

public class RequestExecutor {
    private final List<Request> requests;

    public RequestExecutor(List<Request> requests) {
        this.requests = requests;
    }

    public void execute() {
        for (Request request : requests) {
            boolean isOk = false;
            while (!isOk) {
                try {
                    request.process();
                    isOk = true;
                } catch (IllegalArgumentException error) {
                    new ErrorView(error.getMessage()).render();
                }
            }
        }
    }
}
