package lotto.Service;

import lotto.Domain.GameInfo;
import lotto.Domain.Lotto;
import lotto.View.ResultView;

import java.util.List;

import static lotto.Util.LottoEnum.*;

public class LottoService {
    private List<Lotto> purchasedLottoTickets;
    private GameInfo gameInfo;

    public LottoService(List<Lotto> purchasedLottoTickets, GameInfo gameInfo) {
        this.purchasedLottoTickets = purchasedLottoTickets;
        this.gameInfo = gameInfo;
    }

    public void checkLottoResult() {
        int[] lottoResult = calLottoResult();
        double profitMargin = calProfitMargin(lottoResult);

        ResultView.printResult(lottoResult, profitMargin);
    }

    public int[] calLottoResult() {
        return getLottoResult();
    }

    public double calProfitMargin(int[] lottoResult) {
        return getProfitMargin(lottoResult);
    }


    protected int[] getLottoResult() {
        int[] lottoResult = new int[5];

        for (Lotto lotto : purchasedLottoTickets) {
            int grade = lotto.lottoResult(gameInfo.winnerNumbers(), gameInfo.bonusNumber());
            if (grade >= 0) {
                lottoResult[grade]++;
            }
        }

        return lottoResult;
    }

    protected double getProfitMargin(int[] lottoResult) {
        double totalPrize = calTotalPrize(lottoResult);

        double profitMargin = totalPrize / gameInfo.purchaseCost() * 100;
        return (double)Math.round(profitMargin * 10.0) / 10.0;
    }

    private long calTotalPrize(int[] lottoResult) {
        long totalPrize = 0;

        totalPrize += (long) lottoResult[0] * FIRST_PRIZE.getValue();
        totalPrize += (long) lottoResult[1] * SECOND_PRIZE.getValue();
        totalPrize += (long) lottoResult[2] * THIRD_PRIZE.getValue();
        totalPrize += (long) lottoResult[3] * FOURTH_PRIZE.getValue();
        totalPrize += (long) lottoResult[4] * FIFTH_PRIZE.getValue();

        return totalPrize;
    }
}
