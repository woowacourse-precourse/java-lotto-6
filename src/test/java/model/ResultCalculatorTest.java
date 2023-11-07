package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {
    @DisplayName("구매한 로또와 당첨 로또 번호가 모두 일치하면 6을 리턴한다.")
    @Test
    void calculateHitNumbersByComparingIdenticalNumbers() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(resultCalculator.hitNumberCounter(purchasedLottoNumbers, winningLottoNumbers))
                .isEqualTo(6);
    }

    @DisplayName("구매한 로또와 당첨 로또 번호가 5개만 일치하면 5을 리턴한다.")
    @Test
    void calculateHitNumbersByComparingNumbersWith5Equalities() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        assertThat(resultCalculator.hitNumberCounter(purchasedLottoNumbers, winningLottoNumbers))
                .isEqualTo(5);
    }

    @DisplayName("구매한 로또와 당첨 로또 번호가 4개만 일치하면 4를 리턴한다.")
    @Test
    void calculateHitNumbersByComparingNumbersWith4Equalities() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 8, 7);
        assertThat(resultCalculator.hitNumberCounter(purchasedLottoNumbers, winningLottoNumbers))
                .isEqualTo(4);
    }

    @DisplayName("구매한 로또와 당첨 로또 번호가 3개만 일치하면 3를 리턴한다.")
    @Test
    void calculateHitNumbersByComparingNumbersWith3Equalities() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 9, 8, 7);
        assertThat(resultCalculator.hitNumberCounter(purchasedLottoNumbers, winningLottoNumbers))
                .isEqualTo(3);
    }

    @DisplayName("구매한 로또와 당첨 로또 번호가 2개만 일치하면 2를 리턴한다.")
    @Test
    void calculateHitNumbersByComparingNumbersWith2Equalities() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 2, 10, 9, 8, 7);
        assertThat(resultCalculator.hitNumberCounter(purchasedLottoNumbers, winningLottoNumbers))
                .isEqualTo(2);
    }

    @DisplayName("구매한 로또와 당첨 로또 번호가 1개만 일치하면 1를 리턴한다.")
    @Test
    void calculateHitNumbersByComparingNumbersWith1Equalities() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 11, 10, 9, 8, 7);
        assertThat(resultCalculator.hitNumberCounter(purchasedLottoNumbers, winningLottoNumbers))
                .isEqualTo(1);
    }

    @DisplayName("구매한 로또와 당첨 로또 번호가 전혀 일치하지 않으면 0를 리턴한다.")
    @Test
    void calculateHitNumbersByComparingNumbersWithCompletelyDifference() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(12, 11, 10, 9, 8, 7);
        assertThat(resultCalculator.hitNumberCounter(purchasedLottoNumbers, winningLottoNumbers))
                .isEqualTo(0);
    }

    @DisplayName("보너스 번호가 포함되어있으면 true를 리턴한다.")
    @Test
    void calculateIsBonusIncludedWithIncludedBonusNumber() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;
        assertThat(resultCalculator.isBonusNumberIncluded(purchasedLottoNumbers, bonusNumber))
                .isTrue();
    }

    @DisplayName("보너스 번호가 포함되어있지 않으면 false를 리턴한다.")
    @Test
    void calculateIsBonusIncludedWithNotIncludedBonusNumber() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<Integer> purchasedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        assertThat(resultCalculator.isBonusNumberIncluded(purchasedLottoNumbers, bonusNumber))
                .isFalse();
    }
}