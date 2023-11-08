package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;
    private List<Integer> actual;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
        actual = lottoGenerator.issueLotto();
    }

    @Test
    void issueLotto_메서드가_1부터_45까지_범위_내에서_숫자를_뽑는다() {
        for (Integer integer : actual) {
            assertThat(integer).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
        }
    }

    @Test
    void issueLotto_메서드가_6개의_무작위값을_뽑는다() {
        assertThat(actual.size()).isEqualTo(6);
    }

    @Test
    void issueLotto_메서드가_중복없이_숫자를_뽑는다() {
        Set<Integer> numbersWithoutDuplicates = new HashSet<>(actual);
        assertThat(actual.size()).isEqualTo(numbersWithoutDuplicates.size());
    }
}
