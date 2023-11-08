package lotto.model.player;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.UnitNumber;

public class BonusNumber {
    private static Integer bonusNumber;
    private static List<Integer> winningNumber;

    public BonusNumber(List<Integer> winningNumber, String number) {
        this.winningNumber = winningNumber;
        validate(number);
        bonusNumber = Integer.parseInt(number);
    }

    private static void validate(String number) {
        validateIsNumber(number);
        validateIsNumberInRange(number);
        validateIsUniqueNumber(number);
    }

    private static void validateIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateIsNumberInRange(String number) {
        boolean IsNumberInRange = (Integer.parseInt(number) >= UnitNumber.LOTTO_MIN_NUMBER.getNumber()
                && Integer.parseInt(number) <= UnitNumber.LOTTO_MAX_NUMBER.getNumber());
        if(!IsNumberInRange) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateIsUniqueNumber(String number) {
        boolean isDuplicated = winningNumber.contains(Integer.parseInt(number));
        if(isDuplicated) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_WITH_BONUS.getMessage());
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
