package lotto.domain.user;

import lotto.config.Config;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoTargetNumResults;
import lotto.utill.Utii;

public class Statistic {
    private static final Integer MONEY_FIRST_PLACE = 2000000000;
    private static final Integer MONEY_SECOND_PLACE = 30000000;
    private static final Integer MONEY_THIRD_PLACE = 1500000;
    private static final Integer MONEY_FOURTH_PLACE = 50000;
    private static final Integer MONEY_FIFTH_PLACE = 5000;
    private static final Integer TARGET_COUNT_SIX = 6;
    private static final Integer TARGET_COUNT_FIVE = 5;
    private static final Integer TARGET_COUNT_FOUR = 4;
    private static final Integer TARGET_COUNT_THREE = 3;
    private LottoEnvelop lottoEnvelop;
    private Judgment judgment;
    private Integer countOfFirstPlace;
    private Integer countOfSecondPlace;
    private Integer countOfThirdPlace;
    private Integer countOfFourthPlace;
    private Integer countOfFifthPlace;
    private Integer totalWinMoney;

    public Statistic(LottoEnvelop lottoEnvelop, LottoTargetNumResults lottoTargetNumResults) {
        this.lottoEnvelop = lottoEnvelop;
        this.judgment = Config.judgment(lottoTargetNumResults);
        this.countOfFirstPlace = 0;
        this.countOfSecondPlace = 0;
        this.countOfThirdPlace = 0;
        this.countOfFourthPlace = 0;
        this.countOfFifthPlace = 0;
        this.totalWinMoney = 0;
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

    public StringBuilder show() {
        StringBuilder resultString = new StringBuilder();

        // TODO: 11/6/23 상수 정리
        execution();
        resultString.append("3개 일치 (5,000원) - " + countOfFifthPlace + "개\n");
        resultString.append("4개 일치 (50,000원) - " + countOfFourthPlace + "개\n");
        resultString.append("5개 일치 (1,500,000원) - " + countOfThirdPlace + "개\n");
        resultString.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOfSecondPlace + "개\n");
        resultString.append("6개 일치 (2,000,000,000원) - " + countOfFirstPlace + "개\n");

        return resultString;
    }

    // TODO: 11/6/23 상수 정리
    private void calculateTotalWinMoney() {
        totalWinMoney = totalWinMoney + (countOfFifthPlace * MONEY_FIFTH_PLACE);
        totalWinMoney = totalWinMoney + (countOfFourthPlace * MONEY_FOURTH_PLACE);
        totalWinMoney = totalWinMoney + (countOfThirdPlace * MONEY_THIRD_PLACE);
        totalWinMoney = totalWinMoney + (countOfSecondPlace * MONEY_SECOND_PLACE);
        totalWinMoney = totalWinMoney + (countOfFirstPlace * MONEY_FIRST_PLACE);
    }

    public Integer getTotalWinMoney() {
        calculateTotalWinMoney();

        return totalWinMoney;
    }

    private void isFirstPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_SIX)) {
            countOfFirstPlace = countOfFirstPlace + 1;
        }
    }

    private void isSecondPlace(Integer countSame, Boolean isSameBonus) {
        if (isSameCount(countSame, TARGET_COUNT_FIVE) && isSameBonus) {
            countOfSecondPlace = countOfSecondPlace + 1;
        }
    }

    private void isThirdPlace(Integer countSame, Boolean isSameBonus) {
        if (isSameCount(countSame, TARGET_COUNT_FIVE) && !isSameBonus) {
            countOfThirdPlace = countOfThirdPlace + 1;
        }
    }

    private void isFourthPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_FOUR)) {
            countOfFourthPlace = countOfFourthPlace + 1;
        }
    }

    private void isFifthPlace(Integer countSame) {
        if (isSameCount(countSame, TARGET_COUNT_THREE)) {
            countOfFifthPlace = countOfFifthPlace + 1;
        }
    }

    private boolean isSameCount(Integer countSame, Integer targetCount) {
        return Utii.isSameInt(countSame, targetCount);
    }
}
