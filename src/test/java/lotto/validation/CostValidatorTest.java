package lotto.validation;

import lotto.property.ErrorProperty;
import lotto.validation.validator.CostValidator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CostValidatorTest {

    @Test
    void 구입_금액_1000원단위로_떨어지지_않는_경우_검증_로직_테스트(){
        //given
        String inputPurchaseCost = "12345";

        //when
        assertThatThrownBy(()->{
                CostValidator.CostFormatIsCorrect(inputPurchaseCost);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorProperty.COST_FORMAT_IS_NOT_CORRECT.toString());
    }
}
