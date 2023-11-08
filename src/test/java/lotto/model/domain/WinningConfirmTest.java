package lotto.model.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.domain.constants.PrizeConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class WinningConfirmTest {

    @DisplayName("당첨 통계를 제대로 가져오는지 확인한다.")
    @Test
    void setWinningConfirm() {
        // Arrange
        List<Integer> sixMatch = List.of(1, 2, 3, 4, 5, 6); // 당첨 번호
        Lotto lottoSixMatch = new Lotto(sixMatch);
        WinningNumbers winningNumbers = new WinningNumbers(lottoSixMatch, 7);
        // Assert
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTicket lottoTicket = new LottoTicket(4000);
                    List<Lotto> lottos = lottoTicket.getLottoTicket();
                    WinningConfirm winningConfirm = new WinningConfirm(lottos, winningNumbers);
                    assertThat(winningConfirm.getWinningCounts())
                            .containsEntry(PrizeConstants.SIX_MATCH, 1) // 6개 일치
                            .containsEntry(PrizeConstants.FIVE_MATCH_WITH_BONUS, 1) // 5 + 1 일치
                            .containsEntry(PrizeConstants.FIVE_MATCH, 1) // 5개 일치
                            .containsEntry(PrizeConstants.THREE_MATCH, 1); // 3개 일치
                },
                sixMatch, // 6개
                List.of(1, 2, 3, 4, 5, 7), // 5개 + 1개
                List.of(1, 2, 3, 4, 5, 9), // 5개
                List.of(10, 11, 12, 1, 2, 3) // 3개
        );
    }

}