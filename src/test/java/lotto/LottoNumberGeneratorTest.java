package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
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

    @DisplayName("구매한 로또 수만큼 생성된 로또 번호 확인")
    @Test
    void generateLottoNumberForPurchaseCount() {
        int purchaseCount = 5;
        Lottos lottos = new Lottos(lottoNumberGenerator, purchaseCount);
        List<Lotto> generatedLotto = lottos.getLottos();

        for (Lotto lotto : generatedLotto) {
            System.out.println("생성된 로또 번호: " + lotto.toString());
        }
    }
}
