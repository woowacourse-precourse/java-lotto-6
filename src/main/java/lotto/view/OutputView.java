package lotto.view;

import lotto.model.domain.Lotto;
import lotto.model.domain.Referee;

import java.util.List;

import static lotto.model.domain.Rank.*;
import static lotto.util.constant.ViewConstant.*;

public class OutputView {

    public void printLottoAmount(int num) {
        System.out.printf(OUTPUT_PURCHASED_AMOUNT, num);
    }

    public void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoRankingResult(Referee referee) {
        List<Integer> lottoRank = referee.getLottoRank();
        System.out.println(WINNING_RESULT);
        System.out.println(DASH_BAR);
        System.out.printf(FIFTH.getMessage(), lottoRank.get(5));
        System.out.printf(FOURTH.getMessage(), lottoRank.get(4));
        System.out.printf(THIRD.getMessage(), lottoRank.get(3));
        System.out.printf(SECOND.getMessage(), lottoRank.get(2));
        System.out.printf(FIRST.getMessage(), lottoRank.get(1));
    }

    public void printLottoBenefitResult(Referee referee) {
        System.out.printf(TOTAL_BENEFIT, referee.getLottoBenefit(), PERCENT);
    }
}
