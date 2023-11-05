package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceValidatorTest {

    @Test
    @DisplayName("1000배수 테스트")
    void validateThousandTest(){
        // given
        int price = 1001;
        // when
        boolean check = price%1000==0;
        // then
        Assertions.assertThat(check).isEqualTo(false);
    }
}
