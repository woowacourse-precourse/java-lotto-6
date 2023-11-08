package lotto.result;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    private LottoResult lottoResult;
    private int money = 8000;
    // System.out 값을 테스트할 객체
    private OutputStream output;

    @BeforeEach
    void setUp() {
        // LottoResult 초기화
        lottoResult = new LottoResult(money);
        output = new ByteArrayOutputStream();
    }

    @DisplayName("로또 당첨 타입의 갯수를 올리는 메서드 테스트")
    @Test
    void testIncrementCount() {
        // When
        lottoResult.incrementCount(LottoResultType.THREE);

        // Then
        assertEquals(1, lottoResult.getCount(LottoResultType.THREE));
        assertEquals(0, lottoResult.getCount(LottoResultType.FOUR));
    }

    @DisplayName("수익률 계산 반올림 테스트")
    @Test
    void testCalculateRateOfReturnRounds() {
        /**
         * Given
         * THREE: 3
         * 총 당첨 금액: 5,000 + 5,000 + 5,000 = 15,000
         * 수익률 : ( 15,000 / 7,000 ) * 100 = 214.28571%
         *  */
        lottoResult = new LottoResult(7000);
        lottoResult.incrementCount(LottoResultType.THREE);
        lottoResult.incrementCount(LottoResultType.THREE);
        lottoResult.incrementCount(LottoResultType.THREE);

        // When & Then
        double expectedRateOfReturn = 214.3;

        assertEquals(expectedRateOfReturn, lottoResult.calculateRateOfReturn());
    }

    @DisplayName("모두 당첨 됐을 때 수익률 계산 테스트")
    @Test
    void testCalculateRateOfReturn() {
        /**
         * Given
         * THREE: 1, FOUR: 1, FIVE: 1, FIVE_PLUS_BONUS: 1, SIX: 1
         * 총 당첨 금액: 5,000 + 50,000 + 1,500,000 + 30,000,000 + 2,000,000,000 = 2,031,555,000
         * 수익률 : ( 2,031,555,000 / 8,000 ) * 100 = 25394437.5%
         *  */
        lottoResult.incrementCount(LottoResultType.THREE);
        lottoResult.incrementCount(LottoResultType.FOUR);
        lottoResult.incrementCount(LottoResultType.FIVE);
        lottoResult.incrementCount(LottoResultType.FIVE_PLUS_BONUS);
        lottoResult.incrementCount(LottoResultType.SIX);

        // When & Then
        double expectedRateOfReturn = 25394437.5;

        assertEquals(expectedRateOfReturn, lottoResult.calculateRateOfReturn());
    }

    @DisplayName("아무것도 당첨 되지 않을 경우, 수익률 0.0%")
    @Test
    void testCalculateRateOfReturnWithNoWinnings() {
        double expectedRateOfReturn = 0.0;

        assertEquals(expectedRateOfReturn, lottoResult.calculateRateOfReturn());
    }

    @DisplayName("전체 당첨 내역 출력 테스트")
    @Test
    void testPrintAllLottoResult() {
        /**
         * Given
         * THREE: 2, SIX: 1
         *  */
        lottoResult.incrementCount(LottoResultType.THREE);
        lottoResult.incrementCount(LottoResultType.THREE);
        lottoResult.incrementCount(LottoResultType.SIX);

        List<String> expecteds = new ArrayList<>();
        expecteds.add("3개 일치 (5,000원) - 2개");
        expecteds.add("4개 일치 (50,000원) - 0개");
        expecteds.add("5개 일치 (1,500,000원) - 0개");
        expecteds.add("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        expecteds.add("6개 일치 (2,000,000,000원) - 1개");

        // When
        System.setOut(new PrintStream(output));
        lottoResult.printAllLottoResult();

        // Then
        for(String expected: expecteds) {
            assertTrue(output.toString().trim().contains(expected));
        }
    }

    @Test
    void testPrintRateOfReturn() {
        // Given
        // 수익률: (5000 / 8000) * 100 = 62.5
        lottoResult.incrementCount(LottoResultType.THREE);

        StringBuilder expected = new StringBuilder();
        expected.append("총 수익률은 62.5%입니다.");

        // When
        System.setOut(new PrintStream(output));
        lottoResult.printRateOfReturn();

        // Then
        assertTrue(output.toString().trim().contains(expected));
    }
}
