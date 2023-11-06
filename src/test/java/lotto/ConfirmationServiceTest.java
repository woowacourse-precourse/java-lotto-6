package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfirmationServiceTest {


    @DisplayName("각각 당첨등수의 개수를 센다.")
    @Test
    void countWinning() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add( new Lotto(List.of(1, 2, 3, 4, 5, 6)) );
        lottos.add( new Lotto(List.of(1, 2, 9, 4, 5, 6)) );
        lottos.add( new Lotto(List.of(1, 9, 3, 4, 8, 6)) );
        lottos.add( new Lotto(List.of(1, 2, 9, 8, 7, 6)) );
        lottos.add( new Lotto(List.of(1, 2, 11, 4, 5, 6)) );

        ConfirmationService confirmationService = new ConfirmationService(lottos);
        confirmationService.confirmWinnings(List.of(1, 2, 3, 4, 5, 6), 11);

        assertThat(confirmationService.getWinningCount(Winning.FIRST)).isEqualTo(1);
        assertThat(confirmationService.getWinningCount(Winning.SECOND)).isEqualTo(1);
        assertThat(confirmationService.getWinningCount(Winning.THIRD)).isEqualTo(1);
        assertThat(confirmationService.getWinningCount(Winning.FOURTH)).isEqualTo(1);
        assertThat(confirmationService.getWinningCount(Winning.FIFTH)).isEqualTo(1);
    }

    @DisplayName("총 상금을 구한다.")
    @Test
    void getWinningPrizeAmountTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add( new Lotto(List.of(1, 2, 3, 4, 5, 6)) ); // First
        lottos.add( new Lotto(List.of(1, 2, 9, 4, 5, 6)) ); // Third
        lottos.add( new Lotto(List.of(1, 9, 3, 4, 8, 7)) ); // FIFTH
        lottos.add( new Lotto(List.of(1, 2, 9, 8, 7, 6)) ); // FIFTH
        lottos.add( new Lotto(List.of(1, 2, 11, 4, 5, 6)) ); //Second

        ConfirmationService confirmationService = new ConfirmationService(lottos);
        confirmationService.confirmWinnings(List.of(1, 2, 3, 4, 5, 6), 11);

        int prizeAmount = Winning.FIRST.getAmount();
        prizeAmount = prizeAmount + Winning.SECOND.getAmount();
        prizeAmount = prizeAmount + Winning.THIRD.getAmount();
        prizeAmount = prizeAmount + Winning.FIFTH.getAmount() * 2;
        assertThat(confirmationService.getWinningPrizeAmount()).isEqualTo(prizeAmount);

    }
}
