package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;
    private List<List<Integer>> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
        lottoNumbers = lottoGenerator.issueLottoAsManyAsPurchased(1000000);
    }

    @Test
    void issueLottoAsManyAsPurchased_메서드가_issueLotto_메서드를_호출해_1부터_45까지_범위_내에서_숫자를_뽑는다() {
        for (List<Integer> actual : lottoNumbers) {
            for (Integer integer : actual) {
                assertThat(integer).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
            }
        }
    }

    @Test
    void issueLottoAsManyAsPurchased_메서드가_issueLotto_메서드를_호출해_6개의_무작위값을_뽑는다() {
        for (List<Integer> actual : lottoNumbers) {
            assertThat(actual.size()).isEqualTo(6);
        }
    }

    @Test
    void issueLottoAsManyAsPurchased_메서드가_issueLotto_메서드를_호출해_중복없이_숫자를_뽑는다() {
        for (List<Integer> actual : lottoNumbers) {
            Set<Integer> numbersWithoutDuplicates = new HashSet<>(actual);
            assertThat(actual.size()).isEqualTo(numbersWithoutDuplicates.size());
        }
    }

    @Test
    void issueLottoAsManyAsPurchased_메서드가_issueLotto_메서드를_호출해_뽑은_숫자들을_오름차순으로_정렬한다() {
        for (List<Integer> actual : lottoNumbers) {
            for (int i = 0; i < actual.size() - 1; i++) {
                assertThat(actual.get(i)).isLessThan(actual.get(i + 1));
            }
        }
    }

    @Test
    void issueLottoAsManyAsPurchased_메서드로_구매_갯수만큼_로또_발행() {
        List<List<Integer>> actual = lottoNumbers;
        assertThat(actual.size()).isEqualTo(1000000);
    }
}
