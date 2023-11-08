package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.stream.Stream;
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
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map(LottoNumber::of)
                .toList();

        //When & Then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_LENGTH_ERROR.getMessage(),
                        NumberType.LOTTO_LENGTH.getValue());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
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

    @DisplayName("로또 번호의 개수가 6이고 로또 번호에 1 ~ 45범위 외의 숫자가 없고 중복이 없으면 예외가 발생하지 않는다 ")
    @Test
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
        WinningInformation winningInformation = new WinningInformation(answerLotto, bonusNumber);

        //When
        int expectedResult = 6;
        int result = lotto.countMatchNumber(winningInformation.getAnswerLotto());

        //When & Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("발행한 로또에 당첨 번호의 숫자가 포함되는지 확인한다.")
    @Test
    void bonusNumberInLottoTest() {
        //Given
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList());
        LottoNumber bonusNumber = LottoNumber.of(6);

        //When
        boolean expectedResult = true;
        boolean result = lotto.hasNumber(bonusNumber.getNumber());

        //When & Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
