package lotto.domain;

import lotto.type.ErrorMessageType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BonusLottoNumberTest {

    @DisplayName("숫자 대신 다른 문자를 입력했을 때 예외 처리")
    @Test
    void notNumberException() {
        assertThatThrownBy(() -> {
            new BonusLottoNumber("a");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessageType.NOT_NUMBER.message());
    }

    @DisplayName("로또 숫자에 벗어나는 숫자 입력 시 예외 처리")
    @Test
    void outOfRangeException() {
        assertThatThrownBy(() -> {
            new BonusLottoNumber("47");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessageType.OUT_OF_LOTTO_NUMERICAL_RANGE.message());
    }

    @DisplayName("정상 테스트")
    @Test
    void getLottoResultTest() {
        BonusLottoNumber bonusLottoNumber = new BonusLottoNumber("27");
        assertThat(bonusLottoNumber.getBounsNum())
                .isEqualTo(27);
    }
}