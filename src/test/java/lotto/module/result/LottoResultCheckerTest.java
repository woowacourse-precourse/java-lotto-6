package lotto.module.result;

import lotto.module.domain.TotalPrize;
import lotto.module.lotto.Lotto;
import lotto.module.lotto.UserLottoTickets;
import lotto.module.lotto.WinningLotto;
import lotto.module.rank.LottoPrizeTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCheckerTest {

    private final LottoResultChecker lottoResultChecker = LottoResultChecker.newInstance();

    private UserLottoTickets userLottoTicket;
    private WinningLotto winningLotto;
    private List<Lotto> tickets;

    @BeforeEach
    void setLottoResultChecker() {
        Lotto lotto = getFirstPlaceLotto();
        int bonusNumber = 7;
        winningLotto = WinningLotto.of(lotto, bonusNumber);

        tickets = new ArrayList<>();
    }

    @Test
    void 모든_등수_1회_당첨_성공_테스트() {
        // given
        tickets.add(getFirstPlaceLotto());
        tickets.add(getSecondPlaceLotto());
        tickets.add(getThirdPlaceLotto());
        tickets.add(getFourthPlaceLotto());
        tickets.add(getFifthPlaceLotto());

        userLottoTicket = UserLottoTickets.newInstance(tickets);

        long expectedTotalPrize = 0;
        for (LottoPrizeTable prize : LottoPrizeTable.values()) {
            expectedTotalPrize += prize.getPrize();
        }

        // when
        LottoResult result = lottoResultChecker.getResult(userLottoTicket, winningLotto);
        TotalPrize totalPrize = result.getTotalPrize();

        // then
        assertThat(totalPrize.money())
                .isEqualTo(expectedTotalPrize);
    }


    @Test
    void 일등_당첨_1회_성공_테스트() {
        // given
        tickets.add(getFirstPlaceLotto());

        userLottoTicket = UserLottoTickets.newInstance(tickets);

        long expectedTotalPrize = LottoPrizeTable.FIRST_PLACE.getPrize();

        // when
        LottoResult result = lottoResultChecker.getResult(userLottoTicket, winningLotto);
        TotalPrize totalPrize = result.getTotalPrize();

        // then
        assertThat(totalPrize.money())
                .isEqualTo(expectedTotalPrize);
    }

    @Test
    void 이등_당첨_1회_성공_테스트() {
        // given
        tickets.add(getSecondPlaceLotto());

        userLottoTicket = UserLottoTickets.newInstance(tickets);

        long expectedTotalPrize = LottoPrizeTable.SECOND_PLACE.getPrize();

        // when
        LottoResult result = lottoResultChecker.getResult(userLottoTicket, winningLotto);
        TotalPrize totalPrize = result.getTotalPrize();

        // then
        assertThat(totalPrize.money())
                .isEqualTo(expectedTotalPrize);
    }

    @Test
    void 삼등_당첨_1회_성공_테스트() {
        // given
        tickets.add(getThirdPlaceLotto());

        userLottoTicket = UserLottoTickets.newInstance(tickets);

        long expectedTotalPrize = LottoPrizeTable.THIRD_PLACE.getPrize();

        // when
        LottoResult result = lottoResultChecker.getResult(userLottoTicket, winningLotto);
        TotalPrize totalPrize = result.getTotalPrize();

        // then
        assertThat(totalPrize.money())
                .isEqualTo(expectedTotalPrize);
    }

    @Test
    void 사등_당첨_1회_성공_테스트() {
        // given
        tickets.add(getFourthPlaceLotto());

        userLottoTicket = UserLottoTickets.newInstance(tickets);

        long expectedTotalPrize = LottoPrizeTable.FOURTH_PLACE.getPrize();

        // when
        LottoResult result = lottoResultChecker.getResult(userLottoTicket, winningLotto);
        TotalPrize totalPrize = result.getTotalPrize();

        // then
        assertThat(totalPrize.money())
                .isEqualTo(expectedTotalPrize);
    }

    @Test
    void 오등_당첨_1회_성공_테스트() {
        // given
        tickets.add(getFifthPlaceLotto());

        userLottoTicket = UserLottoTickets.newInstance(tickets);

        long expectedTotalPrize = LottoPrizeTable.FIFTH_PLACE.getPrize();

        // when
        LottoResult result = lottoResultChecker.getResult(userLottoTicket, winningLotto);
        TotalPrize totalPrize = result.getTotalPrize();

        // then
        assertThat(totalPrize.money())
                .isEqualTo(expectedTotalPrize);
    }

    private static Lotto getFourthPlaceLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 7, 8));
    }

    private static Lotto getThirdPlaceLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 8));
    }

    private static Lotto getSecondPlaceLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 7));
    }

    private static Lotto getFirstPlaceLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    private static Lotto getFifthPlaceLotto() {
        return new Lotto(List.of(1, 2, 3, 7, 8, 9));
    }

}