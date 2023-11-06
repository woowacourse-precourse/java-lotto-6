package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 5, 5, 6, 7));

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
        ArrayList<Integer> numbers = new ArrayList<>(
                List.of(1, 2, 3, 4, 5, NumberType.MAX_LOTTO_NUMBER.getValue() + 1));

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

    @DisplayName("발행한 로또에 당첨 번호의 숫자가 포함되는지 확인하는 기능 테스트")
    @Test
    void bonusNumberInLottoTest() {
        //Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6, new AnswerLotto(List.of(7, 8, 9, 10, 11, 12)));

        //When
        boolean expectedResult = true;
        boolean result = lotto.hasNumber(bonusNumber.getBonusNumber());

        //When & Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
