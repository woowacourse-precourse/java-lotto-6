package lotto.util;

public final class BaseResponse<T> {
    private final String message;
    private final T data;

    public BaseResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String message() {
        return message;
    }

    public T data() {
        return data;
    }
}
