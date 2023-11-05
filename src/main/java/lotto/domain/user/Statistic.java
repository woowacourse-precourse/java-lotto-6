package lotto.domain.user;

import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoNumResults;

/**
 * 사용자의 통계 클래스
 */
public class Statistic {
    private LottoEnvelop lottoEnvelop;
    private LottoNumResults lottoNumResults;

    private Integer countSameWinNum;
    private Boolean isSameBonusNum;

    public Statistic(LottoEnvelop lottoEnvelop, LottoNumResults lottoNumResults) {
        this.lottoEnvelop = lottoEnvelop;
        this.lottoNumResults = lottoNumResults;
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

    public StringBuilder show() {
        StringBuilder result = new StringBuilder();
        // 봉투들의 로또 갯수 만큼 반복
        for (int i = 0; i < lottoEnvelop.size(); i++) {
            // 로또 0~5 까지의 번호와, 보너스 번호중 몇개가 같은지 확인
//            lottoEnvelop.
        }

        // 

        return result;
    }
}
