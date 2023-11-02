package lotto.model;

import lotto.message.ExceptionMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;


    @DisplayName("올바른 로또번호를 입력하면 성공한다.")
    @Test
    void createRightLotto(){
        Lotto lotto = new Lotto(List.of(1, 2, 5, 45, 23, 24));
        assertThat(lotto.getNumbers()).size().isEqualTo(6);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_SAME_WITH_LOTTO_SIZE.getMessage(LOTTO_SIZE));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CONSIST_OF_DUPLICATE_NUMBER.getMessage());
    }
    @DisplayName("1부터 45사이의 범위를 넘어간 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER));
    }

    @DisplayName("1부터 45사이의 범위를 넘어간 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER));
    }

}