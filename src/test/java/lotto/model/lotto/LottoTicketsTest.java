package lotto.model.lotto;

import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningNumber;
import lotto.model.user.LottoResults;
import lotto.model.lotto.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    List<Lotto> tickets = new ArrayList<>();
    LottoTickets expectedTickets;

    @BeforeEach
    public void init(){
        tickets.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        tickets.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        expectedTickets = new LottoTickets(tickets);
    }

    @Test
    @DisplayName("입력된 개수만큼 랜덤 로또 만들기")
    void makeLottoTickets(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = new LottoTickets(8);
                    assertThat(lottoTickets).isEqualTo(expectedTickets);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }


    @Test
    @DisplayName("로또 5등 당첨 확인")
    void calculate5PlaceResult(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = new LottoTickets(2);
                    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
                    BonusNumber bonusNumber = new BonusNumber(winningNumber, "7");

                    LottoResults expectedResult = new LottoResults( 0, 0, 0, 0, 1);

                    assertThat(lottoTickets.calculateResult(winningNumber, bonusNumber)).isEqualTo(expectedResult);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    @DisplayName("로또 4등 당첨 확인")
    void calculate4PlaceResult(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = new LottoTickets(2);
                    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
                    BonusNumber bonusNumber = new BonusNumber(winningNumber, "7");

                    LottoResults expectedResult = new LottoResults( 0, 0, 0, 1, 0);

                    assertThat(lottoTickets.calculateResult(winningNumber, bonusNumber)).isEqualTo(expectedResult);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(1, 3, 5, 2, 22, 45)
        );
    }

    @Test
    @DisplayName("로또 3등 당첨 확인")
    void calculate3PlaceResult(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = new LottoTickets(2);
                    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
                    BonusNumber bonusNumber = new BonusNumber(winningNumber, "7");

                    LottoResults expectedResult = new LottoResults( 0, 0, 1, 0, 0);

                    assertThat(lottoTickets.calculateResult(winningNumber, bonusNumber)).isEqualTo(expectedResult);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(1, 2, 3, 4, 5, 45)
        );
    }

    @Test
    @DisplayName("로또 2등 당첨 확인")
    void calculate2PlaceResult(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = new LottoTickets(2);
                    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
                    BonusNumber bonusNumber = new BonusNumber(winningNumber, "7");

                    LottoResults expectedResult = new LottoResults( 0, 1, 0, 0, 0);

                    assertThat(lottoTickets.calculateResult(winningNumber, bonusNumber)).isEqualTo(expectedResult);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @Test
    @DisplayName("로또 1등 당첨 확인")
    void calculate1PlaceResult(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = new LottoTickets(2);
                    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
                    BonusNumber bonusNumber = new BonusNumber(winningNumber, "7");

                    LottoResults expectedResult = new LottoResults( 1, 0, 0, 0, 0);

                    assertThat(lottoTickets.calculateResult(winningNumber, bonusNumber)).isEqualTo(expectedResult);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
}