package lotto;

public class LottoGame {

    private final LottoGameController controller;

    public LottoGame() {
        controller = new LottoGameController();
    }

    public void start() {
        BuyCash buyCash = controller.inputBuyCash();
        Lottos lottos = controller.purchaseLotto(buyCash);
        controller.printBuyLottosInformation(lottos);

        Lotto winningNumbers = controller.inputWinningLotto();
        LottoNumber bonusNumber = controller.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Result result = controller.getResult(lottos, winningLotto);
        controller.printWinningResult(result, buyCash);
    }
}
