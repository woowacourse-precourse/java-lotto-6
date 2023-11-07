package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuyerLottoHistoryTest {
    private BuyerLottoHistory buyerLottoHistory;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        buyerLottoHistory = new BuyerLottoHistory(2, List.of(lotto1, lotto2));
    }

    @Test
    void 구매된_로또_개수를_포맷팅한다() {
        assertThat(buyerLottoHistory.formatBuyerLottoCount())
                .isEqualTo("2개를 구매했습니다.");
    }

    @Test
    void 구매된_로또_번호들을_포맷팅한다() {
        assertThat(buyerLottoHistory.formatBuyerLottos())
                .isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]");
    }
}
