package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoEnumTest {
    @DisplayName("로또 등수와 보너스 번호 여부에 따른 LottoEnum 반환")
    @Test
    void testLottoEnumValueOf() {
        // FIRST: 6개 일치, 보너스 번호 없음
        assertThat(LottoEnum.valueOf(6, false)).isEqualTo(LottoEnum.FIRST);

        // SECOND: 5개 일치, 보너스 번호 있음
        assertThat(LottoEnum.valueOf(5, true)).isEqualTo(LottoEnum.SECOND);

        // THIRD: 5개 일치, 보너스 번호 없음
        assertThat(LottoEnum.valueOf(5, false)).isEqualTo(LottoEnum.THIRD);

        // FOURTH: 4개 일치, 보너스 번호 있음
        assertThat(LottoEnum.valueOf(4, true)).isEqualTo(LottoEnum.FOURTH);

        // FOURTH: 4개 일치, 보너스 번호 없음
        assertThat(LottoEnum.valueOf(4, false)).isEqualTo(LottoEnum.FOURTH);

        // FIFTH: 3개 일치, 보너스 번호 없음
        assertThat(LottoEnum.valueOf(3, true)).isEqualTo(LottoEnum.FIFTH);

        // FIFTH: 3개 일치, 보너스 번호 없음
        assertThat(LottoEnum.valueOf(3, false)).isEqualTo(LottoEnum.FIFTH);

        // NOTHING: 일치하는 번호 없음
        assertThat(LottoEnum.valueOf(2, false)).isEqualTo(LottoEnum.NOTHING);
    }
}
