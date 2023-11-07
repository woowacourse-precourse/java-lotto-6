package lotto;

import lotto.domain.Calculator;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {
    NumberGenerator numberGenerator = new NumberGenerator();
    Calculator calculator = new Calculator();
    LottoManager lottoManager = new LottoManager(numberGenerator, calculator);

    @DisplayName("GenerateUserLottos() 결과 테스트")
    @Test
    public void 생성된_로또의_개수가_매개변수와_다르면_예외가_발생한다() {
        Lottos lottos = lottoManager.generateUserLottos(5);
        Assertions.assertEquals(5, lottos.getLottos().size());
    }
}
