package lotto;


public record BaseResponse(String message, Object data) {

    public static BaseResponse okWithData(String message, Object data) {
        return new BaseResponse(message, data);
    }
}
