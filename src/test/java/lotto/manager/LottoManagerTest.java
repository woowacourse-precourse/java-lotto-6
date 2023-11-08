package lotto.manager;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.NumberGenerator;
import lotto.domain.Payment;
import lotto.manager.mock.MockNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoManagerTest {

    @DisplayName("지불 금액을 입력받아 로또를 생성하고 반환한다.")
    @Test
    void createLottoByPayment() {
        // given
        NumberGenerator<List<Integer>> lottoNumberGenerator = new MockNumberGenerator();
        LottoManager lottoManager = new LottoManager(lottoNumberGenerator);
        int inputPayment = 5000;
        Payment payment = new Payment(inputPayment);
        int countAffortable = payment.countAffortable(1000);
        List<Lotto> readyLottos = IntStream.range(0, countAffortable)
                .mapToObj(idx -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
        Lottos expectedLottos = new Lottos(readyLottos);

        // when
        Lottos lottos = lottoManager.createLottos(payment);

        // then
        assertThat(expectedLottos).usingRecursiveComparison().isEqualTo(lottos);
        assertThat(lottos.size()).isEqualTo(countAffortable);
    }
}