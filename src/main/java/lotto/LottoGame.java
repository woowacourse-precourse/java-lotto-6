package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private final LottoGameInput lottoGameInput;
    private final LottoGameOutput lottoGameOutput;
    private final Lottos lottos;
    private final LottoResult lottoResult;

    public LottoGame() {
        this.lottoGameInput = new LottoGameInput();
        this.lottoGameOutput = new LottoGameOutput();
        this.lottos = new Lottos();
        this.lottoResult = new LottoResult();
    }

    public void play() {
        int amount = lottoGameInput.getLottoAmount();
        lottoGameOutput.printLottoAmount(amount);

        for (int i = 0; i < amount; i++) {
            lottos.addLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        lottoGameOutput.printLottoNumbers(lottos);

        Lotto winningLotto = new Lotto(lottoGameInput.getWinningNumber());
        int bonusNumber = lottoGameInput.getBonusNumber();

        checkLottos(winningLotto, bonusNumber);

        double profit = calculateProfit(amount);

        lottoGameOutput.printLottoResult(lottoResult, profit);


    }

    private void checkLottos(Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lottos.getLottoList()) {
            LottoPrize prize = lotto.checkMatchingNumbers(winningLotto, bonusNumber);
            if (prize != null) {
                lottoResult.increaseCount(prize);
            }
        }
    }

    public double calculateProfit(int amount) {
        long total = lottoResult.getTotalPrizeAmount();
        if (total == 0) {
            return 0.0;
        }

        return ((double) (total - (amount * 1000L)) / total) * 100.0;
    }

}
