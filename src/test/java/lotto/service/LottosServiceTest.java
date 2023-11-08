package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosServiceTest {

    @Test
    @DisplayName("구입한 로또의 개수와 생성한 로또의 개수가 같으면 구입 개수 만큼 로또 생성에 성공입니다.")
    void Given_PurchaseCount_When_CreateLotto_Then_Success() {
        LottoPurchase lottoPurchase = LottoPurchase.create(8);
        LottosService lottosService = new LottosService();

        Lottos lottos = lottosService.createLottos(lottoPurchase);

        assertThat(lottos.getLottos().size()).isEqualTo(8);
    }
}