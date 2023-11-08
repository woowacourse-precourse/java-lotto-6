package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    @DisplayName("로또번호가 6개인 경우 예외 발생하지않음")
    @Test
    public void 로또_번호_개수_유효성_테스트_() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();
        Assertions.assertEquals(6, numbers.size());
    }

    @DisplayName("로또번호가 1에서 45 사이가 아니라면 예외가 발생한다")
    @Test
    public void 로또_번호_범위_유효성_테스트() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();
        Assertions.assertTrue(numbers.stream().allMatch(number -> number >= 1 && number <= 45));
    }

    @DisplayName("로또번호가 중복되면 예외가 발생한다")
    @Test
    public void 로또_번호_생성_시_번호_중복_여부_테스트() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createRandomLottoNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        Assertions.assertEquals(numbers.size(), uniqueNumbers.size());
    }
}
