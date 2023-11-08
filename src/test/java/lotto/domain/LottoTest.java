package lotto.domain;

import static lotto.constants.ErrorMessage.INVALID_SIZE;
import static lotto.constants.ErrorMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constants.LottoOption.END_LOTTO_NUMBER;
import static lotto.constants.LottoOption.LOTTO_COUNT;
import static lotto.constants.LottoOption.START_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoWithInvalidSize() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5); // 크기 부적합
        assertThatThrownBy(() -> Lotto.from(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_SIZE.getMessage(), LOTTO_COUNT.getValue()));
    }

    @DisplayName("올바른 크기의 로또 번호 목록으로 Lotto 객체를 생성할 수 있다.")
    @Test
    void createLottoWithValidSize() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(validNumbers);
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrderElementsOf(validNumbers);
    }

    @DisplayName("범위를 벗어나는 번호가 있는 로또 번호 목록으로 Lotto 객체를 생성하면 예외가 발생한다.")
    @Test
    void createLottoWithOutOfRangeNumbers() {
        List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, 50); // 범위를 벗어난 번호 포함
        assertThatThrownBy(() -> Lotto.from(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(NUMBER_OUT_OF_RANGE.getMessage(), START_LOTTO_NUMBER.getValue(),
                        END_LOTTO_NUMBER.getValue()));
    }

    @DisplayName("Lotto 객체가 올바른 번호를 반환한다.")
    @Test
    void getLottoNumbers() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(validNumbers);
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrderElementsOf(validNumbers);
    }
}