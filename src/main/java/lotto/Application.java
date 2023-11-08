package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.inputAmount();

        LottoList lottoList = new LottoList(purchaseAmount.getAmount());
        lottoList.printNumberOfLotto();
        lottoList.createLottoList();
        lottoList.printLottoList();

        CorrectLotto correctLotto = new CorrectLotto();
        correctLotto.inputCorrectLotto();
        correctLotto.inputBonus();

        DrawLotto drawLotto = new DrawLotto(lottoList, correctLotto);
        drawLotto.draw();
        drawLotto.calculateProfitPercentage(purchaseAmount.getAmount());
        drawLotto.printStatistics();
    }
}
