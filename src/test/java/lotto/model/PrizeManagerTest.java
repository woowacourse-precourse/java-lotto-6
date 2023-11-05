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
        prize.calculatePrizesByPoints(points);
        List<Integer> prizes = prize.getPrizes();

        // 일치 여부 확인
        assertEquals(expectedPrizes, prizes);

    }

    @DisplayName("상금 목록에서 입력받은 등수의 갯수를 구한다.")
    @Test
    void getPrizeCountsTest() {
        //변수 생성
        PrizeManager prize = new PrizeManager();

        // 상금 목록 생성
        List<Integer> points = new ArrayList<>(List.of(7, 6, 6, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3, 3));
        prize.calculatePrizesByPoints(points);

        // 예상 출력값 저장
        List<Integer> expectedPrizeCounts = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // 기능 실행 및 실제 출력값 저장
        List<Integer> prizeCounts = prize.getPrizeCounts();

        // 일치 여부 확인
        assertEquals(expectedPrizeCounts, prizeCounts);
    }

    @DisplayName("소수점 둘째 자리에서 반올림한 수익률을 구한다.")
    @Test
    void getProfitRatio() {
        // 변수 생성
        PrizeManager prize = new PrizeManager();

        // 상금 생성
        List<Integer> points = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 3));
        prize.calculatePrizesByPoints(points);

        // 예상 출력값 저장
        double expectedRatio = 62.5;

        // 실제 출력값 저장
        double ratio = prize.getProfitRatio();

        // 일치 여부 확인
        assertEquals(expectedRatio, ratio);
    }

}
