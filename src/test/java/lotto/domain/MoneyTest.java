package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTest {


    @ParameterizedTest()
    @ValueSource(ints = {-1, -2, -3})
    void 돈은_0보다_작을_수_없습니다(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(input));
    }

}