package lotto;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();

        controller.purchaseLotto();
        controller.generateWinningNumbers();
        controller.generateBonusNumber();
        controller.revealLottoResults();
    }
}
