package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.view.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoBonusNumberTest {

    @DisplayName("보너스 번호 빈값 체크")
    @Test
    void 보너스_번호_빈값_체크() {
        //given
        String readLine = "";

        //when //then
        assertThatThrownBy(() -> new LottoBonusNumber(readLine, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_EXCEPTION.getMessage());
    }

    @DisplayName("보너스 번호 1~45 범위 내의 숫자만 가능한지 체크")
    @Test
    void 보너스_번호_1_45_범위_내의_숫자만_체크() {
        //given
        String readLine = "0";

        //when //then
        assertThatThrownBy(() -> new LottoBonusNumber(readLine, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RANGE_EXCEPTION.getMessage());
    }

    @DisplayName("로또 숫자 6개와 추가로 1개의 보너스 번호 중복 체크를 한다.")
    @Test
    void 로또_숫자_6개와_추가로_1개의_보너스_번호_중복_체크를_한다() {
        //given
        String readLine = "5";

        //when //then
        assertThatThrownBy(() -> new LottoBonusNumber(readLine, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OVERLAP_EXCEPTION.getMessage());
    }

    @DisplayName("보너스 번호 문자열을 숫자로 변경하는 함수")
    @Test
    void 보너스_번호_문자열을_숫자로_변경하는_함수() {
        //given
        String readLine = "8";

        //when
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(readLine, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //then
        assertThat(lottoBonusNumber.convertStringToIntegerFormat(readLine)).isEqualTo(8);
    }
}