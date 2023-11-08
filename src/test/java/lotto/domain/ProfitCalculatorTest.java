package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.LottoMachine;
import lotto.ProfitCalculator;
import lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ProfitCalculatorTest {

    @BeforeEach
    void setup() {
        LottoMachine.setMoney(0);
        LottoMachine.getTotalLottoTickets().clear();

        ProfitCalculator.firstPlace = 0;
        ProfitCalculator.secondPlace = 0;
        ProfitCalculator.thirdPlace = 0;
        ProfitCalculator.fourthPlace = 0;
        ProfitCalculator.fifthPlace = 0;
    }

    @Test
    void 등수_계산_5등인_경우() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setWinningLotto(winningLotto);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        ProfitCalculator.calculateRank(lotto, 3, false);

        assertThat(ProfitCalculator.fifthPlace).isEqualTo(1);
    }

    @Test
    void 등수_계산_4등인_경우() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setWinningLotto(winningLotto);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));

        ProfitCalculator.calculateRank(lotto, 4, false);

        assertThat(ProfitCalculator.fourthPlace).isEqualTo(1);
    }

    @Test
    void 등수_계산_3등인_경우() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setWinningLotto(winningLotto);
        WinningLotto.setBonusNumber(7); // 보너스 번호 설정
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        ProfitCalculator.calculateRank(lotto, 5, false);

        assertThat(ProfitCalculator.thirdPlace).isEqualTo(1);
    }

    @Test
    void 등수_계산_2등인_경우() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setWinningLotto(winningLotto);
        WinningLotto.setBonusNumber(7); // 보너스 번호 설정
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        ProfitCalculator.calculateRank(lotto, 5, true);

        assertThat(ProfitCalculator.secondPlace).isEqualTo(1);
    }
    @Test
    void 등수_계산_1등인_경우() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setWinningLotto(winningLotto);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        ProfitCalculator.calculateRank(lotto, 6, false);

        assertThat(ProfitCalculator.firstPlace).isEqualTo(1);
    }

    @Test
    void 겹치는_수_구하는_메소드_검사_일치_없음() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setWinningLotto(winningLotto);

        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        int overlaps = ProfitCalculator.compareIntersection(lotto);

        assertThat(overlaps).isEqualTo(0);
    }

    @Test
    void 겹치는_수_구하는_메소드_검사_일부_일치() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setWinningLotto(winningLotto);

        Lotto lotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        int overlaps = ProfitCalculator.compareIntersection(lotto);

        assertThat(overlaps).isEqualTo(3);
    }

    @Test
    void 겹치는_수_구하는_메소드_검사_모두일치() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setWinningLotto(winningLotto);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int overlaps = ProfitCalculator.compareIntersection(lotto);

        assertThat(overlaps).isEqualTo(6);
    }

    @Test
    void 수익_계산_테스트() {

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoMachine.setMoney(5000);
        WinningLotto.setWinningLotto(winningLotto);
        WinningLotto.setBonusNumber(7);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto4 = new Lotto(List.of(1, 2, 10, 11, 12,13));
        Lotto lotto5 = new Lotto(List.of(1, 10, 11, 12, 13, 14));

        LottoMachine.getTotalLottoTickets().add(lotto1);
        LottoMachine.getTotalLottoTickets().add(lotto2);
        LottoMachine.getTotalLottoTickets().add(lotto3);
        LottoMachine.getTotalLottoTickets().add(lotto4);
        LottoMachine.getTotalLottoTickets().add(lotto5);

        ProfitCalculator.determineRank();
        ProfitCalculator.calculateProfit();

        int profit = ProfitCalculator.getProfit();
        double profitRate = ProfitCalculator.getProfitRate();

        assertThat(profit).isEqualTo(1555000);
        assertThat(profitRate).isEqualTo(31100.0);
    }
}
