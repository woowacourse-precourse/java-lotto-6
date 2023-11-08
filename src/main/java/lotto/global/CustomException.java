package lotto.global;

public class CustomException extends IllegalArgumentException {

    public CustomException(String message) {
        super(message);
        System.out.println(message);
    }

}
