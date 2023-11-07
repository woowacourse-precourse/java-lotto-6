package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @DisplayName("로또 구입 금액에 따른 구매 개수 계산")
    @Test
    void calculateNumberOfLottoTest() {
        Calculator calculator = new Calculator();
        int input = 12000;
        int result = 12;

        assertThat(calculator.calculateNumberOfLotto(input)).isEqualTo(result);
    }

    @DisplayName("구매한 로또 번호와 입력한 당첨 번호를 비교해 일치한 번호 개수 계산")
    @Test
    void countMatchedPairsTest() {
        Calculator calculator = new Calculator();
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 4, 5, 10, 11, 12));
        int result = 3;

        assertThat(calculator.countMatchedPairs(lotto, winningNumbers)).isEqualTo(result);
    }

    @DisplayName("모든 로또 번호 리스트와 입력한 당첨 번호, 보너스 번호를 비교해 일치한 번호 개수를 저장")
    @Test
    void saveResultTest() {
        Calculator calculator = new Calculator();
        List<List<Integer>> storage = new ArrayList<>();
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 1, 1, 1, 1));
        int bonusNumber = 7;

        storage.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        storage.add(Arrays.asList(1, 3, 4, 5, 6, 11));
        storage.add(Arrays.asList(1, 3, 5, 6, 8, 9));
        storage.add(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertThat(calculator.saveResult(storage, winningNumbers, bonusNumber)).isEqualTo(result);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateRateOfReturnTest() {
        Calculator calculator = new Calculator();
        int input1= 4;
        List<Integer> input2 = new ArrayList<>(List.of(0, 0, 0, 1, 0, 2, 1, 0));
        double result = 50075125.0;

        assertThat(calculator.calculateRateOfReturn(input1, input2)).isEqualTo(result);
    }

}