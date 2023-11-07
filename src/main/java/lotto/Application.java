package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        Buyer buyer = new Buyer(lottoMachine);

        buyer.buyLotto();

        buyer.drawWinningNumbersAndBonusNumber();

        LottoResultChecker lottoResultChecker = new LottoResultChecker();

        lottoResultChecker.checkLotto(buyer.getLotto(), buyer.getDrawnNumbers());
        lottoResultChecker.printTotalPrize();
        lottoResultChecker.printProfit();
    }
}
