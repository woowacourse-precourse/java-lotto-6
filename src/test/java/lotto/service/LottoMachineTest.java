package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.List;

class LottoMachineTest {
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final int LOTTO_GAME_NUMBER_SIZE = 6;

    @Test
    void 오름차순으로_번호를_생성하는지_확인() {
        // Given
        LottoMachine lottoMachine = new LottoMachine();

        // When
        List<Integer> randomNumbers = lottoMachine.getRandomNumbers();

        // Then
        assertThat(randomNumbers).isSorted();
    }

    @Test
    void 올바른_범위에서_숫자를_선택하는지_확인() {
        // Given
        LottoMachine lottoMachine = new LottoMachine();

        // When
        List<Integer> randomNumbers = lottoMachine.getRandomNumbers();

        // Then
        assertThat(randomNumbers).doesNotHaveDuplicates();
        assertThat(randomNumbers).allMatch(number ->
                number >= LOTTO_GAME_START_NUMBER && number <= LOTTO_GAME_END_NUMBER
        );
    }

    @Test
    void 올바른_개수의_번호를_발행하는지_확인() {
        // Given
        LottoMachine lottoMachine = new LottoMachine();

        // When
        List<Integer> randomNumbers = lottoMachine.getRandomNumbers();

        // Then
        assertThat(randomNumbers).hasSize(LOTTO_GAME_NUMBER_SIZE);
    }
}