package lotto;

import lotto.domain.LotteryStore;

public class Application {
    public static void main(String[] args) {
        LotteryStore lotteryStorees = new LotteryStore();
        lotteryStorees.buyLotto();
        lotteryStorees.setWinningNumber();
        lotteryStorees.setBonusNumber();
        lotteryStorees.checkNumber();
    }
}
