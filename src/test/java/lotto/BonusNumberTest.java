package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 보너스_번호가_당첨번호에_포함된다면_예외_처리_테스트() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        AnswerLotto answerLotto = new AnswerLotto(numbers);

        //When & Then
        assertThatThrownBy(() -> new BonusNumber(1, answerLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_IN_ANSWER_LOTTO_ERROR.getMessage());
    }

    @Test
    void 범위_외_보너스_숫자_예외_처리_테스트() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        AnswerLotto answerLotto = new AnswerLotto(numbers);

        //When & Then
        assertThatThrownBy(() -> new BonusNumber(50, answerLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage(),
                        NumberType.MIN_LOTTO_NUMBER.getValue(), NumberType.MAX_LOTTO_NUMBER.getValue()));
    }
}
