package lotto.result;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTypeTest {
    private LottoResultType lottoResultType;
    // System.out 값을 테스트할 객체
    private OutputStream output;

    @BeforeEach
    public void setUp() {
        output = new ByteArrayOutputStream();
    }

    @DisplayName("5개의 번호가 정답이고 보너스도 맞췄을 경우, FIVE_PLUS_BONUS 타입 반환")
    @Test
    void fiveCorrectNumberAndBonus() {
        // Given & When
        lottoResultType = LottoResultType.findByCorrectNumberAndBonus(5, true);

        // Then
        assertEquals(LottoResultType.FIVE_PLUS_BONUS, lottoResultType);
    }

    @DisplayName("존재하지 않는 타입일 경우, null 반환")
    @Test
    void sevenCorrectNumberNoBonus() {
        // Given & When
        lottoResultType = LottoResultType.findByCorrectNumberAndBonus(7, false);

        // Then
        assertNull(lottoResultType);
    }

    @DisplayName("6개의 당첨 번호를 맞추고 보너스 번호는 틀렸을 경우, SIX 타입 반환")
    @Test
    void sixCorrectNumber() {
        // Given & When
        lottoResultType = LottoResultType.findByCorrectNumberAndBonus(6, false);

        // Then
        assertEquals(LottoResultType.SIX, lottoResultType);
    }

    @DisplayName("5개가 아닌 당첨 번호와 보너스 번호가 맞은 경우도, 당첨 번호에 해당하는 타입 반환")
    @Test
    void otherCorrectNumberAndBonus() {
        // Given & When
        lottoResultType = LottoResultType.findByCorrectNumberAndBonus(4, true);

        // Then
        assertEquals(LottoResultType.FOUR, lottoResultType);
    }

    @Test
    void print() {
        // Given: 3개의 당첨 resultType THREE
        lottoResultType = LottoResultType.findByCorrectNumberAndBonus(3, false);
        int correctCount = 1;       // 당첨 갯수

        // When
        StringBuilder expected = new StringBuilder();
        expected.append("3개 일치 (5,000원) - 1개");

        System.setOut(new PrintStream(output));

        lottoResultType.print(correctCount);

        // Then
        assertTrue(output.toString().trim().contains(expected));
    }
}