package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    List<Lotto> lottos = new LottoGenerator(10).getLottos();

    @DisplayName("주어진 개수 만큼의 로또를 생성한다.")
    @Test
    void testLottosSize() {
        int result = lottos.size();
        int answer = 10;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("각 로또 번호의 개수는 모두 6개이다.")
    @Test
    void testLottoSize() {
        boolean result = lottos.stream()
                .allMatch(lotto -> lotto.getNumbers().size() == 6);
        boolean answer = true;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("모든 로또는 오름차순으로 정렬되어 있다.")
    @Test
    void testOrderedness() {
        boolean result = lottos.stream()
                .allMatch(lotto -> isSorted(lotto.getNumbers()));
        boolean answer = true;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("모든 로또는 서로 중복되지 않는다.")
    @Test
    void testDuplicates() {
        boolean result = lottos.stream()
                .allMatch(lotto -> !hasDuplicates(lotto.getNumbers()));
        boolean answer = true;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("각 로또의 모든 번호는 1~45 범위 내에 있다.")
    @Test
    void testInRange() {
        boolean result = lottos.stream()
                .allMatch(lotto -> lotto.getNumbers().stream().allMatch(number -> number >= 1 && number <= 45));
        boolean answer = true;

        assertThat(result).isEqualTo(answer);
    }

    private boolean isSorted(List<Integer> numbers) {
        for (int i=1; i<numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (numbers.size() != distinctNumbers.size()) {
            return true;
        }
        return false;
    }
}
