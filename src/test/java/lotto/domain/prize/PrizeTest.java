package lotto.domain.prize;

import lotto.domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @Test
    @DisplayName("Prize는 숫자 6개가 일치하면 1등을 출력해주어야 한다.")
    void 결과_1등_출력() {
        Result result = new Result(6, false);

        assertEquals(Prize.FIRST, Prize.findPrize(result));
    }


    @Test
    @DisplayName("Prize는 숫자 5개와 보너스가 일치하면 2등을 출력해주어야 한다.")
    void 결과_2등_출력() {
        Result result = new Result(5, true);

        assertEquals(Prize.SECOND, Prize.findPrize(result));
    }

    @Test
    @DisplayName("Prize는 숫자 5개가 일치하고, 보너스가 다르면 3등을 출력해주어야 한다.")
    void 결과_3등_출력() {
        Result result = new Result(5, false);

        assertEquals(Prize.THIRD, Prize.findPrize(result));
    }

    @Test
    @DisplayName("Prize는 숫자 4개가 일치하면 1등을 출력해주어야 한다.")
    void 결과_4등_출력() {
        Result result = new Result(4, true);

        assertEquals(Prize.FOURTH, Prize.findPrize(result));
    }

    @Test
    @DisplayName("Prize는 숫자 3개가 일치하면 1등을 출력해주어야 한다.")
    void 결과_5등_출력() {
        Result result = new Result(3, true);

        assertEquals(Prize.FIFTH, Prize.findPrize(result));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("Prize는 숫자 3이하로 일치하면 꼴등을 출력해주어야 한다.")
    void 결과_NONE_출력(int count) {
        Result result = new Result(count, true);

        assertEquals(Prize.NONE, Prize.findPrize(result));
    }

    @Test
    @DisplayName("Prize의 상금을 출력해줄 수 있어야 한다. 1등")
    void 상금_출력_1등() {
        assertEquals(2000000000, Prize.FIRST.getProfit());
    }

    @Test
    @DisplayName("Prize의 상금을 출력해줄 수 있어야 한다. 5등")
    void 상금_출력_5등() {
        assertEquals(5000, Prize.FIFTH.getProfit());
    }

    @Test
    @DisplayName("Prize는 당첨 메세지를 출력해줄 수 있어야 한다. 1등")
    void 당첨_메세지_출력_1등() {
        assertEquals("6개 일치 (2,000,000,000원) - ", Prize.FIRST.getMsg());
    }

    @Test
    @DisplayName("Prize는 당첨 메세지를 출력해줄 수 있어야 한다. 5등")
    void 당첨_메세지_출력_5등() {
        assertEquals("3개 일치 (5,000원) - ", Prize.FIFTH.getMsg());
    }
}