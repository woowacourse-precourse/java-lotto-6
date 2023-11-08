package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Cost Domain 테스트")
public class CostTest {
    private Cost cost;
    private int INIT_VALUE = 10;

    @BeforeEach
    public void initTest() {
        cost = new Cost(INIT_VALUE);
    }

    @Test
    @DisplayName("Cost Domain이 성공적으로 생성된다.")
    public void createDomainTest() {
        // when - then
        Assertions.assertAll(
                () -> assertThat(cost.getValue()).isEqualTo(INIT_VALUE)
        );
    }
}
