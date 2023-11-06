package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerLottoTest {

    @DisplayName("buyingCount에 맞추어 로또를 생성시킨다. 불변 Collection으로 반환하는지 검증한다")
    @Test
    void generateLottoByBuingCount() {
        PlayerLotto playerLotto = new PlayerLotto();

        List<Lotto> buyingLotto = playerLotto.generatePlayerNumbers(6);

        Assertions.assertAll(
                () -> Assertions.assertEquals(6, buyingLotto.size()),
                () -> Assertions.assertThrows(UnsupportedOperationException.class,
                        () -> buyingLotto.get(0).getNumbers().add(2))
        );
    }
}
