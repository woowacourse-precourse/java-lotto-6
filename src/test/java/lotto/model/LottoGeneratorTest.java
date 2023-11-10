package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    // 내가 요구한 만큼 로또가 생성되는지 확인
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("지불한 돈(예산) 만큼 로또가 생성 되는 지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void generateByCorrectBudget(int money) {
        Budget budget = new Budget(money);
        List<Lotto> generatedLottos = lottoGenerator.generate(budget);
        assertThat(generatedLottos.size()).isEqualTo(money / Constants.LOTTO_PRICE);
    }

    @DisplayName("지불한 돈이 0원인 경우")
    @Test
    void generateByZerBudget() {
        assertThatThrownBy(() -> lottoGenerator.generate(new Budget(0)))
            .isInstanceOf(IllegalArgumentException.class);
    }


}