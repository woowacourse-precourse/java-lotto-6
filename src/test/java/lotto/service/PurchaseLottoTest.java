package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseLottoTest {
    @DisplayName("로또 원하는 개수 만큼 구입")
    @Test
    void purchaseLottoN() {
        int numberOfLotto = 8;
        List<Lotto> lottos = PurchaseLotto.getLottos(numberOfLotto);
        lottos.stream().forEach(lotto -> System.out.println(lotto));
        assertThat(lottos.size()).isEqualTo(numberOfLotto);
    }
}
