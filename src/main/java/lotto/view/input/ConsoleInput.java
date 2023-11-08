package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.lottocompany.Lotto;

public class ConsoleInput implements Input {

    @Override
    public int inputPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public Lotto inputWinningNumbers() throws IllegalArgumentException {
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbers;
        winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(number -> Integer.parseInt(number.strip()))
                .toList();
        return new Lotto(winningNumbers);
    }

    @Override
    public int inputBonusNumber() throws IllegalArgumentException {
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자입니다.");
        }
    }
}
