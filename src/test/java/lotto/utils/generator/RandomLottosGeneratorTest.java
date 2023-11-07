package lotto.utils.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.Values;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomLottosGeneratorTest {

    private int purchaseAmount;
    private RandomLottosGenerator randomLottosGenerator;
    private List<Lotto> generatedLottos;

    @BeforeEach
    void setUp() {
        purchaseAmount = 10000;
        randomLottosGenerator = new RandomLottosGenerator();
        generatedLottos = randomLottosGenerator.generateLottos(purchaseAmount);
    }

    @DisplayName("올바른 로또 범위 내의 숫자를 생성한다.")
    @RepeatedTest(100)
    void generateLottosWithinRange() {
        boolean allLottosHaveValidNumbers = generatedLottos.stream()
                .allMatch(lotto -> lotto.getNumbers().stream().allMatch(
                        number -> number >= Values.LOTTO_MIN_NUMBER && number <= Values.LOTTO_MAX_NUMBER
                ));
        assertThat(allLottosHaveValidNumbers).isTrue();
    }

    @DisplayName("구매금액에 맞게 로또 갯수를 생성한다.")
    @RepeatedTest(100)
    void generateLottosCountByPurchaseAmount() {
        int expectedValue = purchaseAmount / Values.LOTTO_PURCHASE_UNIT;
        assertThat(generatedLottos).hasSize(expectedValue);
    }

    @DisplayName("중복되지 않은 로또를 생성합니다")
    @RepeatedTest(100)
    void generateUniqueLottos() {
        boolean allLottosHaveUniqueNumbers = generatedLottos.stream()
                .allMatch(lotto -> lotto.getNumbers().stream().distinct().count() == lotto.getNumbers().size());

        assertThat(allLottosHaveUniqueNumbers).isTrue();
    }
}
