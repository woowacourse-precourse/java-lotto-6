package lotto;

public class InputValidator {

    public static void checkMoney(String value){
        IntegerValidator.checkEmptyValue(value);
        IntegerValidator.checkZeroOrPositiveInteger(value);
        MoneyValidator.isDividedInto1000(value);

    }

}
