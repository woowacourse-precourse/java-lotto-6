package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.ArrayList;
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

//    @DisplayName("발행한 로또에 당첨 번호의 숫자가 포함되는지 확인하는 기능 테스트")
//    @Test
//    void bonusNumberInLottoTest() {
//        //Given
//        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
//                .map(LottoNumber::of)
//                .toList());
//        BonusNumber bonusNumber = new BonusNumber(6, new AnswerLotto(List.of(7, 8, 9, 10, 11, 12)));
//
//        //When
//        boolean expectedResult = true;
//        boolean result = lotto.hasNumber(bonusNumber.getBonusNumber());
//
//        //When & Then
//        assertThat(result).isEqualTo(expectedResult);
//    }
}
