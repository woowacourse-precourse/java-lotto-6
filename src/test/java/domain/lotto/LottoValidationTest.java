package domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import domain.LottoValidation;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoValidationTest {

    @Test
    void 당첨번호에_중복이_있는지_확인한다() {
        //given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 12;

        //when
        Throwable result = catchThrowable(() -> {
            new LottoValidation(integers, bonusNumber);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_당첨번호가_6자리가_아니라면_예외를_발생한다() {
        //given
        List<Integer> integers1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> integers2 = List.of(1, 2, 3);
        int bonusNumber = 12;

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoValidation(integers1, bonusNumber);
        });
        Throwable result2 = catchThrowable(() -> {
            new LottoValidation(integers2, bonusNumber);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_당첨번호에_포함되어_있다면_예외를_발생한다() {
        //given
        int bonusNumber = 5;
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Throwable result = catchThrowable(() -> {
            new LottoValidation(integers, bonusNumber);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호는_1이상_45이하의_자연수이다() {
        //given
        int bonusTest1 = 0;
        int bonusTest2 = 46;
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Throwable result1 = catchThrowable(() -> {
            new LottoValidation(integers, bonusTest1);
        });
        Throwable result2 = catchThrowable(() -> {
            new LottoValidation(integers, bonusTest2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }
}
