package lotto.validator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private String ERROR = "[ERROR]";
    private static final String NULL_ERROR_MESSAGE = "금액을 입력해주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private static final String BLANK_ERROR_MESSAGE = "공백 없이 입력해주세요.";
    private static final String DIVISION_ERROR_MESSAGE = "1,000 단위로 입력해주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자를 적으면 안 됩니다.";
    private static final String SIZE_OVER_MESSAGE = "6개의 번호를 입력해주세요.";
    private static final String RANGE_OVER_MESSAGE = "1~45사이의 번호를 입력해주세요.";
    private static final String UNDER_1000_MESSAGE = "1,000 이상으로 입력해주세요.";
    private MoneyValidator inputMoneyValidator;
    private WinningNumValidator winningNumValidator;

    @Test
    void 값_미전달_예외_처리_테스트(){
        String input = "";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NULL_ERROR_MESSAGE);
    }

    @Test
    void 공백_포함_예외_처리_테스트(){
        String input = "ad sf";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+BLANK_ERROR_MESSAGE);
    }

    @Test
    void 입력_값_숫자_판별_예외_처리_테스트(){
        String input = "adsf";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 입력_값_1000_미만_예외_처리_테스트(){
        String input = "999";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+UNDER_1000_MESSAGE);
    }

    @Test
    void 입력_값_1000_배수_예외_처리_테스트(){
        String input = "1001";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+DIVISION_ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_숫자_외_입력_예외_처리_테스트(){
        String input = "1,2,3,a,5";
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_Size_초과_예외_처리_테스트(){
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+SIZE_OVER_MESSAGE);
    }

    @Test
    void 당첨_번호_Size_미달_예외_처리_테스트(){
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+SIZE_OVER_MESSAGE);
    }

    @Test
    void 당첨_번호_중복_예외_처리_테스트(){
        List<Integer> input = List.of(1, 1, 3, 4, 5, 6);
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_범위_예외_처리_테스트(){
        List<Integer> input = List.of(1, 49, 3, 4, 5, 6);
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+RANGE_OVER_MESSAGE);
    }

}
