package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

class AnswerLottoTest {

    @Test
    void 당첨번호_중복_예외_처리_테스트() {
        //Given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 3, 5, 6)
                .map(LottoNumber::of)
                .toList();
        LottoNumber bonusNumber = LottoNumber.of(7);

        //When & Then
        assertThatThrownBy(() -> new AnswerLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_HAS_DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @Test
    void 당첨번호_길이_예외_처리_테스트() {
        //Given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6, 8)
                .map(LottoNumber::of)
                .toList();
        LottoNumber bonusNumber = LottoNumber.of(7);

        //When & Then
        assertThatThrownBy(() -> new AnswerLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.LOTTO_LENGTH_ERROR.getMessage(),
                        NumberType.LOTTO_LENGTH.getValue()));
    }

    @Test
    void 발행한_로또와_당첨_번호의_일치하는_숫자의_개수_확인_테스트() {
        //Given
        System.out.println("test START");
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList());
        LottoNumber bonusNumber = LottoNumber.of(7);
        System.out.println("MIDDLE");
        AnswerLotto answerLotto = new AnswerLotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList(), bonusNumber);
        System.out.println("AA");

        //When
        int expectedResult = 6;
        int result = answerLotto.countMatchNumber(lotto);

        //When & Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 보너스_번호가_당첨번호에_포함된다면_예외_처리_테스트() {
        //Given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList();
        LottoNumber bonusNumber = LottoNumber.of(6);

        //When & Then
        assertThatThrownBy(() -> new AnswerLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_IN_ANSWER_LOTTO_ERROR.getMessage());
    }
}
