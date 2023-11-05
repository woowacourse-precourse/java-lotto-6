package lotto.domain.user;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoNumResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgmentTest {
    private Judgment judgment;
    private LottoEnvelop lottoEnvelop;
    private LottoNumResults lottoNumResults;
    private Lotto lotto_1;
    private Lotto lotto_2;
    private Lotto lotto_3;

    @BeforeEach
    void setUp() {
        judgment = new Judgment();

        lotto_1 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        lotto_2 = new Lotto(List.of(7, 6, 5, 4, 3, 2));
        lotto_3 = new Lotto(List.of(8, 7, 6, 5, 4, 3));

        lottoEnvelop = new LottoEnvelop();
        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);

        lottoNumResults = new LottoNumResults("1,2,3,4,5,6", "7");
    }

    @DisplayName("로또와 추첨의 번호가 같은 수를 알려준다.")
    @ParameterizedTest
    @CsvSource({"6,5,4,3,2,1,6", "7,6,5,4,3,2,5", "8,7,6,5,4,3,4"})
    void countSameWinNum(int num1, int num2, int num3, int num4, int num5, int num6, int num7) {
        // given
        lotto_1 = new Lotto(List.of(num1, num2, num3, num4, num5, num6));
        lottoNumResults = new LottoNumResults("1,2,3,4,5,6", "7");

        // when
        Integer result = judgment.countSameWinNum(lotto_1, lottoNumResults);

        // than
        assertThat(result).isEqualTo(num7);
    }

    @Test
    void isSameBonusNum() {
    }
}