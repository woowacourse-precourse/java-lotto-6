package lotto.validator.impl;

import java.util.stream.Stream;
import lotto.constants.ErrorMessages;
import lotto.validator.Validator;

public class MoneyValidator implements Validator<String> {

      @Override
      public void validate(String money) {
            int moneyNumeric = isNumeric(money);
            isInValidRange(moneyNumeric);
            isMultipleOfThousand(moneyNumeric);
      }

      void isInValidRange(int money) {
            if (money < 1000) {
                  throwException(ErrorMessages.INPUT_MONEY_RANGE);
            }
      }

      void isMultipleOfThousand(int money) {
            if (money % 1000 != 0) {
                  throwException(ErrorMessages.INPUT_MONEY_UNIT);
            }
      }

      int isNumeric(String money) {
            try {
                  Integer.parseInt(money);
            } catch (NumberFormatException e) {
                  throwException(ErrorMessages.INPUT_MONEY_NUMERIC);
            }
            return Integer.parseInt(money);
      }
}
