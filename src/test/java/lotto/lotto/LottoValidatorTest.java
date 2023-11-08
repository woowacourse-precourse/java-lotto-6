package lotto.lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {


    @Test
    public void 유효한_번호들을_검증한다() {
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45);
        assertDoesNotThrow(() -> LottoValidator.validateNumbers(numbers));
    }

    @Test
    public void 중복된_번호가_있으면_예외를_던진다() {
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 40);
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateNumbers(numbers));
    }

    @Test
    public void 잘못된_크기의_리스트를_검증하면_예외를_던진다() {
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40);
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateNumbers(numbers));
    }

    @Test
    public void 로또번호의_최소값보다_작은_번호_입력_시_에러발생() {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateNumber(0));
    }

    @Test
    public void 로또번호의_최대값보다_큰_번호_입력_시_에러발생() {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateNumber(46));
    }

    @Test
    public void 범위를_벗어나는_번호들을_검증하면_예외를_던진다() {
        List<Integer> numbers = Arrays.asList(-1, 0, 46, 47, 100, 200);
        numbers.forEach(number ->
                assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateNumber(number))
        );
    }

}