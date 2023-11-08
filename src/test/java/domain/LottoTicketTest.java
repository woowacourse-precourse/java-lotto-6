package domain;

import domain.Lotto;

import domain.result.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoTicket 클래스 테스트")
public class LottoTicketTest {

    private LottoTicket bonusLottoTicket;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        bonusLottoTicket = LottoTicket.bonusTicketOf(lotto, bonusNumber);
    }

    @Test
    @DisplayName("getWinningResult_2등_판정_테스트")
    void testSecondGetWinningResult() {
        LottoTicket normalLottoTicket = LottoTicket.normalTicketFrom(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
        WinningResult result = this.bonusLottoTicket.getWinningResult(normalLottoTicket);

        assertThat(WinningResult.SECOND).isEqualTo(result);
    }

    @Test
    @DisplayName("getWinningResult_3등_판정_테스트")
    void testThirdGetWinningResult() {
        LottoTicket normatlLottoTicket = LottoTicket.normalTicketFrom(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 8)));
        WinningResult result = this.bonusLottoTicket.getWinningResult(normatlLottoTicket);

        assertThat(WinningResult.THIRD).isEqualTo(result);
    }

    @Test
    @DisplayName("getMatchedCount 메소드 테스트")
    void testGetMatchedCount() {
        int matchedCount = bonusLottoTicket.getMatchedCount(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));

        assertThat(matchedCount).isEqualTo(3);
    }

    @Test
    @DisplayName("isMatchBonus_일치_메소드_테스트")
    void testTrueIsMatchBonus() {
        boolean isMatch = bonusLottoTicket.isMatchBonus(6);

        assertThat(isMatch).isEqualTo(true);
    }

    @Test
    @DisplayName("isMatchBonus_일치_메소드_테스트")
    void testFalseIsMatchBonus() {
        boolean isMatch = bonusLottoTicket.isMatchBonus(7);

        assertThat(isMatch).isEqualTo(false);
    }
}
