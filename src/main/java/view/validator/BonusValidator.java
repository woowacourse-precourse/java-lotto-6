package view.validator;

import static util.message.ExceptionMessage.RANGE_START_BETWEEND_END;

public class BonusValidator extends Validator{
    public static int validate(String input){
        validateBlank(input);
        int number = validateType(input);
        return validateRange(1,45, number);
    }

    protected static int validateRange(final int start, final int end, final int number) {
        if (number < start || number > end) {
            throw new IllegalArgumentException(String.format(RANGE_START_BETWEEND_END.getValue(), start, end));
        }
        return number;
    }
}
