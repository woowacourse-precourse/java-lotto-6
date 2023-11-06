package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private final int LOTTO_SIZE = 6;
    @DisplayName("로또 번호를 생성한다")
    @Test
    void generatorLotto() {
        Lotto lotto = LottoGenerator.generatorLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();
        Set<Integer> numbers = new HashSet<>(lottoNumbers);
        assertThat(numbers.size()).isEqualTo(LOTTO_SIZE);
    }
}