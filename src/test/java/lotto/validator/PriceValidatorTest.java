package lotto.validator;

import static org.assertj.core.api.Assertions.*;

import lotto.config.IntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceValidatorTest {

    int max = 100000;
    int min = 1000;
    @Test
    @DisplayName("1000배수 테스트")
    void validateThousandTest() {
        // given
        int price = 1001;
        // when then
        assertThat(price%min==0).isEqualTo(false);
    }

    @Test
    @DisplayName("가격 범위 테스트")
    void validatePriceRangeTest() {
        // given
        int price = 9;
        int price2 = 100001;

        // when
        boolean result = price>=min && price<=max;
        boolean result2 = price2>=min && price2<=max;

        // then
        assertThat(result).isEqualTo(false);
        assertThat(result2).isEqualTo(false);
    }


}
