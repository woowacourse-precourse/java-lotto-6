package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.Application.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMatchTest {
    @DisplayName("matchedCount 입력에 따른, 당첨 갯수 결과 확인 테스트")
    @Test
    void calculateMyMatchTest() {

        // 3개가 맞은 횟수 : 10
        for (int i = 0; i < 10; i++) {
            calculateMyMatch(3);
        }

        // 4개가 맞은 횟수 : 8
        for (int i = 0; i < 8; i++) {
            calculateMyMatch(4);
        }

        // 5개가 맞은 횟수 : 6
        for (int i = 0; i < 6; i++) {
            calculateMyMatch(5);
        }

        // 5개 + Bonus 가 맞은 횟수 : 4
        for (int i = 0; i < 2; i++) {
            calculateMyMatch(7);
        }

        // 4개가 맞은 횟수 : 2
        for (int i = 0; i < 2; i++) {
            calculateMyMatch(6);
        }

        System.out.println("3개 일치 (5,000원) - " + LottoWin.MATCHED_3.getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + LottoWin.MATCHED_4.getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + LottoWin.MATCHED_5.getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoWin.MATCHED_5_WITH_BONUS.getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + LottoWin.MATCHED_6.getCount() + "개");
    }


    @DisplayName("구매한 로또 번호와 당첨 번호의 match 수가 5개일 때, 보너스 번호 확인 테스트")
    @Test
    void calculateBonusNumberTest() {
        Application.bonusNumber = 14;
        List<Integer> LottoExample = Arrays.asList(1, 2, 3, 4, 5, 14);
        int result = calculateBonusNumber(LottoExample);
        int expected_result = LottoWin.MATCHED_5_WITH_BONUS.getMatchValue();
        assertEquals(result, expected_result);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호의 match 수 정상 return 확인 테스트")
    @Test
    void matchBonusCountTest() {
        Application.bonusNumber = 14;
        List<Integer> LottoExample = Arrays.asList(1, 2, 3, 4, 5, 14);
        int result = matchBonusCount(5, LottoExample);
        int expected_result = LottoWin.MATCHED_5_WITH_BONUS.getMatchValue();
        assertEquals(result, expected_result);
    }


    @DisplayName("구매한 로또 번호와 당첨번호 사이의 matchCount 정상 동작 Test")
    @Test
    void matchMyLottoTest() {
        Application.bonusNumber = 10;
        Application.lottoAnswer = Arrays.asList(4, 7, 12, 13, 26, 37);

        Lotto LottoExample = new Lotto(Arrays.asList(4, 7, 10, 12, 13, 26));

        int expected_result = LottoWin.MATCHED_5_WITH_BONUS.getMatchValue();

        int result = matchMyLotto(LottoExample);

        assertEquals(result, expected_result);
    }
}
