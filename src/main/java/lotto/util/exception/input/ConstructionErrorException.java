package lotto.util.exception.input;


import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.AssertionCustomError;

public class ConstructionErrorException extends AssertionCustomError {
    public ConstructionErrorException() {
        super(ErrorMessage.ConstructionError);
    }
}
