package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PriceConstantTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void 객체가_생성되는지_확인(int winningCount) {
        PriceConstant priceConstant = PriceConstant.countWinningPlace(winningCount, false);
        assertThat(priceConstant).isNotNull();
    }
}
