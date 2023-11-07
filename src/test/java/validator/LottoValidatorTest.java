package validator;

import static consts.ErrorMessage.DUPLICATED_NUMBER;
import static consts.ErrorMessage.INVALID_NUMBER_COUNT;
import static consts.ErrorMessage.INVALID_RANGE;
import static consts.ErrorMessage.NON_NUMERIC_VALUE;
import static consts.NumericConfig.END_INCLUSIVE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import model.dto.AnswerLottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    private LottoValidator validator;

    @BeforeEach
    void init() {
        validator = new LottoValidator();
    }

    @Test
    void 지정된_범위_외_숫자에_대한_예외_테스트() {
        // given
        int num = END_INCLUSIVE.number() + 1;

        // when & then
        assertAll(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    validator.validateNumber(num);
                });
            assertEquals(INVALID_RANGE.message(), exception.getMessage());
        });
    }

    @Test
    void 중복된_숫자가_있는_리스트에_대해_예외_처리_테스트() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertAll(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    validator.validateLottoNumbers(numbers);
                });
            assertEquals(DUPLICATED_NUMBER.message(), exception.getMessage());
        });
    }

    @Test
    void 로또_숫자의_개수가_지정된_수보다_적거나_클_경우_예외_처리_테스트() {
        // given
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> numbers2 = List.of(1, 2, 3, 4);

        // when & then
        assertAll(() -> {
            IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> {
                    validator.validateLottoNumbers(numbers1);
                });
            assertEquals(INVALID_NUMBER_COUNT.message(), exception1.getMessage());

            IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> {
                    validator.validateLottoNumbers(numbers2);
                });
            assertEquals(INVALID_NUMBER_COUNT.message(), exception2.getMessage());
        });
    }

    @Test
    void 숫자가_아닌_문자가_들어왔을_때_예외_처리_테스트() {
        // given
        AnswerLottoNumbers inputNumbers = new AnswerLottoNumbers("1,2,3,4,5,six");

        // when & then
        assertAll(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    validator.validateAnswerNumbers(inputNumbers);
                });
            assertEquals(NON_NUMERIC_VALUE.message(), exception.getMessage());
        });
    }
}
