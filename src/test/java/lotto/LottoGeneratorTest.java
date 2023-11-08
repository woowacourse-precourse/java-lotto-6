package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class LottoGeneratorTest {
    @DisplayName("돈의 액수에 따라 알맞는 로또의 개수가 생성되는지 검증한다.")
    @Test
    void testLottoCountBasedOnMoney() throws NoSuchFieldException, IllegalAccessException {
        LottoGenerator generator = new LottoGenerator(8000);
        List<Lotto> lottos = generator.getLottos();
        assertThat(lottos).hasSize(8);
    }

    @DisplayName("로또의 숫자가 6개이고 1~45의 숫자 범위를 갖는지 검증한다.")
    @Test
    void testLottoNumbersRange() {
        LottoGenerator generator = new LottoGenerator(1000);
        generator.getLottos().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers)
                    .hasSize(6)
                    .allMatch((number-> number >= 1 && number <= 45));
        });
    }

    @DisplayName("로또의 숫자가 중복되지 않는지 검증한다.")
    @Test
    void testLottoNumberUniqueness() {
        LottoGenerator generator = new LottoGenerator(1000);
        generator.getLottos().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> uniqueNumbers = numbers.stream().collect(Collectors.toSet());
            assertThat(uniqueNumbers).hasSameSizeAs(numbers);
        });
    }
}
