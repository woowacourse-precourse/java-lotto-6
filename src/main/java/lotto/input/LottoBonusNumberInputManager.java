package lotto.input;

import static lotto.exception.ExceptionMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.ExceptionMessage.WRONG_BONUS_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.LottoNumberValidator;

final class LottoBonusNumberInputManager {
    private LottoBonusNumberInputManager() {
    }

    static int fromConsole(List<Integer> answerNumbers) {
        String userInput = Console.readLine();
        return fromString(userInput, answerNumbers);
    }

    static int fromString(String input, List<Integer> answerNumbers) {
        int bonusNumber = convertInputToLottoNumber(input);
        validateDuplicateWithLottoNumber(answerNumbers, bonusNumber);
        return bonusNumber;
    }

    private static int convertInputToLottoNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER_SIZE);
        }
        validateLottoNumberSize(number);
        return number;
    }

    private static void validateLottoNumberSize(int lottoNumber) {
        LottoNumberValidator.validateNumberIsLottoNumber(lottoNumber, WRONG_BONUS_NUMBER_SIZE);
    }

    private static void validateDuplicateWithLottoNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        }
    }
}
