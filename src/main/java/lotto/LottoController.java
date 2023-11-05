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
        int bonusNumber = 0; // 보너스 당첨 번호

        // 구입금액을 입력.
        int amount = lottoView.inputPurchaseAmount();
        int lottoCount = amount / 1000;

        // 구입한 로또 번호 관리
        Lotto[] lottos = new Lotto[lottoCount];
        // 당첨 통계 관리
        LottoRank[] lottoRanks = new LottoRank[lottoCount];

        for (int i = 0; i < lottos.length; ++i) {
            lottos[i] = new Lotto(lottoService.generateLottoNumbers());
            lottoRanks[i] = new LottoRank(lottos[i]);
        }
        lottoView.printPurchasedLottoNumbers(lottos);

        // 당첨 번호, 보너스 번호 입력
        winningNumbers = lottoService.generateLottoWinningNumbers(lottoView.inputWinningNumber());
        bonusNumber = lottoView.inputBonusNumber();

        // 당첨 통계 조사
        Rank[] ranks = lottoService.calculateWinningDetails(lottoRanks, winningNumbers, bonusNumber);
        lottoView.printWinningInformation(ranks);

        // 수익률 계산
        double profitRate = lottoService.calculateProfitRate(ranks, amount);
        lottoView.printProfitRate(profitRate);
    }
}
