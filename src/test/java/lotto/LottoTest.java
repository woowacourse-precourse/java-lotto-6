package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        //Given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map(LottoNumber::of)
                .toList();

        //When & Then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_LENGTH_ERROR.getMessage(),
                        NumberType.LOTTO_LENGTH.getValue());
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        //Given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 5)
                .map(LottoNumber::of)
                .toList();

        //When & Then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_HAS_DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 개수가 6이고 로또 번호에 1 ~ 45범위 외의 숫자가 없고 중복이 없으면 예외가 발생하지 않는다 ")
    void createLottoWithNoException() {
        //Given
        List<LottoNumber> lottoNumbers = Stream.of(NumberType.MIN_LOTTO_NUMBER.getValue(), 2, 3, 4, 5,
                        NumberType.MAX_LOTTO_NUMBER.getValue())
                .map(LottoNumber::of)
                .toList();

        //When & Then
        assertDoesNotThrow(() -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("발행한 로또와 당첨 번호의 일치하는 숫자의 개수를 확인한다.")
    void countMatchNumberTest() {
        //Given
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList());
        Lotto answerLotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList());
        LottoNumber bonusNumber = LottoNumber.of(7);

        //When
        int expectedResult = 6;
        int result = lotto.countMatchNumber(answerLotto);

        //When & Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"6, true", "7, false"}, delimiter = ',')
    @DisplayName("발행한 로또에 당첨 번호의 숫자가 포함되는지 확인한다.")
    void bonusNumberInLottoTest(int bonusNumber, boolean expectedResult) {
        //Given
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList());

        //When
        boolean result = lotto.hasNumber(bonusNumber);

        //When & Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
