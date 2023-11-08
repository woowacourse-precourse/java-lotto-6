package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchasedLottoTest {
    @DisplayName("정상적으로 각각 다른 로또 배열들을 출력")
    @Test
    void createLottosList() {
        int count = 8;
        PurchasedLotto purchasedLotto = new PurchasedLotto(count);
        List<Lotto> expectedResult = purchasedLotto.getPurchasedLottos();
        Assertions.assertThat((purchasedLotto.getPurchasedLottos())).isEqualTo(expectedResult);
    }

}