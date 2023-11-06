package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 5, 5, 6,7));

        //When & Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_LENGTH_ERROR.getMessage(),
                        NumberType.LOTTO_LENGTH.getValue());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        //When & Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_HAS_DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 1 ~ 45범위 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutRangeNumber() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, NumberType.MAX_LOTTO_NUMBER.getValue() + 1));

        //When & Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NOT_IN_RANGE_ERROR.getMessage(),
                        NumberType.MIN_LOTTO_NUMBER.getValue(), NumberType.MAX_LOTTO_NUMBER.getValue());
    }

    @DisplayName("로또 번호의 개수가 6이고 로또 번호에 1 ~ 45범위 외의 숫자가 없고 중복이 없으면 예외가 발생하지 않는다 ")
    @Test
    void createLottoWithNoException() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<>(
                List.of(NumberType.MIN_LOTTO_NUMBER.getValue(), 2, 3, 4, 5, NumberType.MAX_LOTTO_NUMBER.getValue()));

        //When & Then
        assertDoesNotThrow(() -> new Lotto(numbers));
    }
}
