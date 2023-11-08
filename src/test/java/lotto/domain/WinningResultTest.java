package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningResultTest {

    private WinningResult winningResult;

    @BeforeEach
    @Test
    void initWinningResult() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Lotto lotto = Lotto.valueOf(List.of(1,2,3,4,5,6));
            LottoNumber lottoNumber = LottoNumber.valueOf("7");
            WinningLotto winningLotto= WinningLotto.of(lotto, lottoNumber);

            LottoTickets tickets = LottoTickets.createdByNumber(7);

            winningResult = WinningResult.compare(tickets, winningLotto);
        },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 7),
                List.of(1, 2, 3, 14, 15, 18),
                List.of(1, 2, 10, 14, 15, 18),
                List.of(1, 2, 10, 14, 15, 18)
        );
    }

    @Test
    void studyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", map.getOrDefault("1", 0) + 1);
        map.put("2", map.getOrDefault("2", 0) + 1);
        map.put("3", map.getOrDefault("3", 0) + 1);
        map.put("4", map.getOrDefault("4", 0) + 1);
        map.put("5", map.getOrDefault("5", 0) + 1);

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    @DisplayName("당첨된 로또 결과의 수 가져오는 함수")
    @Test
    void getCount() {
        assertThat(winningResult.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.THIRD)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또 결과의 수 가져오는 함수 예외상황하지 않네요")
    @Test
    void getCountByNull() {
        System.out.println(winningResult.getCount(null));
        assertThat(winningResult.getCount(null)).isEqualTo(0);
    }

    @DisplayName("총 당첨 금액 계산하기 테스트")
    @Test
    void calculateTotalAmountLogicTest() {
        long totalAmount = 0;
        for (Rank rank : winningResult.getWinningResult().keySet()) {
            totalAmount += winningResult.getCount(rank) * rank.getWinningAmount();
        }

        assertThat(totalAmount)
                .isEqualTo(
                        Rank.FIRST.getWinningAmount()
                                + Rank.SECOND.getWinningAmount()
                                + Rank.THIRD.getWinningAmount()
                                + Rank.FOURTH.getWinningAmount()
                                + Rank.FIFTH.getWinningAmount()
                );

        long totalAmount2 = winningResult.getWinningResult().keySet()
                .stream()
                .map(rank -> winningResult.getCount(rank) * rank.getWinningAmount())
                .reduce(0L, Long::sum);

        assertThat(totalAmount2)
                .isEqualTo(
                        Rank.FIRST.getWinningAmount()
                                + Rank.SECOND.getWinningAmount()
                                + Rank.THIRD.getWinningAmount()
                                + Rank.FOURTH.getWinningAmount()
                                + Rank.FIFTH.getWinningAmount()
                );
    }

    @DisplayName("총 당첨 금액 계산하기 테스트")
    @Test
    void calculateTotalAmount() {
        assertThat(winningResult.calculateTotalAmount())
                .isEqualTo(
                        Rank.FIRST.getWinningAmount()
                                + Rank.SECOND.getWinningAmount()
                                + Rank.THIRD.getWinningAmount()
                                + Rank.FOURTH.getWinningAmount()
                                + Rank.FIFTH.getWinningAmount()
                );
    }
}