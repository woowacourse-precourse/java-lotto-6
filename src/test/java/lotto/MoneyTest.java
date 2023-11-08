package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @ParameterizedTest(name = "대상 문자열 : {0}")
    @ValueSource(strings = {"money", "20000원", "2000*", "2000.0", "1234", "-1000", "10 00"})
    @DisplayName("돈은 1000 단위의 양의 정수 또는 0 이어야 합니다.")
    void createMoneyByIllegalText(String test) {
        assertThatThrownBy(() -> new Money(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_MUST_POSITIVE_NUMBER_AND_1000_UNITS.getMessage());
    }

    private static List<Integer> givenNumbers(Integer... numbers) {
        return Arrays.stream(numbers)
                .collect(Collectors.toList());
    }
}
