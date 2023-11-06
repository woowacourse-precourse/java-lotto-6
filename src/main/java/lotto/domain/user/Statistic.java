package lotto.domain.user;

import lotto.config.Config;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoTargetNumResults;
import lotto.utill.Utii;

public class Statistic {
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

        execution();
        resultString.append("3개 일치 (5,000원) - " + countOfFifthPlace + "개\n");
        resultString.append("4개 일치 (50,000원) - " + countOfFourthPlace + "개\n");
        resultString.append("5개 일치 (1,500,000원) - " + countOfThirdPlace + "개\n");
        resultString.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOfSecondPlace + "개\n");
        resultString.append("6개 일치 (2,000,000,000원) - " + countOfFirstPlace + "개\n");

        return resultString;
    }

    private void calculateTotalWinMoney() {
        totalWinMoney = totalWinMoney + (countOfFifthPlace * 5000);
        totalWinMoney = totalWinMoney + (countOfFourthPlace * 50000);
        totalWinMoney = totalWinMoney + (countOfThirdPlace * 1500000);
        totalWinMoney = totalWinMoney + (countOfSecondPlace * 30000000);
        totalWinMoney = totalWinMoney + (countOfFirstPlace * 2000000000);
    }

    public Integer getTotalWinMoney() {
        calculateTotalWinMoney();

        return totalWinMoney;
    }

    private void isFirstPlace(Integer countSame) {
        if (isSameCount(countSame, 6)) {
            // 1등: 6개 번호 일치 / 2,000,000,000원
            countOfFirstPlace = countOfFirstPlace + 1;
        }
    }

    private void isSecondPlace(Integer countSame, Boolean isSameBonus) {
        if (isSameCount(countSame, 5) && isSameBonus) {
            // 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
            countOfSecondPlace = countOfSecondPlace + 1;
        }
    }

    private void isThirdPlace(Integer countSame, Boolean isSameBonus) {
        if (isSameCount(countSame, 5) && !isSameBonus) {
            // 3등: 5개 번호 일치 / 1,500,000원
            countOfThirdPlace = countOfThirdPlace + 1;
        }
    }

    private void isFourthPlace(Integer countSame) {
        if (isSameCount(countSame, 4)) {
            // 4등: 4개 번호 일치 / 50,000원
            countOfFourthPlace = countOfFourthPlace + 1;
        }
    }

    private void isFifthPlace(Integer countSame) {
        if (isSameCount(countSame, 3)) {
            // 5등: 3개 번호 일치 / 5,000원
            countOfFifthPlace = countOfFifthPlace + 1;
        }
    }

    private boolean isSameCount(Integer countSame, Integer targetCont) {
        return Utii.isSameInt(countSame, targetCont);
    }
}
