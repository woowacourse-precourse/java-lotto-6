package lotto.domain;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.service.InputService;
import lotto.service.MessageService;

public class BonusNumber {
    private final MessageService messageService = new MessageService();
    private final InputService inputService = new InputService();
    private final LottoWinningNumbers lottoWinningNumbers;
    private int number;

    public BonusNumber(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.number = inputBonusNumbers();
    }

    private int inputBonusNumbers() {
        messageService.inputBonusNumberMessage();
        while (true) {
            try {
                number = validateNumber(inputService.inputValue());
                validateBonusNumber(number, lottoWinningNumbers.getWinningNumber());
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getNumber() {
        return number;
    }

    private int validateNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicationWinningNumbersAndBonusNumber(bonusNumber, winningNumbers);
    }


    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoNumber.START_NUMBER.getNumber() || bonusNumber > LottoNumber.END_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_OVER_RANGE_ERROR.getMessage());
        }

    }


    private void validateDuplicationWinningNumbersAndBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
        }
    }
}
