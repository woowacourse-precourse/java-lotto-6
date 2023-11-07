package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        Buyer buyer = new Buyer(lottoMachine, lottoResultChecker);

        buyer.buyLotto();

        buyer.drawWinningNumbersAndBonusNumber();
        buyer.aggregateLotto();
    }
}
