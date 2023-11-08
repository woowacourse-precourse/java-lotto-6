package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.ANSWER_AMOUNT_EXCEPTION_MSG.getMsg());
    }

    @DisplayName("로또 번호의 개수가 6개 보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByLessSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.ANSWER_AMOUNT_EXCEPTION_MSG.getMsg());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.ANSWER_DUPLICATED_EXCEPTION_MSG.getMsg());
    }

    @DisplayName("로또 번호에 1부터 45사이의 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void createLottoByRangeOutNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NUMBER_RANGE_EXCEPTION_MSG.getMsg());
    }

    @DisplayName("로또 번호에 대한 getter는 불변 리스트를 반환한다. 이를 수정할 경우 오류가 발생한다.")
    @Test
    void provideUnmodifiableListByGetter() {
        Lotto mockTicket = new Lotto(List.of(1, 2, 3, 4, 30, 35));
        List<Integer> unmodifiableNumbers = mockTicket.getNumbers();
        assertThatThrownBy(() -> unmodifiableNumbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("로또 번호 객체는 매개변수로 주어진 정답과 번호를 비교한 뒤 결과를 반환한다.")
    @Test
    void getResultByCompareNumberToAnswer() {
        Answer mockAnswer = createMockAnswer();
        Lotto mockTicket = new Lotto(List.of(1, 2, 3, 4, 30, 35));
        assertThat(mockTicket.compareNumberToAnswer(mockAnswer)).isInstanceOf(Result.class);
    }

    @DisplayName("로또 번호 내부에 해당 번호가 존재하는지 확인한 뒤 결과를 반환한다.")
    @Test
    void findNumberInLottoNumbers() {
        Lotto mockTicket = new Lotto(List.of(1, 2, 3, 4, 30, 35));
        assertThat(mockTicket.findNumber(4)).isEqualTo(true);
    }

    private Answer createMockAnswer() {
        Lotto hitNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        return new Answer(hitNumbers, bonusNumber);
    }
}