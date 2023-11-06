package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoVendingMachineTest {
    private LottoVendingMachine lottoVendingMachine;

    @BeforeEach
    void init() {
        lottoVendingMachine = new LottoVendingMachine();
    }

    @Test
    @DisplayName("1에서 45사이 무작위 값 반환 테스트")
    void randomValueBetween1And45Test() {
        List<Integer> randomNumbers = lottoVendingMachine.getRandomNumbers();

        for (int randomNumber : randomNumbers) {
            assertThat(randomNumber).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("무작위 값 갯수 크기 6 반환 테스트")
    void randomValueCountOfSize6Test() {
        List<Integer> randomNumbers = lottoVendingMachine.getRandomNumbers();

        assertThat(randomNumbers.size()).isEqualTo(6);
    }
}