package lotto.utils;

import static lotto.utils.Constant.MAX_LOTTO;
import static lotto.utils.Constant.MIN_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Generator.generateSortedLottoNumbers();
    }

    @DisplayName("랜덤 로또 숫자 생성을 테스트 합니다.")
    @Test
    void generateLotto() {
        assertThat(lottoNumbers).isNotNull();
    }

    @DisplayName("생성된 로또 숫자가 범위 안에서 생성되는지 테스트 합니다.")
    @Test
    void generateLottoInRange() {
        lottoNumbers.forEach(number -> assertThat(number).isBetween(MIN_LOTTO.getValue(), MAX_LOTTO.getValue()));
    }

    @DisplayName("생성된 로또 숫자가 오름차순으로 정렬되는지 테스트 합니다.")
    @Test
    void generateLottoSort() {
        assertThat(lottoNumbers).isSorted();
    }
}