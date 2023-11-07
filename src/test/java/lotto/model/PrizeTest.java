package lotto.model;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
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

    @DisplayName("4등 당첨을 판별한다.")
    @Test
    void isPrizeFourth() {
        final int count = 4;
        final boolean isBonus = false;
        final Prize fourth = Arrays.stream(Prize.values())
                .filter(prize -> prize.judge(count, isBonus))
                .findFirst()
                .orElse(Prize.NONE);
        System.out.println("fourth = " + fourth);

        assertThat(output()).contains("4개 일치 (50,000원)");
    }

    @DisplayName("3등 당첨을 판별한다.")
    @Test
    void isPrizeThird() {
        final int count = 5;
        final boolean isBonus = false;
        final Prize third = Arrays.stream(Prize.values())
                .filter(prize -> prize.judge(count, isBonus))
                .findFirst()
                .orElse(Prize.NONE);
        System.out.println("third = " + third);

        assertThat(output()).contains("5개 일치 (1,500,000원)");
    }

    @Override
    protected void runMain() {

    }
}
