package lotto.configuration;

public class CustomIllegalArgumentException extends IllegalArgumentException{
    public CustomIllegalArgumentException(String message) {
        super(message);
        System.out.println(message);
    }
}
