package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeManagerTest {


    @DisplayName("입력받은 점수를 토대로 상금을 목록에 추가한다.")
    @Test
    void checkTicketAndAddPrizes() {
        //변수 생성
        PrizeManager prize = new PrizeManager();

        // 입력값 생성
        List<Integer> points = new ArrayList<>(List.of(7, 6, 5, 4, 3));

        // 예상 출력값 저장
        List<Integer> expectedPrizes = new ArrayList<>(List.of(2000000000, 30000000, 1500000, 50000, 5000));

        // 기능 실행 및 결과 저장
        prize.checkTicketAndAddPrizes(points);
        List<Integer> prizes = prize.getPrizes();

        // 일치 여부 확인
        assertEquals(expectedPrizes, prizes);

    }

}
