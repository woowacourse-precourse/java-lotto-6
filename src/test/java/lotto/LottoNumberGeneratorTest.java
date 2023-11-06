package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.services.LottoNumberGenerator;
import lotto.utils.NumberGenerator;
import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(numberGenerator);

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generateLottoNumber() {

        List<Integer> generatedLotto = lottoNumberGenerator.generateNumbers();
        System.out.println("생성된 로또 번호: " + generatedLotto);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되는지 확인")
    @Test
    void generateLottoNumberForPurchaseCount() {
        int purchaseCount = 5;
        Lottos lottos = new Lottos(lottoNumberGenerator, purchaseCount);
        List<Lotto> generatedLotto = lottos.getLottos();

        for (Lotto lotto : generatedLotto) {
            System.out.println("생성된 로또 번호: " + lotto.getNumbers());
        }
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되는지 확인")
    @Test
    void lottoIsAscSorted() {
        List<Integer> numbers = List.of(33, 26, 39, 12, 4, 16);
        Lotto lotto = new Lotto(numbers);
        List<Integer> expected = List.of(4, 12, 16, 26, 33, 39);
        assertThat(lotto.getNumbers()).isEqualTo(expected);

    }
}
