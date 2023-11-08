package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.lottocompany.Lotto;

public class ConsoleInput implements Input {

    private static final String NUMBER_REGEX  = "\\d+";

    @Override
    public int inputPurchaseAmount() throws IllegalArgumentException{
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    @Override
    public Lotto inputWinningNumbers() throws IllegalArgumentException {
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(number -> {
                    validateNumber(number);
                    return Integer.parseInt(number.strip());
                })
                .toList();
        return new Lotto(winningNumbers);
    }

    @Override
    public int inputBonusNumber() throws IllegalArgumentException {
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateNumber(String input) throws IllegalArgumentException{
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1 ~ 45 사이의 숫자입니다.");
        }
    }
}
