package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수 6개 초과 시 예외 발생 테스트")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_NUMBERS_LENGTH.get());
    }

    @DisplayName("로또 번호에 개수 6개 미만 시 예외 발생 테스트")
    @Test
    void createLottoSize() {
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_NUMBERS_LENGTH.get());
    }

    @DisplayName("로또 번호 중복 시 예외 발생 테스트")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.create("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_NUMBERS_DUPLICATE.get());
    }


}