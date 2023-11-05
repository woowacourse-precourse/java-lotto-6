package lotto;

import lotto.domain.LotteryGame;

import static lotto.app.ApplicaitonConfig.*;

public class Application {
    public static void main(String[] args) {
        LotteryGame lottery = new LotteryGame(getMerchant(), getMachine());
        lottery.start();
    }
}
