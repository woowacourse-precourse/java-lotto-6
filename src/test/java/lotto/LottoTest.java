package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 일치하면 1등 상금을 받는다.")
    @Test
    void calculatePrizeByMatchingSixNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Prize prize = lotto.calculatePrize(winningNumbers, bonusNumber);
        assertEquals(Prize.FIRST, prize);
    }
    @DisplayName("로또 번호가 5개 일치하고 보너스 번호가 일치하면 2등 상금을 받는다.")
    @Test
    void calculatePrizeByMatchingFiveNumbersAndBonusNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        Prize prize = lotto.calculatePrize(winningNumbers, bonusNumber);
        assertEquals(Prize.SECOND, prize);
    }
    @DisplayName("로또 번호가 5개 일치하면 3등 상금을 받는다.")
    @Test
    void calculatePrizeByMatchingFiveNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 8);
        int bonusNumber = 7;
        Prize prize = lotto.calculatePrize(winningNumbers, bonusNumber);
        assertEquals(Prize.THIRD, prize);
    }
    @DisplayName("로또 번호가 4개 일치하면 4등 상금을 받는다.")
    @Test
    void calculatePrizeByMatchingFourNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 8, 9);
        int bonusNumber = 7;
        Prize prize = lotto.calculatePrize(winningNumbers, bonusNumber);
        assertEquals(Prize.FOURTH, prize);
    }
    @DisplayName("로또 번호가 3개 일치하면 5등 상금을 받는다.")
    @Test
    void calculatePrizeByMatchingThreeNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 8, 9, 10);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Prize prize = lotto.calculatePrize(winningNumbers, bonusNumber);
        assertEquals(Prize.FIFTH, prize);
    }
    @DisplayName("로또 번호가 2개 일치하면 꽝이다.")
    @Test
    void calculatePrizeByMatchingTwoNumbers() {
        List<Integer> numbers = List.of(1, 2, 8, 9, 10, 11);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Prize prize = lotto.calculatePrize(winningNumbers, bonusNumber);
        assertEquals(Prize.NO_PRIZE, prize);
    }
    @DisplayName("로또 번호가 1개 일치하면 꽝이다.")
    @Test
    void calculatePrizeByMatchingOneNumber() {
        List<Integer> numbers = List.of(1, 8, 9, 10, 11, 12);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Prize prize = lotto.calculatePrize(winningNumbers, bonusNumber);
        assertEquals(Prize.NO_PRIZE, prize);
    }
    @DisplayName("로또 번호가 모두 일치하지 않으면 꽝이다.")
    @Test
    void calculatePrizeByNotMatching() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(8, 9, 10, 11, 12, 13);
        int bonusNumber = 7;
        Prize prize = lotto.calculatePrize(winningNumbers, bonusNumber);
        assertEquals(Prize.NO_PRIZE, prize);
    }

}