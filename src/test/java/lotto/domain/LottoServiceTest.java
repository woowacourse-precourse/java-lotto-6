package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private Lotto lotto;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoService = new LottoService(new ArrayList<>());
    }

    @Test
    @DisplayName("생성된 로또 숫자와 당첨번호의 개수가 일치하는지 테스트")
    void count_generated_and_winning_lottos() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 11, 22, 33);
        int count = lottoService.countMatchingNumbers(lotto, winningNumbers);
        assertEquals(count, 3);
    }

    @Test
    @DisplayName("생성된 로또 숫자와 당첨번호가 일치하지 않을 때 테스트")
    void non_count_generated_and_winning_lottos() {
        List<Integer> winningNumbers = List.of(17, 8, 9, 10, 11, 12);
        int count = lottoService.countMatchingNumbers(lotto, winningNumbers);
        assertEquals(count, 0);
    }

    @Test
    @DisplayName("생성된 로또 숫자와 보너스 숫자가 일치하는지 테스트")
    void count_generated_and_bonus_lottos() {
        int bonusNumber = 6;
        int count = lottoService.countMatchingBonusNumber(lotto, bonusNumber);
        assertEquals(count, 1);
    }

    @Test
    @DisplayName("생성된 로또 숫자와 보너스 숫자가 일치하지 않을 때 테스트")
    void non_count_generated_and_bonus_lottos() {
        int bonusNumber = 7;
        int count = lottoService.countMatchingBonusNumber(lotto, bonusNumber);
        assertEquals(count, 0);
    }

    @Test
    @DisplayName("로또 숫자가 6개 일치할 떄 테스트")
    void test_when_first_prize() {
        List<Integer> first = List.of(1, 2, 3, 4, 5, 6);
        Rank firstRank = lottoService.getLottoRank(lotto, first, 10);
        assertEquals(firstRank, Rank.FIRST);
    }

    @Test
    @DisplayName("로또 숫자가 5개 일치하고 보너스 번호가 일치할 때 테스트")
    void test_when_second_prize() {
        List<Integer> second = List.of(1, 2, 3, 4, 5, 7);
        Rank secondRank = lottoService.getLottoRank(lotto, second, 6);
        assertEquals(secondRank, Rank.SECOND);
    }

    @Test
    @DisplayName("로또 숫자가 5개 일치하지만 보너스 번호가 불일치 할 때 테스트")
    void test_when_third_prize() {
        List<Integer> third = List.of(1, 2, 3, 4, 5, 7);
        Rank thirdRank = lottoService.getLottoRank(lotto, third, 45);
        assertEquals(thirdRank, Rank.THIRD);
    }

    @Test
    @DisplayName("로또 숫자가 4개 일치할 때 테스트")
    void test_when_fourth_prize() {
        List<Integer> fourth = List.of(1, 2, 3, 4, 10, 20);
        Rank FourthRank = lottoService.getLottoRank(lotto, fourth, 45);
        assertEquals(FourthRank, Rank.FOURTH);
    }

    @Test
    @DisplayName("로또 숫자가 3개 일치할 때 테스트")
    void test_when_fifth_prize() {
        List<Integer> fifth = List.of(1, 2, 3, 10, 20, 30);
        Rank fifthRank = lottoService.getLottoRank(lotto, fifth, 45);
        assertEquals(fifthRank, Rank.FIFTH);
    }

    @Test
    @DisplayName("로또 숫자가 2개 일치할 때 테스트")
    void test_two_number_match() {
        List<Integer> match_two = List.of(1, 2, 11, 12, 13, 14);
        Rank match_two_fail = lottoService.getLottoRank(lotto, match_two, 45);
        assertEquals(match_two_fail, Rank.FAIL);
    }

    @Test
    @DisplayName("로또 숫자가 1개 일치할 때 테스트")
    void test_one_number_match() {
        List<Integer> match_one = List.of(1, 10, 11, 12, 13, 14);
        Rank match_one_fail = lottoService.getLottoRank(lotto, match_one, 45);
        assertEquals(match_one_fail, Rank.FAIL);
    }

    @Test
    @DisplayName("일치하는 숫자가 없을 때 테스트")
    void test_none_match() {
        List<Integer> none_match = List.of(10, 11, 12, 13, 14, 15);
        Rank none_match_fail = lottoService.getLottoRank(lotto, none_match, 45);
        assertEquals(none_match_fail, Rank.FAIL);
    }
}