package lotto.util.validator;

public class ValidatingLoopTemplate {
    public <T> T execute(Callback<T> callback) {
        while (true) {
            try {
                return callback.call();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}