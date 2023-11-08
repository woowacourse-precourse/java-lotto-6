package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoManagerTest {
    private LottoManager lottoManager;

    @BeforeEach
    void setup() {
        lottoManager = new LottoManager(5000);
    }

    @DisplayName("주어진 금액만큼 로또를 발매하는지 확인한다.")
    @Test
    void testIssueLottos() {
        lottoManager.issueLottos();
        int expectedTicketCount = 5;
        assertEquals(expectedTicketCount, lottoManager.getLottoTicketCount());
    }

    @DisplayName("당첨 번호, 보너스 번호 매칭 여부에 따라 적절한 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:RANK1",
            "1,2,3,4,5,7:6:RANK2",
            "1,2,3,4,5,7:8:RANK3",
            "1,2,3,4,7,8:5:RANK4",
            "1,2,3,7,8,9:10:RANK5",
            "1,2,7,8,9,10:3:NONE"}, delimiter = ':')
    void testDetermineLottoRank(String winningNumbers, int bonusNumber, LottoRank expectedRank) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> changedWinningNumbers = Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

        LottoRank rank = lottoManager.determineLottoRank(lotto, changedWinningNumbers, bonusNumber);

        assertEquals(expectedRank, rank);
    }

}

