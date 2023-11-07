package lotto;

import static lotto.ExceptionMessage.ERROR_LOTTO_COUNT;
import static lotto.ExceptionMessage.ERROR_LOTTO_DUPICATED;
import static lotto.ExceptionMessage.ERROR_LOTTO_INVALID_INPUT_TYPE_NUMBER;
import static lotto.ExceptionMessage.ERROR_LOTTO_INVALID_NUMBER;
import static lotto.ExceptionMessage.ERROR_LOTTO_RANGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoGameInput {
    public int getLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String inputStr = Console.readLine();

            int inputNumber = validateAndParseInput(inputStr);

            if (inputNumber % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_LOTTO_INVALID_NUMBER.getMessage());
            }
            return inputNumber / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoAmount();
        }
    }

    public int validateAndParseInput(String inputStr) {
        try {
            return Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_LOTTO_INVALID_INPUT_TYPE_NUMBER.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputStr = Console.readLine();
        return validateDuplicateAndConvertToList(inputStr);
    }

    private List<Integer> validateDuplicateAndConvertToList(String inputStr) {
        String[] inputNumbers = inputStr.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numStr : inputNumbers) {
            int inputNumber = validateAndParseInput(numStr);

            valitedateLottoScope(inputNumber);

            if (winningNumbers.contains(inputNumber)) {
                throw new IllegalArgumentException(ERROR_LOTTO_DUPICATED.getMessage());
            }
            winningNumbers.add(inputNumber);
        }
        validateLottoCount(winningNumbers);
        return winningNumbers;
    }

    private static void validateLottoCount(List<Integer> inputNumbers) {
        if (inputNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_COUNT.getMessage());
        }
    }

    private void valitedateLottoScope(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_LOTTO_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputStr = Console.readLine();
        int inputNumber = validateAndParseInput(inputStr);
        valitedateLottoScope(inputNumber);
        return inputNumber;
    }
}
