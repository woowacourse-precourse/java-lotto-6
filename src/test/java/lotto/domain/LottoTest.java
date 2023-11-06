package lotto.domain;

import java.util.List;
import lotto.enums.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호를 올바르게 입력한다.")
    void 로또번호_맞게_입력() {
        //given
        final String numbers = "1,2,3,4,5,6";

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void 로또번호갯수_7개_입력() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .hasMessage(ExceptionMessages.LOTTO_SIZE_IS_OVER_SIX.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_중복된번호_입력() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .hasMessage(ExceptionMessages.LOTTO_IS_DUPLICATED.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 1~45사이의 숫자가 아닌경우 예외가 발생한다.")
    void 로또_옳은범위_아님() throws Exception{
        //given
        final String numbers = "1,2,3,4,5,47";
        //when, then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(numbers))
                .hasMessage(ExceptionMessages.LOTTO_IS_NOT_BETWEEN_ONE_AND_FORTYFIVE.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 문자로 입력된 경우 예외가 발생한다.")
    void 로또_문자가_입력() throws Exception{
        //given
        final String numbers = "a,b,c,d,e,f";
        //when,then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(numbers))
                .hasMessage(ExceptionMessages.LOTTO_IS_NOT_NUMER.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 빈문자로 입력된 경우 예외가 발생한다.")
    void 로또_빈문자가_입력() throws Exception{
        //given
        final String numbers = "";
        //when,then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(numbers))
                .hasMessage(ExceptionMessages.LOTTO_IS_EMPTY.getMessage());
    }
}