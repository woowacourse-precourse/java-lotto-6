package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.InputViewException;
import lotto.model.Lotto;

public class InputView {
    public InputView() {
    }

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount =  Integer.parseInt(Console.readLine());

        InputViewException.checkLottoPriceException(amount);

        return amount;
    }

    public static Lotto getWinningNumbers() {
        System.out.println("당첨숫자를 입력해 주세요.");
        String[] userNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String userNumber : userNumbers) {
            winningNumbers.add(Integer.parseInt(userNumber));
        }

        return new Lotto(winningNumbers);
    }
}
