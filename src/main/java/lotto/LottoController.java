package lotto;

public class LottoController {

    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoView view = new LottoView();

    public void start() {
        try {
            int purchaseAmount = view.getPurchaseAmount();
            List<Lotto> lottos = lottoMachine.generateLottos(purchaseAmount);
            view.printLottos(lottos);

            List<Integer> winningNumbers = view.getWinningNumbers();
            int bonusNumber = view.getBonusNumber();

            LottoResult result = calculateResult(lottos, winningNumbers, bonusNumber);
            view.printResult(result);

            double profitRate = calculateProfitRate(purchaseAmount, result.getTotalPrize());
            view.printProfitRate(profitRate);

        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }

    private LottoResult calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        // 결과 계산 로직
        return new LottoResult();
    }

    private double calculateProfitRate(int purchaseAmount, long totalPrize) {
        return (totalPrize / (double) purchaseAmount) * 100;
    }
}