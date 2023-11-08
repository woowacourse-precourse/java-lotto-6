package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import enums.WinType;
import java.util.List;
import model.PurchasedLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasedLottoTest {

    @DisplayName("로또 체크 테스트")
    @Test
    void purchasedLottoCheckTest() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    PurchasedLotto purchasedLotto = new PurchasedLotto(1);
                    List<WinType> winTypes = purchasedLotto.checkLotto(List.of(1, 2, 3, 4, 5, 6), 42);
                    assertThat(winTypes).contains(WinType.HEXA);
                },
                List.of(1, 2, 3, 4, 5, 6));

        assertRandomUniqueNumbersInRangeTest(() -> {
                    PurchasedLotto purchasedLotto = new PurchasedLotto(1);
                    List<WinType> winTypes = purchasedLotto.checkLotto(List.of(1, 2, 3, 4, 5, 16), 6);
                    assertThat(winTypes).contains(WinType.PENTA_WITH_BONUS);
                },
                List.of(1, 2, 3, 4, 5, 6));

        assertRandomUniqueNumbersInRangeTest(() -> {
                    PurchasedLotto purchasedLotto = new PurchasedLotto(1);
                    List<WinType> winTypes = purchasedLotto.checkLotto(List.of(1, 12, 13, 4, 15, 16), 6);
                    assertThat(winTypes).isEmpty();
                },
                List.of(1, 2, 3, 4, 5, 6));
    }
}
