package lotto;

import java.util.ArrayList;

public class LottoController {

    private final LottoView lottoView = new LottoView();
    private final LottoService lottoService = new LottoService();

    /**
     * 로또 진행
     */
    public void processLottoWinning() {
        ArrayList<Integer> winningNumbers; // 로또 당첨 번호
        int bonusNumber = 0;
        int amount = lottoView.inputPurchaseAmount();
        int lottoCount = amount / 1000;

        Lotto[] lottos = new Lotto[lottoCount];
        for (int i = 0; i < lottos.length; ++i) {
            lottos[i] = new Lotto(lottoService.generateLottoNumbers());
        }
        lottoView.printPurchasedLottoNumbers(lottos);

        winningNumbers = lottoService.generateLottoWinningNumbers(lottoView.inputWinningNumber());
        bonusNumber = lottoView.inputBonusNumber();

        Rank[] ranks = lottoService.calculateWinningDetails(lottos, winningNumbers, bonusNumber);
        lottoView.printWinningInformation(ranks);

        double profitRate = lottoService.calculateProfitRate(ranks, amount);
        lottoView.printProfitRate(profitRate);
    }
}
