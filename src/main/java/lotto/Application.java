package lotto;

public class Application {
    
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        lottoGame.enterPurchaseAmount();
        lottoGame.createLottos();
        lottoGame.printLottos();
        lottoGame.enterWinnerNumbers();
        lottoGame.enterBonusWinnerNumber();
        lottoGame.printMatchedLottosReport();
        lottoGame.printReturnRate();
    }
}
