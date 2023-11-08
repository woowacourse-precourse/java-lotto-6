package lotto.model.generator;

import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuickPickTest {
    QuickPick quickPick;
    List<Integer> lottoNumbers;

    @BeforeEach
    void beforeEach() {
        quickPick = new QuickPick();
        lottoNumbers = quickPick.drawLots(Comparator.naturalOrder());
    }

    @Test
    @DisplayName("자동 추첨 시 6개의 번호가 추첨되어야 한다.")
    void countOfLottoNumbersTest() {
        // given
        // when & then
        assertThat(lottoNumbers.size()).isEqualTo(COUNT_OF_LOTTO_NUMBER.getDetails());
    }

    @Test
    @DisplayName("자동 추첨 시 1 ~ 45의 번호가 추첨되어야 한다.")
    void rangeOfLottoNumbersTest() {
        // given
        // when & then
        assertThat(lottoNumbers).allMatch(
                (num) -> num >= MINIMUM_OF_LOTTO_NUMBER.getDetails() && num <= MAXIMUM_OF_LOTTO_NUMBER.getDetails());
    }

    @Test
    @DisplayName("자동 추첨 시 번호는 모두 Unique하다.")
    void duplicateLottoNumbersTest() {
        // given
        // when & then
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("자동 추첨 시 번호는 모두 오름차순 정렬되어야 한다.")
    void sortedLottoNumbersTest() {
        assertThat(IntStream.range(0, lottoNumbers.size() - 1)
                .allMatch((idx) -> lottoNumbers.get(idx) <= lottoNumbers.get(idx + 1)))
                .isTrue();
    }
}