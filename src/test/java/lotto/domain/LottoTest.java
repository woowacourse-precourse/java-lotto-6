package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import lotto.constant.ErrorMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("유효한 로또 번호로 로또 객체 생성")
    public void testValidLottoCreation() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.numbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("로또 번호의 개수가 잘못된 경우 예외 발생")
    public void testLottoWithInvalidSize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(numbers))
            .withMessage(ErrorMessage.INVALID_NUMBER_OF_LOTTO_NUMBERS.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 범위가 잘못된 경우 예외 발생")
    public void testLottoWithOutOfRangeNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 50);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(numbers))
            .withMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("중복된 로또 번호가 있는 경우 예외 발생")
    public void testLottoWithDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(numbers))
            .withMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
    }
}
