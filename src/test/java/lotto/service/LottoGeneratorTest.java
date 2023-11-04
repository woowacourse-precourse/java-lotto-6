package lotto.service;

import lotto.constant.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("6개의 숫자 생성")
    @Test
    void checkNumberLength() {
        NumberGenerator<List<Integer>> generator = new LottoGenerator();

        List<Integer> lotto = generator.generate();

        assertThat(lotto.size()).isEqualTo(Rule.NUMBER_SIZE);
    }

    @DisplayName("1부터 45 범위의 숫자 생성")
    @Test
    void checkNumberRange() {
        NumberGenerator<List<Integer>> generator = new LottoGenerator();

        List<Integer> lotto = generator.generate();

        assertThat(lotto).allMatch(number -> Rule.MIN_NUMBER <= number && number <= Rule.MAX_NUMBER);
    }

    @DisplayName("중복되지 않은 숫자 생성")
    @Test
    void checkDuplicate() {
        NumberGenerator<List<Integer>> generator = new LottoGenerator();

        List<Integer> lotto = generator.generate();

        assertThat(lotto.size()).isEqualTo(Set.copyOf(lotto).size());
    }
}