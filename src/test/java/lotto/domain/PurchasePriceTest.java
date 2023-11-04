package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PurchasePriceTest {

    @ParameterizedTest
    @MethodSource
    void 구매할_수_있는_로또의_개수를_구한다(int input, int expectCount) {
        //given
        PurchasePrice purchasePrice = PurchasePrice.from(input);
        //when
        int resultCount = purchasePrice.calculatePurchaseCount();
        //then
        assertThat(resultCount).isEqualTo(expectCount);
    }

    private static Stream<Arguments> 구매할_수_있는_로또의_개수를_구한다() {
        return Stream.of(
                Arguments.of(5000, 5),
                Arguments.of(50000, 50),
                Arguments.of(12000, 12),
                Arguments.of(2000, 2),
                Arguments.of(10000, 10)
        );
    }
}
