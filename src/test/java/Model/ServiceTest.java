package Model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    @DisplayName("구입 금액이 1,000 단위가 아닐 때 예외 발생")
    @Test
    void priceUnit() {
        Domain domain = Domain.getInstance();
        int wrongPrice = 1050;

    }
}
