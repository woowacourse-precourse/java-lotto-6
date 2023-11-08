package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {

    @DisplayName("문자열을 로또 번호로 변환합니다.")
    @Test
    void 문자열을_로또_번호로_변환합니다() {
        //given
        String readLine = "1,2,3,4,25,6";
        //when
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(readLine);
        //then
        assertThat(lottoWinningNumber.getReadWinningNumber().toString()).isEqualTo("[1, 2, 3, 4, 25, 6]");
    }

    @DisplayName("당첨 번호는 숫자와 콤마 형식이어야 합니다.")
    @Test
    void 당첨_번호는_숫자와_콤마_형식이어야_합니다() {
        //given
        String readLine = "1,2,3,4,25f,6";
        //when//then
        assertThatThrownBy(()-> new LottoWinningNumber(readLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 숫자와 콤마 형식이어야 합니다.");
    }
}