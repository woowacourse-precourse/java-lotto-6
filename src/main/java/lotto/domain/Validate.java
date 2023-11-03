package lotto.domain;

import lotto.constants.ErrorMessage;

public class Validate {
    public long validateInputPrice(String input) {
        long result;
        try {
            result = Long.parseLong(input);
            if (!canDivide(result)) {
                return 0;
            }
        } catch (NumberFormatException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(ErrorMessage.IS_NOT_NUMBER);
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(ErrorMessage.CAN_NOT_DIVIDE);
            return 0;
        }

        return result;
    }

    private boolean canDivide(long input) {
        if (input % 1000 != 0 || input == 0) {
            throw new IllegalArgumentException();
        }

        if (input % 1000 == 0) {
            return true;
        }

        return false;
    }
}
