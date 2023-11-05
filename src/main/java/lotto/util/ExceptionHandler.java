package lotto.util;

public interface ExceptionHandler<T> {
    T run();

    static <T> T retryUntilSuccess(ExceptionHandler<T> task) {
        while(true) {
            try {
                task.run();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
