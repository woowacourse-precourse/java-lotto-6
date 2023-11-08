package lotto.util;

public record BaseResponse<T>(String message, T data) {
}
