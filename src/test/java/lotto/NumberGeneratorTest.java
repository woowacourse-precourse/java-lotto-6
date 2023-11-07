package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    @DisplayName("로또 번호 개수 유효성 테스트")
    @Test
    public void 로또번호가_6개가_아닌_경우_예외가_발생한다() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();
        Assertions.assertEquals(6, numbers.size());
    }

    @DisplayName("로또 번호 범위 유효성 테스트")
    @Test
    public void 로또번호가_1에서_45_사이에_없으면_예외가_발생한다() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();

        Assertions.assertTrue(numbers.stream().allMatch(number -> number >= 1 && number <= 45));
    }

    @DisplayName("로또 번호 중복되지 않는지 테스트")
    @Test
    public void 로또번호가_중복되면_예외가_발생한다() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        Assertions.assertEquals(numbers.size(), uniqueNumbers.size());
    }
}
