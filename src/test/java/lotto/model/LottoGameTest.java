package lotto.model;

import lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

class LottoGameTest {

    private MockedStatic<Lotto> mockedLotto;


    @BeforeEach
    void setUp() {
        mockedLotto = Mockito.mockStatic(Lotto.class);
    }

    @AfterEach
        // 여기서 @BeforeEach를 @AfterEach로 변경
    void tearDown() {
        if (mockedLotto != null) {
            mockedLotto.close(); // mockedLotto가 null이 아닐 때만 close() 메소드를 호출합니다.
        }
    }

    @Test
    @DisplayName("determineRank() 메서드는 올바른 등수를 반환해야 한다")
    void determineRank() {
        assertEquals(0, LottoGame.determineRank(2, false));
        assertEquals(5, LottoGame.determineRank(3, false));
        // ... 다른 케이스들을 위한 테스트를 추가합니다.
    }

    @Test
    @DisplayName("generatePurchasedLotto() 메서드는 요청된 수만큼의 로또를 생성해야 한다")
    void generatePurchasedLotto() {
        Lotto mockLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        mockedLotto.when(() -> Lotto.generate()).thenReturn(mockLotto);

        List<Lotto> purchasedLottos = LottoGame.generatePurchasedLotto(5);
        assertEquals(5, purchasedLottos.size());

    }

    @Test
    @DisplayName("calculateTotalWinnings() 메서드는 총 상금을 정확하게 계산해야 한다")
    void calculateTotalWinnings() {
        Map<Integer, Integer> winningsStats = Map.of(
                1, 1, // 1등 1번
                3, 5, // 3등 5번
                0, 10 // 비당첨 10번
        );
        long totalWinnings = LottoGame.calculateTotalWinnings(winningsStats);
        long expectedWinnings = (long) LottoGame.getPrizeMoneyMap().get(1) * 1
                + (long) LottoGame.getPrizeMoneyMap().get(3) * 5;
        assertEquals(expectedWinnings, totalWinnings);
    }

}