package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerTest {
    private static final Lotto mockHitNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호에 1부터 45사이의 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void bonusNumberRangeOut() {
        assertThatThrownBy(() -> new Answer(mockHitNumbers, 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NUMBER_RANGE_EXCEPTION_MSG.getMsg());
    }

    @DisplayName("당첨 번호에 기입한 숫자를 보너스 번호에 입력하면 예외가 발생한다.")
    @Test
    void bonusNumberConflictWithHitNumbers() {
        assertThatThrownBy(() -> new Answer(mockHitNumbers, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.BONUS_NUMER_CONFLICT_EXCEPTION_MSG.getMsg());
    }

    @DisplayName("정답 객체는 당첨 번호 내에 해당 번호가 존재하는지 확인한 후 결과를 반환한다.")
    @Test
    void provideNumberAndReturnExistFlag() {
        Answer answer = new Answer(mockHitNumbers, 7);
        assertThat(answer.isHitNumbersHaveThisNumber(3)).isEqualTo(true);
        assertThat(answer.isHitNumbersHaveThisNumber(20)).isEqualTo(false);
    }

    @DisplayName("정답 객체는 보너스 번호가 해당 번호와 같은지 확인한 후 결과를 반환한다.")
    @Test
    void provideNumberAndReturnSameFlag() {
        Answer answer = new Answer(mockHitNumbers, 7);
        assertThat(answer.isBonusNumberTheSameAsThis(7)).isEqualTo(true);
        assertThat(answer.isBonusNumberTheSameAsThis(5)).isEqualTo(false);
    }
}
