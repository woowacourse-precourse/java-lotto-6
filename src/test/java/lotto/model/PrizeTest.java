package lotto.model;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest extends NsTest {
    @DisplayName("5등 당첨을 판별한다.")
    @Test
    void isPrizeFifth() {
        final int count = 3;
        final boolean isBonus = false;
        final Prize fifth = Arrays.stream(Prize.values())
                .filter(prize -> prize.judge(count, isBonus))
                .findFirst()
                .orElse(Prize.NONE);
        System.out.println("fifth = " + fifth);

        assertThat(output()).contains("3개 일치 (5,000원)");
    }

    @Override
    protected void runMain() {

    }
}
