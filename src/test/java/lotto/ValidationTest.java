package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    private final Validation validation = new Validation();

    @Test
    @DisplayName("숫자 외에 다른 문자가 있으면 예외가 발생한다.")
    void createPurchaseWithNonNumber() {
        String inputString = "1000j";

        assertThatThrownBy(() -> validation.isAllNumber(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ALL_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void createPurchaseNotDivisibleByThousand() {
        int purchaseAmount = 2500;

        assertThatThrownBy(() -> validation.isDivisibleByThousand(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.DIVISIBLE_BY_THOUSAND_ERROR.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    void isBetweenRangeNumberWhenNumberIsNotInRange() {
        assertThatThrownBy(() -> validation.isBetweenRangeNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.BETWEEN_RANGE_ERROR.getMessage());

        assertThatThrownBy(() -> validation.isBetweenRangeNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.BETWEEN_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void isNotDuplicatedWhenNumberIsDuplicated() {
        int duplicatedNumber = 33;
        List<Integer> numbers = Arrays.asList(5, 12, 23, 33, 42);

        assertThatThrownBy(() -> validation.isNotDuplicated(duplicatedNumber, numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.DUPLICATED_ERROR.getMessage());
    }
}
