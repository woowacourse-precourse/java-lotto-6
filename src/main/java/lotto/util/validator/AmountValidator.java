package lotto.util.validator;

import lotto.util.ExceptionMessage;

public class AmountValidator extends Validator{
    @Override
    public boolean validation(String input) {
        if(validationNumeric(input)){
            System.out.println(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
            return false;
        }
        if(validationDivideThousand(input)){
            System.out.println(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    private boolean validationDivideThousand(String input) {
        int amount = Integer.parseInt(input);
        return amount % 1000 != 0;
    }

    private boolean validationNumeric(String input) {
        String regex = "^[0-9]*$";
        return !input.matches(regex);
    }
}
