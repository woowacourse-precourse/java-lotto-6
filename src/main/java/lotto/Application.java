package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = new Buyer();

        buyer.buyLotto(8000);

        buyer.drawNumber();

        LottoResultChecker lottoResultChecker = new LottoResultChecker();

        lottoResultChecker.checkLotto(buyer.getLotto(), buyer.getDrawnNumbers());
        lottoResultChecker.printTotalPrize();
        lottoResultChecker.printProfit();
    }
}
