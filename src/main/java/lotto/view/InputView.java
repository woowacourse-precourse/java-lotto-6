package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.InputViewException;
import lotto.model.Lotto;

public class InputView {
    public InputView() {
    }

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String userAmount = Console.readLine();
        InputViewException.checkLottoPriceTypeException(userAmount);
        int amount = Integer.parseInt(userAmount);
        InputViewException.checkLottoPriceException(userAmount);
        return amount;
    }

    public Lotto getWinningNumbers() {
        System.out.println("당첨숫자를 입력해 주세요.");
        String[] userNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String userNumber : userNumbers) {
            winningNumbers.add(Integer.parseInt(userNumber));
        }

        return new Lotto(winningNumbers);
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
