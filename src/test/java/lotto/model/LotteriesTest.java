package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.vo.BonusNumber;
import lotto.vo.TicketCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesTest {

    LottoNumberGenerator numberGenerator;
    Lotteries lotteries;

    @BeforeEach
    void init() {
        numberGenerator = new LottoNumberGenerator() {
            @Override
            public List<Integer> pickNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };
        TicketCount ticketCount = new TicketCount(3);
        lotteries = Lotteries.createLotteries(ticketCount, numberGenerator);
    }

    @DisplayName("플레이어의 로또번호 생성자 테스트")
    @Test
    void createLotteries_test() {
        // given
        TicketCount ticketCount = new TicketCount(3);

        // when
        Lotteries lotteries = Lotteries.createLotteries(ticketCount, numberGenerator);

        // then
        int expectedSize = ticketCount.count();
        int actualSize = lotteries.getLotteries().size();
        assertEquals(expectedSize, actualSize);

        lotteries.getLotteries().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertTrue(numbers.containsAll(numberGenerator.pickNumbers()));
        });
    }

    @DisplayName("구매한 로또와 당첨번호를 비교하여 일치하는 번호의 개수를 저장한다.")
    @Test
    void match_count_test() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        Lotto winningLotto = Lotto.createWinningLotto(winningNumbers);

        // when
        List<Integer> matchCounts = lotteries.countMatchedNumbers(winningLotto);

        // then
        matchCounts.forEach(count -> {
            assertTrue(count.equals(3));
        });

    }

    @DisplayName("구매한 로또에 보너스 번호가 없는 경우 List에 false를 저장한다.")
    @Test
    void bonus_count_false_test() {
        // given
        BonusNumber bonusNumber = new BonusNumber(7);

        // when
        List<Boolean> bonusCounts = lotteries.checkBonusNumberContain(bonusNumber);

        // then
        bonusCounts.forEach(include -> assertFalse(include.booleanValue()));
    }

    @DisplayName("구매한 로또에 보너스 번호가 있는 경우 List에 true를 저장한다.")
    @Test
    void bonus_count_true_test() {
        // given
        BonusNumber bonusNumber = new BonusNumber(6);

        // when
        List<Boolean> bonusCounts = lotteries.checkBonusNumberContain(bonusNumber);

        // then
        bonusCounts.forEach(include -> assertTrue(include.booleanValue()));
    }

}
