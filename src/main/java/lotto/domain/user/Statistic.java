package lotto.domain.user;

import lotto.config.Config;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoTargetNumResults;
import lotto.utill.Utii;

import java.util.List;

public class Statistic {
    // TODO: 11/6/23 상수 정리
    private static final Integer TARGET_COUNT_SIX = 6;
    private static final Integer TARGET_COUNT_FIVE = 5;
    private static final Integer TARGET_COUNT_FOUR = 4;
    private static final Integer TARGET_COUNT_THREE = 3;
    private static final String LOTTO_WIN_FIRST_PLACE = LottoRank.MONEY_FIRST_PLACE.getPlace();
    private static final String LOTTO_WIN_SECOND_PLACE = LottoRank.MONEY_SECOND_PLACE.getPlace();
    private static final String LOTTO_WIN_THIRD_PLACE = LottoRank.MONEY_THIRD_PLACE.getPlace();
    private static final String LOTTO_WIN_FOURTH_PLACE = LottoRank.MONEY_FOURTH_PLACE.getPlace();
    private static final String LOTTO_WIN_FIFTH_PLACE = LottoRank.MONEY_FIFTH_PLACE.getPlace();
    private LottoEnvelop lottoEnvelop;
    private Judgment judgment;
    private Integer totalWinMoney;

    private List<LottoRank> lottoRanks;

    public Statistic(LottoEnvelop lottoEnvelop, LottoTargetNumResults lottoTargetNumResults) {
        this.lottoEnvelop = lottoEnvelop;
        this.judgment = Config.judgment(lottoTargetNumResults);
        this.totalWinMoney = 0;
        this.lottoRanks = List.of(LottoRank.MONEY_FIRST_PLACE, LottoRank.MONEY_SECOND_PLACE,
                LottoRank.MONEY_THIRD_PLACE, LottoRank.MONEY_FOURTH_PLACE, LottoRank.MONEY_FIFTH_PLACE);
    }

    public StringBuilder show() {
        StringBuilder resultString = new StringBuilder();

        // TODO: 11/6/23 상수 정리
        execution();

        resultString.append("3개 일치 (5,000원) - " + getCount(LOTTO_WIN_FIFTH_PLACE) + "개\n");
        resultString.append("4개 일치 (50,000원) - " + getCount(LOTTO_WIN_FOURTH_PLACE) + "개\n");
        resultString.append("5개 일치 (1,500,000원) - " + getCount(LOTTO_WIN_THIRD_PLACE) + "개\n");
        resultString.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + getCount(LOTTO_WIN_SECOND_PLACE) + "개\n");
        resultString.append("6개 일치 (2,000,000,000원) - " + getCount(LOTTO_WIN_FIRST_PLACE) + "개\n");

        return resultString;
    }

    private void execution() {

        for (int i = 0; i < lottoEnvelop.size(); i++) {
            Lotto lotto = lottoEnvelop.takeLotto(i);
            Integer countSame = judgment.countSameWinNumbers(lotto);
            Boolean isSameBonus = judgment.isSameBonusNum(lotto);

            isFirstPlace(countSame);
            isSecondPlace(countSame, isSameBonus);
            isThirdPlace(countSame, isSameBonus);
            isFourthPlace(countSame);
            isFifthPlace(countSame);
        }
    }

    // TODO: 11/6/23 상수 정리
    private void calculateTotalWinMoney() {

        for (LottoRank lottoRank : lottoRanks) {
            totalWinMoney = totalWinMoney + lottoRank.getWinMoney();
        }
    }

    public Integer getTotalWinMoney() {
        calculateTotalWinMoney();

        return totalWinMoney;
    }

    private void isFirstPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_SIX)) {
            increaseCount(LOTTO_WIN_FIRST_PLACE);
        }
    }

    private void isSecondPlace(Integer countSame, Boolean isSameBonus) {
        if (isSameCount(countSame, TARGET_COUNT_FIVE) && isSameBonus) {
            increaseCount(LOTTO_WIN_SECOND_PLACE);
        }
    }

    private void isThirdPlace(Integer countSame, Boolean isSameBonus) {
        if (isSameCount(countSame, TARGET_COUNT_FIVE) && !isSameBonus) {
            increaseCount(LOTTO_WIN_THIRD_PLACE);
        }
    }

    private void isFourthPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_FOUR)) {
            increaseCount(LOTTO_WIN_FOURTH_PLACE);
        }
    }


    private void isFifthPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_THREE)) {
            increaseCount(LOTTO_WIN_FIFTH_PLACE);
        }
    }

    private void increaseCount(String place) {
        for (LottoRank lottoRank : lottoRanks) {
            if (lottoRank.getPlace().equals(place)) {
                lottoRank.increaseCount();
            }
        }
    }

    private Integer getCount(String place) {
        for (LottoRank lottoRank : lottoRanks) {
            if (lottoRank.getPlace().equals(place)) {
                return lottoRank.getCount();
            }
        }
        return 0;
    }

    private boolean isSameCount(Integer countSame, Integer targetCount) {
        return Utii.isSameInt(countSame, targetCount);
    }
}
