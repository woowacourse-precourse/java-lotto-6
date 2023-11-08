package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeTest {

    @Test
    @DisplayName("번호 일치 갯수, 보너스 넘버 정답 여부에 따른 등수 반환 확인 테스트")
    void getPrize() {

        int compareCount = 5;
        boolean isMatchBonus = false;

        Prize prize = Prize.getPrize(compareCount, isMatchBonus);

        assertEquals(Prize.THIRD_GRADE, prize);
    }
}
