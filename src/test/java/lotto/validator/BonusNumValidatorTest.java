package lotto.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumValidatorTest {

    private static final String ERROR = "[ERROR]";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private static final String RANGE_OVER_MESSAGE = "1~45사이의 번호를 입력해주세요.";
    private static final String NULL_ERROR_MESSAGE = "보너스 번호를 입력해주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "당첨 숫자들과 다른 숫자를 입력해주세요.";
    private BonusNumValidator bonusNumValidator;

    @Test
    void 보너스_숫자_미입력_예외_처리_테스트(){
        String bonusNum = "";
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumValidator = new BonusNumValidator(bonusNum, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NULL_ERROR_MESSAGE);
    }

    @Test
    void 숫자_외_입력_예외_처리_테스트(){
        String bonusNum = "asd";
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumValidator = new BonusNumValidator(bonusNum, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 보너스_숫자_범위_예외_처리_테스트(){
        String bonusNum = "49";
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumValidator = new BonusNumValidator(bonusNum, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+RANGE_OVER_MESSAGE);
    }

    @Test
    void 보너스_숫자_당첨_번호_중복_예외_처리_테스트(){
        String bonusNum = "6";
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumValidator = new BonusNumValidator(bonusNum, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+DUPLICATE_ERROR_MESSAGE);
    }
}
