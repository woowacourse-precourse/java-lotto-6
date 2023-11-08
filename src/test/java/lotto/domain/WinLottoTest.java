package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {

    @Test
    @DisplayName("당첨 기준에 부합하는 결과와 집계가 같지 않을 시 실패")
    void getWinResult() {
        List<Integer> testCases = Arrays.asList(new Integer[]{3, 10, 4, 11, 5, 5, 12, 12, 6, 6});
        WinLotto winLotto = new WinLotto(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6"}));
        assertEquals(winLotto.getWinResult(testCases),
                Arrays.asList(new Integer[]{2, 2, 2, 2, 2}));
    }

    @Test
    @DisplayName("당첨 기준 결과 출력이 올바르지 않을 시 실패")
    void getWinString() {
        List<Integer> testCases = Arrays.asList(new Integer[]{2, 2, 2, 2, 2});
        WinLotto winLotto = new WinLotto(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6"}));
        assertEquals(winLotto.getWinString(testCases),
                "3개 일치 (5,000원) - 2개\n" +
                        "4개 일치 (50,000원) - 2개\n" +
                        "5개 일치 (1,500,000원) - 2개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                        "6개 일치 (2,000,000,000원) - 2개");
    }
}