package lotto;

import static lotto.exception.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.number.Lotto;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호_개수가_6개_이상이면_예외가_발생한다() {
        //Arrange
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //Act //Assert
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_SIZE.getMessage());
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        //Arrange
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        //Act //Assert
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBERS.getMessage());
    }
}