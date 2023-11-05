package lotto.model;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("당첨 로또 번호의 개수 6개 초과 시 예외 발생 테스트")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_LENGTH.get());
    }

    @DisplayName("당첨 로또 번호에 개수 6개 미만 시 예외 발생 테스트")
    @Test
    void createLottoSize() {
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_LENGTH.get());
    }

    @DisplayName("당첨 로또 번호 중복 시 예외 발생 테스트")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_DUPLICATE.get());
    }

    @DisplayName("당첨 로또 번호 입력값 없을 때 예외 발생 테스트")
    @Test
    void isEmpty() {
        assertThatThrownBy(() -> Lotto.create(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_NULL.get());
    }

    @DisplayName("당첨 로또 번호 공백 포함 시 예외 발생 테스트")
    @Test
    void isContainsBlank() {
        assertThatThrownBy(() -> Lotto.create("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_CONTAINS_BLANK.get());
    }

    @DisplayName("당첨 로또 번호의 입력값이 쉼표(,)로 끝나는 경우 예외 발생 테스트")
    @Test
    void isEndsWithComma() {
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_ENDS_WITH_COMMA.get());
    }

}