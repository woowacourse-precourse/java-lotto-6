package lotto.validatior;

import lotto.model.Lotto;
import lotto.validator.WinningNumbersValiator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersValiatorTest {

    @Test
    void 필수콤마비포함시_예외발생_테스트(){
        assertThatThrownBy(() -> WinningNumbersValiator
                .IsContainEssentialComma("1,2,3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 중복숫자포함시_예외발생_테스트(){
        assertThatThrownBy(() -> WinningNumbersValiator
                .checkIsNumberUnique(List.of(1,2,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 범위가아닌경우_예외발생_테스트(){
        assertThatThrownBy(() -> WinningNumbersValiator
                .checkIsInRange(48))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 당첨번호입력개수_초과시_예외발생_테스트(){
        assertThatThrownBy(() -> WinningNumbersValiator
                .checkBonusNumberLength("12,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
