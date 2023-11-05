package lotto.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidatorTest {

    private static final String ERROR = "[ERROR]";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 로또 번호가 있습니다.";
    private static final String SIZE_OVER_MESSAGE = "로또 번호가 6개가 아닙니다.";
    private static final String RANGE_OVER_MESSAGE = "로또 번호가 1이상 45이하가 아닙니다.";
    private static final String NOT_SORT_MESSAGE = "로또가 오름차순이 아닙니다.";
    private LottoValidator validator;

    @Test
    void 로또_번호_중복_예외_처리_테스트(){
        List<Integer> input = List.of(1, 3, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator = new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    void 로또_번호_Size_예외_처리_테스트(){
        List<Integer> input = List.of(1, 3, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> validator = new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+SIZE_OVER_MESSAGE);
    }

    @Test
    void 로또_번호_범위_예외_처리_테스트(){
        List<Integer> input = List.of(1, 86, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator = new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+RANGE_OVER_MESSAGE);
    }

    @Test
    void 로또_번호_정렬_예외_처리_테스트(){
        List<Integer> input = List.of(1, 4, 3, 2, 5, 6);
        assertThatThrownBy(() -> validator = new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NOT_SORT_MESSAGE);
    }

}
