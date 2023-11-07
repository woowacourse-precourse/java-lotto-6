package lotto.model;

import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningNumber;
import lotto.model.user.LottoResults;
import lotto.model.user.LottoTickets;
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
        tickets.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        tickets.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        tickets.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        tickets.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        tickets.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        tickets.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
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
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }


    @Test
    @DisplayName("로또 당첨 개수 추출")
    void calculateResult(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTickets lottoTickets = new LottoTickets(8);
                    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
                    BonusNumber bonusNumber = new BonusNumber(winningNumber, "7");

                    LottoResults expectedResult = new LottoResults( 0, 0, 0, 0, 1);

                    assertThat(lottoTickets.calculateResult(winningNumber, bonusNumber)).isEqualTo(expectedResult);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

}