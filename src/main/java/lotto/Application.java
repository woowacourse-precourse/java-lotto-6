package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LotteryService doLotto = new LotteryService();
        doLotto.purchaseLotto();
        doLotto.makeRandomLottoNumbers();
        doLotto.makeWinningNumber();
        doLotto.makeBonusNumber();
        doLotto.checkEveryLottoMatch();
        doLotto.checkTotalPrizeInfo();
        doLotto.prize.calcTotalPrizeRate(doLotto.getTotalPurchasePayment());
    }
}
