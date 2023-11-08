package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoUtilTest {

    @DisplayName("문자열을 정수로 변환")
    @Test
    void testIntegerParsing() {
        assertThat(LottoUtil.parseInteger("123")).isEqualTo(123);
    }

    @DisplayName("잘못된 문자열을 정수로 변환 시 예외 발생")
    @Test
    void testExceptionWhenInputIsNotNumber() {
        assertThatThrownBy(() -> LottoUtil.parseInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 로또 번호 입력 시 예외 발생")
    @Test
    void testExceptionWhenLottoNumberIsOutOfRange() {
        assertThatThrownBy(() -> LottoUtil.parseLottoNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoUtil.parseLottoNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 정상적인 범위의 로또 번호로 변환")
    @Test
    void testLottoNumberParsing() {
        assertThat(LottoUtil.parseLottoNumber("1")).isEqualTo(1);
        assertThat(LottoUtil.parseLottoNumber("45")).isEqualTo(45);
    }

    @DisplayName("입력된 보너스 번호가 당첨 번호와 중복되면 예외 발생")
    @Test
    void testExceptionWhenNumberIsDuplicated() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> LottoUtil.parseLottoBonusNumber("1", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
    }

    @DisplayName("유효한 보너스 번호 입력 검증")
    @Test
    void testValidBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(LottoUtil.parseLottoBonusNumber("7", winningLotto)).isEqualTo(7);
    }

}