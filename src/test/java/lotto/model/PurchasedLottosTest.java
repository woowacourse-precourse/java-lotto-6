package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.mock.TestLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottosTest {

    @DisplayName("로또 개수만큼 로또 객체를 생성한다.")
    @Test
    void createLottos() {
        int numberOfLottos = 2;
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        PurchasedLottos purchasedLottos = PurchasedLottos.of(numberOfLottos, new TestLottoGenerator(validNumbers));

        assertThat(purchasedLottos).isNotNull();
    }


}