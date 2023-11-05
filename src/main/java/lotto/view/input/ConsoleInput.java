package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.lottocompany.Lotto;

public class ConsoleInput implements Input {

    @Override
    public int inputPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 숫자를 입력해주세요.");
        }
    }

    @Override
    public Lotto inputWinningNumbers() {
        String winningNumbersInput = Console.readLine();
        try {
            List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(winningNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 숫자를 입력해주세요.");
        }
    }
}
