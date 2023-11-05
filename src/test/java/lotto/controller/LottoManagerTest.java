package lotto.controller;

import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoAnswer;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class LottoManagerTest {

    private static LottoManager lottoManager;
    private static MockedStatic<Randoms> randoms;

    @BeforeAll
    private static void beforeAll() {
        LottoAnswer lottoAnswer = new LottoAnswer(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        lottoManager = new LottoManager(lottoAnswer);
        randoms = mockStatic(Randoms.class);
    }

    @Test
    @DisplayName("등수 리스트가 잘 나오는 지 확인")
    void calculateResultsTest() {
        // given
        randoms.when(() -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .thenReturn(List.of(1, 2, 3, 4, 5, 6))  // 1등
                .thenReturn(List.of(1, 2, 3, 4, 5, 7))  // 2등
                .thenReturn(List.of(1, 2, 3, 4, 5, 8))  // 3등
                .thenReturn(List.of(1, 2, 3, 4, 8, 9))  // 4등
                .thenReturn(List.of(1, 2, 3, 7, 8, 9)); // 5등

        lottoManager.purchaseLottos(5);

        // when
        List<Rank> ranks = lottoManager.calculateResults();

        //then
        System.out.println(ranks);
    }
}
