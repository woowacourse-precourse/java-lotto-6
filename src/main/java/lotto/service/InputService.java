package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buy;
import lotto.domain.WinningLotto;

public class InputService {

    public Buy enterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        Buy buy = new Buy(money);
        return buy;
    }

    public WinningLotto enterWinningLotto() {
        String winningNumber = enterWinningNumber();
        String bonusNumber = enterBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        return winningLotto;
    }

    private String enterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        return winningNumber;
    }

    private String enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
