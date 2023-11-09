package lotto.domain.user;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.number.LottoTargetNumResults;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {
    private User user;
    private LottoEnvelop lottoEnvelop;
    private Lotto lotto_1;
    private Lotto lotto_2;
    private Lotto lotto_3;
    private LottoTargetNumResults lottoTargetNumResults;

    @BeforeEach
    void setUp() {
        lottoTargetNumResults = new LottoTargetNumResults(List.of(1, 2, 3, 4, 5, 6), 7);

        lottoEnvelop = new LottoEnvelop();
        lotto_1 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        lotto_2 = new Lotto(List.of(7, 6, 5, 4, 3, 2));
        lotto_3 = new Lotto(List.of(8, 7, 6, 5, 4, 3));

        user = new User();
        user.takeLottoEnvelop(lottoEnvelop);
        user.takeTargetNumResults(lottoTargetNumResults);
    }

    @DisplayName("로또를 보여준다.")
    @Test
    void showLottoEnvelop() {
        lotto_1 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        lotto_2 = new Lotto(List.of(7, 6, 5, 4, 3, 2));
        lotto_3 = new Lotto(List.of(8, 7, 6, 5, 4, 3));

        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);

        // when
        user.takeLottoEnvelop(lottoEnvelop);
        StringBuilder result = user.showLottoEnvelop();

        // than
        assertThat(result).contains(
                "[1, 2, 3, 4, 5, 6]\n" +
                        "[2, 3, 4, 5, 6, 7]\n" +
                        "[3, 4, 5, 6, 7, 8]\n"
        );
    }

    @DisplayName("로또결과의 당첨에 대한 통계를 한다.")
    @Test
    void doStatisticLottoResult() {
        // given
        Lotto lotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개
        Lotto lotto_2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 1개보너스
        Lotto lotto_3 = new Lotto(List.of(1, 2, 3, 4, 5, 20)); // 5개
        Lotto lotto_4 = new Lotto(List.of(1, 2, 3, 4, 32, 38)); // 4개
        Lotto lotto_5 = new Lotto(List.of(1, 2, 3, 29, 40, 35)); // 3개

        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);
        lottoEnvelop.add(lotto_4);
        lottoEnvelop.add(lotto_5);

        user = new User();
        user.takeLottoEnvelop(lottoEnvelop);
        user.takeTargetNumResults(lottoTargetNumResults);

        // when
        StringBuilder result = user.showLottoStatisticResult(lottoTargetNumResults);

        // than
        Assertions.assertThat(result).contains(
                "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 1개\n" +
                        "5개 일치 (1,500,000원) - 1개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                        "6개 일치 (2,000,000,000원) - 1개\n"
        );
    }
}