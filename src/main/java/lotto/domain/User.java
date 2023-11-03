package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.ui.Computer;

public class User {
    private Integer money;
    public Integer lottoCount;
    private boolean isPurchasing = true;

    public void purchaseLotto() {
        while (isPurchasing) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                Computer computer = new Computer();
                String userInput = computer.getInput();

                computer.checkNumber(userInput);
                computer.checkZero(userInput);

                money = Integer.parseInt(userInput);
                computer.checkRemainder(money);

                lottoCount = computer.calculateLotto(money);

                isPurchasing = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
