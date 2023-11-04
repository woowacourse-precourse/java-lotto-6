package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRewardConditionTest {

    @DisplayName("두 로또의 비교 결과를 찾을 수 있습니다.")
    @Test
    void getCompareResult() {
        // given
        Lotto lotto = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoToCompare1 = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 7));
        Lotto lottoToCompare2 = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoRewardCondition compareResult1 = LottoRewardCondition.getCompareResult(lotto, lottoToCompare1, 6);
        LottoRewardCondition compareResult2 = LottoRewardCondition.getCompareResult(lotto, lottoToCompare2, 7);

        // then

        assertAll(
                () -> assertThat(compareResult1).isEqualTo(LottoRewardCondition.SECOND_WINNER),
                () -> assertThat(compareResult2).isEqualTo(LottoRewardCondition.FIRST_WINNER)
        );
    }
}