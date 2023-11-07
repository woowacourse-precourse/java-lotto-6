package lotto.domain.user;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.number.BonusLottoNum;
import lotto.domain.number.LottoTargetNumResults;
import lotto.domain.number.WinLottoNums;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticTest {
    private Statistic statistic;
    private LottoEnvelop lottoEnvelop;
    private Lotto lotto_1;
    private Lotto lotto_2;
    private Lotto lotto_3;
    private Lotto lotto_4;
    private Lotto lotto_5;
    private Lotto lotto_6;
    private Lotto lotto_7;
    private Lotto lotto_8;
    private LottoTargetNumResults lottoTargetNumResults;
    private WinLottoNums winLottoNums;
    private BonusLottoNum bonusLottoNum;

    @BeforeEach
    void setUp() {
        lottoEnvelop = new LottoEnvelop();

        winLottoNums = new WinLottoNums(List.of(1, 2, 3, 4, 5, 6));
        bonusLottoNum = new BonusLottoNum(7);
        lottoTargetNumResults = new LottoTargetNumResults(List.of(1, 2, 3, 4, 5, 6), 7);

        statistic = new Statistic(lottoEnvelop, lottoTargetNumResults);
    }

    @DisplayName("통계의 결과를 보여준다._1")
    @Test
    void show() {
        // given
        lotto_1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        lotto_2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        lotto_3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        lotto_4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        lotto_5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        lotto_6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        lotto_7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        lotto_8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));

        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);
        lottoEnvelop.add(lotto_4);
        lottoEnvelop.add(lotto_5);
        lottoEnvelop.add(lotto_6);
        lottoEnvelop.add(lotto_7);
        lottoEnvelop.add(lotto_8);

        // when
        StringBuilder result = statistic.show();

        // than
        assertThat(result).contains(
                "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "6개 일치 (2,000,000,000원) - 0개\n"
        );
    }

    @DisplayName("통계의 결과를 보여준다._2")
    @Test
    void show_2() {
        // given
        lotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개
        lotto_2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 1개보너스
        lotto_3 = new Lotto(List.of(1, 2, 3, 4, 5, 20)); // 5개
        lotto_4 = new Lotto(List.of(1, 2, 3, 4, 32, 38)); // 4개
        lotto_5 = new Lotto(List.of(1, 2, 3, 29, 40, 35)); // 3개

        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);
        lottoEnvelop.add(lotto_4);
        lottoEnvelop.add(lotto_5);

        // when
        StringBuilder result = statistic.show();

        // than
        assertThat(result).contains(
                "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 1개\n" +
                        "5개 일치 (1,500,000원) - 1개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                        "6개 일치 (2,000,000,000원) - 1개\n"
        );
    }


    @DisplayName("총 당첨 금액을 알려준다._1")
    @Test
    void getTotalWinMoney_1() {
        // given
        lotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등

        lottoEnvelop.add(lotto_1);

        // when
        statistic.show();
        Integer result = statistic.getTotalWinMoney();

        // than
        assertThat(result).isEqualTo(
                2000000000
        );
    }

    @DisplayName("총 당첨 금액을 알려준다._2")
    @Test
    void getTotalWinMoney_2() {
        // given
        lotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개
        lotto_2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 1개보너스

        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);

        // when
        statistic.show();
        Integer result = statistic.getTotalWinMoney();

        // than
        assertThat(result).isEqualTo(
                2000000000 + 30000000
        );
    }

    @DisplayName("총 당첨 금액을 알려준다._3")
    @Test
    void getTotalWinMoney_3() {
        // given
        lotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개
        lotto_2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 1개보너스
        lotto_3 = new Lotto(List.of(1, 2, 3, 4, 5, 20)); // 5개

        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);

        // when
        statistic.show();
        Integer result = statistic.getTotalWinMoney();

        // than
        assertThat(result).isEqualTo(
                2000000000 + 30000000 + 1500000
        );
    }

    @DisplayName("총 당첨 금액을 알려준다._4")
    @Test
    void getTotalWinMoney_4() {
        // given
        lotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개
        lotto_2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 1개보너스
        lotto_3 = new Lotto(List.of(1, 2, 3, 4, 5, 20)); // 5개
        lotto_4 = new Lotto(List.of(1, 2, 3, 4, 32, 38)); // 4개

        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);
        lottoEnvelop.add(lotto_4);

        // when
        statistic.show();
        Integer result = statistic.getTotalWinMoney();

        // than
        assertThat(result).isEqualTo(
                2000000000 + 30000000 + 1500000 + 50000
        );
    }

    @DisplayName("총 당첨 금액을 알려준다._5")
    @Test
    void getTotalWinMoney_5() {
        // given
        lotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개
        lotto_2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 1개보너스
        lotto_3 = new Lotto(List.of(1, 2, 3, 4, 5, 20)); // 5개
        lotto_4 = new Lotto(List.of(1, 2, 3, 4, 32, 38)); // 4개
        lotto_5 = new Lotto(List.of(1, 2, 3, 29, 40, 35)); // 3개

        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);
        lottoEnvelop.add(lotto_4);
        lottoEnvelop.add(lotto_5);

        // when
        statistic.show();
        Integer result = statistic.getTotalWinMoney();

        // than
        assertThat(result).isEqualTo(
                5000 + 50000 + 1500000 + 30000000 + 2000000000
        );
    }
}