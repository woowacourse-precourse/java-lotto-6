package lotto.control;public class Lottogame {
  Lottogameview view = new Lottogameview();

    public void runLottoGame() {
        int purchaseAmount = inputPurchaseAmount();
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        view.printPurchasedLottosCount(lottos.size());
        view.printPurchasedLottos(lottos);


        int[] winCounts = checkWinCounts(lottos, winningNumbers, bonusNumber);

        view.printWinningResult(winCounts, purchaseAmount);
    }

    private int inputPurchaseAmount() {
        int purchaseAmount = readPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }
}
