package lotto;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoPrizeConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.enums.LottoConstants.LOTTO_PRICE;
import static lotto.enums.LottoPrizeConstants.BONUS_PRIZE;
import static lotto.enums.LottoPrizeConstants.FIVE_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.FOUR_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.SIX_MATCH_PRIZE;
import static lotto.enums.LottoPrizeConstants.THREE_MATCH_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("로또 구매 수량과 lottos의 크기가 같아야 한다.")
    @Test
    void testCreateValidLottos() {
        int quantity = 3;
        Lottos lottos = Lottos.purchaseLottos(quantity);

        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
    }

    @DisplayName("당첨 번호와 보너스 번호를 입력받아 갖고 있던 로또들의 당첨 수량을 확인할 수 있다.")
    @Test
    void testCreateMatchedLottoCount() {
        int quantity = 5;
        Lottos lottos = Lottos.purchaseLottos(quantity);
        assertThat(lottos.checkLottos(List.of(1, 2, 3, 4, 5, 6), 7))
                .containsKeys(
                        THREE_MATCH_PRIZE,
                        FOUR_MATCH_PRIZE,
                        FIVE_MATCH_PRIZE,
                        BONUS_PRIZE,
                        SIX_MATCH_PRIZE
                )
                .isNotEmpty();
    }

    @DisplayName("당첨된 로또들을 보고 수익률을 계산할 수 있다.")
    @Test
    void testCreateIncomeRate() {
        final int percentage = 100;
        int quantity = 5;
        double spendMoney = LOTTO_PRICE.getConstant() * quantity;
        Map<LottoPrizeConstants, Integer> matchedLottoCount = Map.of(
                THREE_MATCH_PRIZE, 1,
                FOUR_MATCH_PRIZE, 1,
                FIVE_MATCH_PRIZE, 1,
                BONUS_PRIZE, 1,
                SIX_MATCH_PRIZE, 1
        );
        Lottos lottos = Lottos.purchaseLottos(quantity);
        assertThat(lottos.getIncomeRate(matchedLottoCount))
                .isEqualTo((2031555000.0 / spendMoney) * percentage);
    }
}
