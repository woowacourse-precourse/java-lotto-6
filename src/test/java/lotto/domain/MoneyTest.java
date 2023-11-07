package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.domain.exception.DomainExceptionCode;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTest {


    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void 돈은_0보다_작을_수_없습니다(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(input))
                .withMessageContaining(DomainExceptionCode.MONEY_GRATER_THAN_ZERO.getMessage());
    }

    @Test
    void 수익률_계산() {
        final var margin = new Money(1000).calculateProfitMargin(new Money(200_000_000));
        System.out.printf("%s%%", BigDecimal.valueOf(margin).setScale(1, RoundingMode.HALF_UP));
    }

}