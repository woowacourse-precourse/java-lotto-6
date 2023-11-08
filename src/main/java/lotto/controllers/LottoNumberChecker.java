package lotto.controllers;

import lotto.model.LotteryPrize;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoNumberMatcher;
import lotto.views.LottoView;

import java.util.ArrayList;
import java.util.List;

import static lotto.controllers.DongHangLottery.getInputBonusNumber;
import static lotto.controllers.DongHangLottery.getInputWinningNumber;

public class LottoNumberChecker {
    static LottoNumberMatcher lotteryPrize = new LottoNumberMatcher();
    static LottoView lottoDisplay = new LottoView();
    public static void comparisonMyLottoNumberAndWinningNumber(ArrayList<Lotto> lottoTickets) {
        String winningNumber = getInputWinningNumber();
        String inputBonusNumber = getInputBonusNumber();


        for (Lotto lotto : lottoTickets) {
            List<Integer> myLottoNumbers = lotto.getNumbers();
            lotteryPrize.checkWinning(myLottoNumbers,winningNumber,inputBonusNumber);
        }
    }

    public static void LotteryResult() {
        ArrayList<LotteryPrize> lotteryResult = new ArrayList<>();
        lotteryResult.add(lotteryPrize.getFifthPrize());
        lotteryResult.add(lotteryPrize.getFourthPrize());
        lotteryResult.add(lotteryPrize.getThirdPrize());
        lotteryResult.add(lotteryPrize.getSecondPrize());
        lotteryResult.add(lotteryPrize.getFirstPrize());

        lottoDisplay.showWinningStatistics(lotteryResult);
    }
}
