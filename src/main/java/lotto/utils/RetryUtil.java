package lotto.utils;

import lotto.view.OutputView;

public class RetryUtil {
    public static void retry(InputFunction inputFunction) {
        boolean isValid = false;
        while(!isValid) {
            try {
                inputFunction.performInput();
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
