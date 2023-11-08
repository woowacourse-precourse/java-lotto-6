package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.message.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    private static final int LOTTO_PRICE = 1000;
    private static final int PURCHASE_QUANTITY = 10;

    private LottoIssuer lottoIssuer;

    @BeforeEach
    void setup() {
        lottoIssuer = new LottoIssuer();
    }

    @Test
    @DisplayName("getResult: 알맞은 당첨 결과를 반환한다")
    void getResult() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(lottoNumbers);
        int bonusNumber = 7;

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = lottoIssuer.buy(LOTTO_PRICE);
                    GameResult result = lottos.getResult(winningNumber, bonusNumber);

                    List<LottoResult> keys = new ArrayList<>(result.getWinningCount().keySet());
                    List<Integer> values = new ArrayList<>(result.getWinningCount().values());
                    List<LottoResult> sortedKeys = new ArrayList<>(keys);
                    sortedKeys.sort(Comparator.naturalOrder());

                    assertThat(keys).isEqualTo(sortedKeys);
                    assertThat(values).containsExactly(0, 0, 0, 0, 1);
                },
                lottoNumbers
        );
    }

    @Test
    @DisplayName("getPurchaseQuantity: 적절한 구매 개수를 반환한다")
    void getPurchaseQuantity() {
        Lottos lottos = lottoIssuer.buy(LOTTO_PRICE * PURCHASE_QUANTITY);

        assertThat(lottos.getPurchaseQuantity()).isEqualTo(PURCHASE_QUANTITY);
    }
}