package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class InputView {
    public InputView() {
    }

    public String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
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

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
