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

    private int readPurchaseAmount() {
        int purchaseAmount = 0;
        while (purchaseAmount < 1000) {
            purchaseAmount = readIntWithMessage("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.\n로또 구입 금액을 입력해 주세요.");
        }
        return purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    
}
