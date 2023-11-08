package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utility.TestConstant.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Prize Domain 테스트")
public class PrizeTest {
    private Prize prize;

    @BeforeEach
    public void initTest() {
        prize = new Prize();
    }

    @Test
    @DisplayName("addPrize() method 테스트")
    public void addPrizeTest() {
        // when
        prize.addPrize(LOTTO_PRIZE.getConstant());

        // then
        assertThat(prize.getPrize()).isEqualTo(LOTTO_PRIZE.getConstant());
    }

    @Test
    @DisplayName("getPrize() method 테스트")
    public void getPrizeTest() {
        // when
        double prizeValue = prize.getPrize();

        // then
        assertThat(prizeValue).isEqualTo(CONSTANT_ZERO.getConstant());
    }
}
