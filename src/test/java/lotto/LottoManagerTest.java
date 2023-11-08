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

    @DisplayName("생성된 로또의 개수가 매개변수와 같으면 예외 발생하지않음")
    @Test
    public void 만든_로또_개수가_ticketCount와_같은지_테스트() {
        Lottos lottos = lottoManager.generateUserLottos(5);
        Assertions.assertEquals(5, lottos.getLottos().size());
    }
}
