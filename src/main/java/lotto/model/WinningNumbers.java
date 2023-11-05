package lotto.model;

import lotto.common.Constant;
import lotto.common.ErrorMessage;

public class WinningNumbers {

    private final LottoTickets ticketNumbers;
    private final Number bonusNumber;

    private WinningNumbers(LottoTickets ticketNumbers, Number bonusNumber) {
        validate(ticketNumbers, bonusNumber);
        this.ticketNumbers = ticketNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers createBonusNumber(LottoTickets ticketNumbers, String bonusNumber) {
        Number number = parseAndValidateBonusNumber(bonusNumber);
        return new WinningNumbers(ticketNumbers, number);
    }

    private static Number parseAndValidateBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        return Number.of(Integer.parseInt(bonusNumber));
    }

    private void validate(LottoTickets ticketNumbers, Number bonusNumber) {
        if (isContainsBonusNumber(ticketNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_CONTAINS_BONUS_NUMBER.get());
        }
    }

    private boolean isContainsBonusNumber(LottoTickets ticketNumbers, Number bonusNumber) {
        return ticketNumbers.getTickets().contains(bonusNumber);
    }

    private static void validateBonusNumber(String bonusNumber) {
        isNullBonusNumber(bonusNumber);
        isContainsBlank(bonusNumber);
        isNotOneBonusNumber(bonusNumber);
    }

    private static void isNotOneBonusNumber(String bonusNumber) {
        String[] bonusNumbers = bonusNumber.split(Constant.COMMA.getCharValue());
        if (bonusNumbers.length != 1 || bonusNumbers[0].isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_IS_NOT_ONE_BONUS_NUMBER.get());
        }
    }

    private static void isNullBonusNumber(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_BONUS_NUMBER_NULL.get());
        }
    }

    private static void isContainsBlank(String bonusNumber) {
        if (bonusNumber.contains(Constant.BLANK.getCharValue())) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_BONUS_NUMBER_CONTAINS_BLANK.get());
        }
    }
}
