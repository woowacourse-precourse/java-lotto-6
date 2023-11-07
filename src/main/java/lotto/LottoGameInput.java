package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoGameInput {
    public int getLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputStr = Console.readLine();

        int inputNumber = validateAndParseInput(inputStr);

        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException("입력된 값은 1000으로 나누어 떨어지지 않습니다.");
        }
        return inputNumber / 1000;
    }

    public int validateAndParseInput(String inputStr) {
        try {
            return Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수 형식이 아닌 입력입니다.");
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
                throw new IllegalArgumentException("로또 당첨 번호에 중복된 번호가 있습니다. 다른 번호를 입력하세요.");
            }
            winningNumbers.add(inputNumber);
        }
        validateLottoCount(winningNumbers);
        return winningNumbers;
    }

    private static void validateLottoCount(List<Integer> inputNumbers) {
        if (inputNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 당첨 번호는 정확히 6개 입력해야 합니다.");
        }
    }

    private void valitedateLottoScope(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 당첨 번호는 1에서 45 사이여야 합니다. 다른 번호를 입력하세요.");
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
