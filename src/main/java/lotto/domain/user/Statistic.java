package lotto.domain.user;

import lotto.config.Config;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoTargetNumResults;
import lotto.utill.Utii;

/**
 * 사용자의 통계 클래스
 */
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
    // 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    //  1등: 6개 번호 일치 / 2,000,000,000원
    //  2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    //  3등: 5개 번호 일치 / 1,500,000원
    //  3등: 5개 번호 일치 / 1,500,000원
    //  4등: 4개 번호 일치 / 50,000원
    //  5등: 3개 번호 일치 / 5,000원

//    3개 일치 (5,000원) - 1개
//    4개 일치 (50,000원) - 0개
//    5개 일치 (1,500,000원) - 0개
//    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//    6개 일치 (2,000,000,000원) - 0개
//    총 수익률은 62.5%입니다.

    private void execution() {
        // 봉투들의 로또 갯수 만큼 반복
        for (int i = 0; i < lottoEnvelop.size(); i++) {
            // 로또 0~5 까지의 번호와, 보너스 번호중 몇개가 같은지 확인
            Lotto lotto = lottoEnvelop.takeLotto(i);
            Integer countSame = judgment.countSameWinNumbers(lotto);
            Boolean isSameBonus = judgment.isSameBonusNum(lotto);

            if (Utii.isSameInt(countSame, 6)) {
                // 1등: 6개 번호 일치 / 2,000,000,000원
                countOfFirstPlace = countOfFirstPlace + 1;
            }

            if (Utii.isSameInt(countSame, 5) && isSameBonus) {
                // 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
                countOfSecondPlace = countOfSecondPlace + 1;
            }

            if (Utii.isSameInt(countSame, 5) && !isSameBonus) {
                // 3등: 5개 번호 일치 / 1,500,000원
                countOfThirdPlace = countOfThirdPlace + 1;
            }

            if (Utii.isSameInt(countSame, 4)) {
                // 4등: 4개 번호 일치 / 50,000원
                countOfFourthPlace = countOfFourthPlace + 1;
            }

            if (Utii.isSameInt(countSame, 3)) {
                // 5등: 3개 번호 일치 / 5,000원
                countOfFifthPlace = countOfFifthPlace + 1;
            }
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
}
