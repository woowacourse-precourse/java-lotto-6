package util;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class ValidationTest {
    private final Validate validate = new Validate();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_구입_금액이_나누어_떨어지지_않는_경우(){
        assertSimpleTest(() -> assertThatThrownBy(() -> validate.CheckMoneyInput("1400"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void 로또_구입_금액이_숫자가_아닌_경우(){
        assertSimpleTest(() -> assertThatThrownBy(() -> validate.CheckMoneyInput("1400s"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void 로또_구입_금액에_빈칸이_있는_경우(){
        assertSimpleTest(() -> assertThatThrownBy(() -> validate.CheckMoneyInput("14 00s"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }


    @Test
    void 당첨_번호의_길이가_올바르지_않은_경우(){
        assertSimpleTest(() -> assertThatThrownBy(() -> validate.CheckWinningNumber("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void 당첨_번호가_숫자가_아닌_경우(){
        assertSimpleTest(() -> assertThatThrownBy(() -> validate.CheckMoneyInput("1,2,0,s,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void 당첨_번호가_범위_내에_없는_경우(){
        assertSimpleTest(() -> assertThatThrownBy(() -> validate.CheckMoneyInput("46,0,1,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void  당첨_번호에_빈칸이_있는_경우(){
        assertSimpleTest(() -> assertThatThrownBy(() -> validate.CheckMoneyInput("1,3 ,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }
}
