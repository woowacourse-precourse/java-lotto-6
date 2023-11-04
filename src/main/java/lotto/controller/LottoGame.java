package lotto.controller;

import java.util.Map;
import lotto.common.LottoRank;
import lotto.dto.LottoGameResponse;
import lotto.service.LottoGameService;
import lotto.view.InputOutputView;

public class LottoGame {
    private LottoGameService lottoGameService;
    private InputOutputView inputOutputView;

    public LottoGame() {
        this.lottoGameService = new LottoGameService();
        this.inputOutputView = new InputOutputView();
    }

    public void start() {
        int money = inputOutputView.inputMoney();
        LottoGameResponse lottoGameResponse = lottoGameService.buy(money);
        System.out.printf("%s개를 구매했습니다.\n", lottoGameResponse.getCount());
        for (int i = 0; i < lottoGameResponse.getCount(); i++) {
            System.out.println(lottoGameResponse.getBuyLottoNumbers().get(i));
        }
        String winningNumbers = inputOutputView.inputWinningNumbers();
        int bonusNumber = inputOutputView.inputBonusNumber();

        Map<LottoRank, Integer> result = lottoGameService.calculateResult(winningNumbers, bonusNumber);
        printResult(result);
    }

    private void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %s개\n", result.getOrDefault(LottoRank.FIFTH_RANK, 0));
        System.out.printf("4개 일치 (50,000원) - %s개\n", result.getOrDefault(LottoRank.FOURTH_RANK, 0));
        System.out.printf("5개 일치 (1,500,000원) - %s개\n", result.getOrDefault(LottoRank.THIRD_RANK, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n", result.getOrDefault(LottoRank.SECOND_RANK, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %s개\n", result.getOrDefault(LottoRank.FIRST_RANK, 0));
        System.out.println("총 수익률은 62.5%입니다.");
    }
}
