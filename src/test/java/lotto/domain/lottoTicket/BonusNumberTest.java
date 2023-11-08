package lotto.domain.lottoTicket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("숫자 값으로 객체를 생성할 수 있다.")
    @Test
    void generateClass() {
        //given
        int input = 2;

        //when
        BonusNumber bonusNumber = BonusNumber.from(input);

        //then
        assertThat(bonusNumber).isNotNull();
    }

    @DisplayName("로또 숫자 범위를 벗어나면 예외가 발생한다.")
    @Test
    void throwExceptionInvalidInput() {
        //given
        int input = Lotto.END_INCLUSIVE + 1;

        //when
        //then
        assertThatThrownBy(() -> BonusNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.LOTTO_RANGE_EXCEPTION);
    }
}