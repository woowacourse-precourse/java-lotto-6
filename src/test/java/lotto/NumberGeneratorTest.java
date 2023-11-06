package lotto;

import java.util.List;
import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    @Test
    public void 로또번호가_6개인지_확인() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();
        Assertions.assertEquals(6, numbers.size());
    }

    @Test
    public void 로또번호가_1에서_45까지_범위내에_있는지_확인() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();
        for (int number : numbers) {
            Assertions.assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    public void 로또번호가_중복되지_않는지_확인() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                Assertions.assertNotEquals(numbers.get(i), numbers.get(j));
            }
        }
    }
}
