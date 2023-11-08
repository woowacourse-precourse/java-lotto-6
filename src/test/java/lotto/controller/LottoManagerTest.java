package lotto.controller;

import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class LottoManagerTest {

    private static MockedStatic<Randoms> randoms;
    private static MockedStatic<Console> console;

    @BeforeAll
    private static void beforeAll() {
        randoms = mockStatic(Randoms.class);
        console = mockStatic(Console.class);
    }

    @AfterAll
    private static void afterAll() {
        randoms.close();
        console.close();
    }

    @Test
    @DisplayName("등수 리스트가 잘 나오는 지 확인")
    void calculateResultsTest() {
        // given
        console.when(Console::readLine)
                .thenReturn("1,2,3,4,5,6")
                .thenReturn("7");

        randoms.when(() -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .thenReturn(List.of(1, 2, 3, 4, 5, 6))  // 1등
                .thenReturn(List.of(1, 2, 3, 4, 5, 7))  // 2등
                .thenReturn(List.of(1, 2, 3, 4, 5, 8))  // 3등
                .thenReturn(List.of(1, 2, 3, 4, 8, 9))  // 4등
                .thenReturn(List.of(1, 2, 3, 7, 8, 9)); // 5등

        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        LottoManager lottoManager = new LottoManager(purchaseAmount);

        // when
        List<Rank> ranks = lottoManager.calculateResults();

        //then
        System.out.println(ranks);
    }

    @Test
    @DisplayName("보너스 번호가 이미 당첨번호에 포함되어 있으면 입력을 다시 받는다.")
    void answerNumbersCantContainsBonusNumber() {
        console.when(Console::readLine)
                .thenReturn("1,2,3,4,5,6")
                .thenReturn("6")
                .thenReturn("7");
        PurchaseAmount purchaseAmount = new PurchaseAmount(5);
        LottoManager lottoManager = new LottoManager(purchaseAmount);
    }
}
