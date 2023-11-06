package lotto;

import lotto.domain.Budget;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.strategy.UserLottoGenerateStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;
    private Budget budget;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
        budget = Budget.from("3000");
    }

    @DisplayName("유저 로또 생성 전략으로 만들어진 Lottos 의 크기는 getCountOfLottoLines() 의 반환 결과값과 같아야한다.")
    @Test
    void createLottoByUserLottoStrategy() {
        lottoGenerator.setLottoGenerateStrategy(new UserLottoGenerateStrategy());
        lottos = lottoGenerator.generateLottosByBudget(budget);
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(budget.getCountOfLottoLines());
    }
}
