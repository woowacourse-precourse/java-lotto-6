package lotto.service;

import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("발행 수량 구하기")
    void getLotteryTicketCount() {
        // given
        System.setIn(new ByteArrayInputStream("14000".getBytes()));
        int correctCount = 14;
        int wrongCount = 10;

        // when
        int lotteryTicketCount = lottoService.getLotteryTicketCount();

        // then
        assertThat(lotteryTicketCount).isEqualTo(correctCount);
        assertThat(lotteryTicketCount).isNotEqualTo(wrongCount);
    }

    @Test
    @DisplayName("발행하기")
    void issueLotteryTicket() {
        List<Integer> lotteryTicketNumbers = lottoService.issueLotteryTicket();
        System.out.println("lotteryTicketNumbers = " + lotteryTicketNumbers.toString());
        assertThat(lotteryTicketNumbers).isSorted();
    }

    @Test
    @DisplayName("일치한 개수 구하기")
    void getMatchingNumbers() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> sixMatches = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> fiveMatches = List.of(2, 3, 4, 5, 6, 7);
        List<Integer> fourMatches = List.of(3, 4, 5, 6, 7, 8);
        List<Integer> threeMatches = List.of(4, 5, 6, 7, 8, 9);
        List<Integer> twoMatches = List.of(5, 6, 7, 8, 9, 10);
        List<Integer> oneMatches = List.of(6, 7, 8, 9, 10, 11);
        List<Integer> notMatches = List.of(7, 8, 9, 10, 11, 12);

        // when
        int six = lottoService.getMatchingNumbers(sixMatches, winningNumbers);
        int five = lottoService.getMatchingNumbers(fiveMatches, winningNumbers);
        int four = lottoService.getMatchingNumbers(fourMatches, winningNumbers);
        int three = lottoService.getMatchingNumbers(threeMatches, winningNumbers);
        int two = lottoService.getMatchingNumbers(twoMatches, winningNumbers);
        int one = lottoService.getMatchingNumbers(oneMatches, winningNumbers);
        int zero = lottoService.getMatchingNumbers(notMatches, winningNumbers);

        // then
        assertThat(six).isEqualTo(6);
        assertThat(five).isEqualTo(5);
        assertThat(four).isEqualTo(4);
        assertThat(three).isEqualTo(3);
        assertThat(two).isEqualTo(2);
        assertThat(one).isEqualTo(1);
        assertThat(zero).isEqualTo(0);
    }

    @Test
    @DisplayName("보너스 숫자 일치 여부 구하기")
    void isMatchingBonusNumber() {
        // given
        int bonusNumber = 7;
        List<Integer> containBonusNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> notContainBonusNumber = List.of(1, 2, 3, 4, 5, 6);

        // when
        boolean matching = lottoService.isMatchingBonusNumber(containBonusNumber, bonusNumber);
        boolean notMatching = lottoService.isMatchingBonusNumber(notContainBonusNumber, bonusNumber);

        // then
        assertThat(matching).isEqualTo(true);
        assertThat(notMatching).isEqualTo(false);
    }
}