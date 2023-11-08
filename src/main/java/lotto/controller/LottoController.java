package lotto.controller;

import java.util.List;
import lotto.DrawResult;
import lotto.DrawResult.Builder;
import lotto.Lotto;
import lotto.LottoLover;
import lotto.Prize;
import lotto.PrizeRecord;
import lotto.StatisticsDto;
import lotto.view.LottoView;

public class LottoController {

    public void giveMoneyTo(LottoLover buyer) {
        boolean isFailed = true;
        while (isFailed) {
            try {
                int moneyAmount = LottoView.requestMoneyToUser();
                buyer.earnMoneySomehow(moneyAmount);
                isFailed = false;
            } catch (IllegalArgumentException e) {
                // 메시지 출력 후 다시 입력하도록 한다.
                System.out.println("[ERROR] " + e);
            }
        }
    }

    public void brag(LottoLover lottoLover) {
        List<Lotto> lookAtThis
                = lottoLover.bragAboutMyLottoButYouAreNotAllowedToTouchIt();
        LottoView.printPurchaseList(lookAtThis);
    }

    public DrawResult getDrawResult() {
        Builder drawResultBuilder = new DrawResult.Builder();
        applyWinningNumbers(drawResultBuilder);
        return applyBonusNumberAndBuildDrawResult(drawResultBuilder);
    }

    private void applyWinningNumbers(Builder builder) {
        while (true) {
            try {
                List<Integer> winningNumbers = LottoView.requestWinningNumbers();
                builder.winningNumbers(winningNumbers);
                return;
            } catch (IllegalArgumentException e) {
                // 메시지 출력 후 다시 입력하도록 한다.
                System.out.println("[ERROR] " + e);
            }
        }
    }

    private DrawResult applyBonusNumberAndBuildDrawResult(Builder builder) {
        while (true) {
            try {
                int bonusNumber = LottoView.requestBonusNumber();
                builder.bonusNumber(bonusNumber);
                return builder.build();
            } catch (IllegalArgumentException e) {
                // 메시지 출력 후 다시 입력하도록 한다.
                System.out.println("[ERROR] " + e);
            }
        }
    }

    public void showResult(LottoLover lottoLover, DrawResult drawResult) {
        PrizeRecord prizeRecord = lottoLover.beholdMyAccomplishment(drawResult);
        StatisticsDto statisticsDto = new StatisticsDto(
                prizeRecord.getFirstPlaceLottoCount(),
                prizeRecord.getSecondPlaceLottoCount(),
                prizeRecord.getThirdPlaceLottoCount(),
                prizeRecord.getFourthPlaceLottoCount(),
                prizeRecord.getFifthPlaceLottoCount(),
                prizeRecord.getProfitRatio());
        LottoView.printStatistics(statisticsDto);
    }
}
