package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class WinningInformationTest {

    @Test
    void 당첨번호_중복_예외_처리_테스트() {
        //Given
        List<LottoNumber> answerLottoNumbers = Stream.of(1, 2, 3, 3, 5, 6)
                .map(LottoNumber::of)
                .toList();
        LottoNumber bonusNumber = LottoNumber.of(7);

        //When & Then
        assertThatThrownBy(() -> new WinningInformation(new Lotto(answerLottoNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_HAS_DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @Test
    void 당첨번호_길이_예외_처리_테스트() {
        //Given
        List<LottoNumber> answerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6, 8)
                .map(LottoNumber::of)
                .toList();
        LottoNumber bonusNumber = LottoNumber.of(7);

        //When & Then
        assertThatThrownBy(() -> new WinningInformation(new Lotto(answerLottoNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.LOTTO_LENGTH_ERROR.getMessage(),
                        NumberType.LOTTO_LENGTH.getValue()));
    }

    @Test
    void 보너스_번호가_당첨번호에_포함된다면_예외_처리_테스트() {
        //Given
        List<LottoNumber> answerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList();
        LottoNumber bonusNumber = LottoNumber.of(6);

        //When & Then
        assertThatThrownBy(() -> new WinningInformation(new Lotto(answerLottoNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_IN_ANSWER_LOTTO_ERROR.getMessage());
    }
}
