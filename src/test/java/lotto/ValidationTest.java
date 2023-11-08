package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    Validation validation = new Validation();

    @Test
    void 숫자가_아닌_입력() {
        assertThatThrownBy(() ->
                validation.parsePurchaseAmount("this is not number"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가");
    }

    @Test
    void 영보다_작은_숫자() {
        assertThatThrownBy(() -> validation.validateUnderZero(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다");
    }

    @Test
    void 천단위_입력() {
        assertThatThrownBy(() -> validation.validateDivideThousand(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000");
    }
}
