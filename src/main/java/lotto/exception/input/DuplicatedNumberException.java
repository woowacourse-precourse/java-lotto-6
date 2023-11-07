package lotto.exception.input;

public class DuplicatedNumberException extends IllegalArgumentException{
    public DuplicatedNumberException(String message){
        super(message);
    }
}
