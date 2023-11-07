package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    private final Validation validation = new Validation();

    @Test
    @DisplayName("숫자 외에 다른 문자가 있으면 예외가 발생한다.")
    void createPurchaseWithNonNumber() {
        String inputString = "abc";

        assertThatThrownBy(() -> validation.isAllNumber(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바른 숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void createPurchaseNotDivisibleByThousand() {
        int purchaseAmount = 2500;

        assertThatThrownBy(() -> validation.isDivisibleByThousand(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    void isBetweenRangeNumberWhenNumberIsNotInRange() {
        assertThatThrownBy(() -> validation.isBetweenRangeNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> validation.isBetweenRangeNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void isNotDuplicatedWhenNumberIsDuplicated() {
        int duplicatedNumber = 33;
        List<Integer> numbers = Arrays.asList(5, 12, 23, 33, 42);

        assertThatThrownBy(() -> validation.isNotDuplicated(duplicatedNumber, numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
