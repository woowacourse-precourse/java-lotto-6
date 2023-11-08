package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {
    // price getter test
    @Test
    void getPrize() {
        int result1 = Prize.First.getPrize();
        assertThat(result1).isEqualTo(2000000000);

        int result2 = Prize.Second.getPrize();
        assertThat(result2).isEqualTo(30000000);

        int result3 = Prize.Third.getPrize();
        assertThat(result3).isEqualTo(1500000);

        int result4 = Prize.Fourth.getPrize();
        assertThat(result4).isEqualTo(50000);

        int result5 = Prize.Fifth.getPrize();
        assertThat(result5).isEqualTo(5000);

        int result6 = Prize.None.getPrize();
        assertThat(result6).isEqualTo(0);
    }

    // message getter test
    @Test
    void getMessage() {
        String result1 = Prize.First.getMessage();
        assertThat(result1).isEqualTo("6개 일치");

        String result2 = Prize.Second.getMessage();
        assertThat(result2).isEqualTo("5개 일치, 보너스 볼 일치");

        String result3 = Prize.Third.getMessage();
        assertThat(result3).isEqualTo("5개 일치");

        String result4 = Prize.Fourth.getMessage();
        assertThat(result4).isEqualTo("4개 일치");

        String result5 = Prize.Fifth.getMessage();
        assertThat(result5).isEqualTo("3개 일치");

        String result6 = Prize.None.getMessage();
        assertThat(result6).isEqualTo("해당 없음");
    }

    // values() test
    @Test
    void testValues() {
        Prize[] prizes = Prize.values();
        assertEquals(Prize.values().length, 6); // Prize 열거형은 5개의 상수를 가져야 합니다.

        for (Prize prize : prizes) {
            System.out.println(prize); // 상수 이름 출력
        }
    }

    // valuesOf() test
    @Test
    void testValueOf() {
        Prize firstPrize = Prize.valueOf("First");
        assertEquals(firstPrize, Prize.First);

        // 유효하지 않은 상수 이름을 사용한 경우 IllegalArgumentException 예외가 발생해야 합니다.
        assertThrows(IllegalArgumentException.class, () -> {
            Prize invalidPrize = Prize.valueOf("InvalidPrize");
        });
    }
}