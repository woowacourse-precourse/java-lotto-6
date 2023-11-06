package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.WinningLotto.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("성공적으로 WinningLotto를 가져와야 한다")
    public void 성공적으로_WinningLotto를_가져와야_한다() {
        // True Case
        assertThat(FIRST_PLACE.getLottoRank(6, 0)).isTrue();
        assertThat(SECOND_PLACE.getLottoRank(5, 1)).isTrue();
        assertThat(THIRD_PLACE.getLottoRank(5, 0)).isTrue();
        assertThat(FOURTH_PLACE.getLottoRank(4, 0)).isTrue();
        assertThat(FIFTH_PLACE.getLottoRank(3, 0)).isTrue();
    }

}
