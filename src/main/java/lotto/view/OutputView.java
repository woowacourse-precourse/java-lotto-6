package lotto.view;

import lotto.Lotto;

public class OutputView {
    public void exception(String message) {
        System.out.println(message);
    }

    public void lottoBuyHistory(Lotto[] lottos) {
        System.out.println(lottos.length + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
