package lotto.view.outputview;

public final class ErrorHandlingView {
    private ErrorHandlingView() {
    }

    public static void viewErrorText(String message) {
        System.out.println(message);
    }
}
