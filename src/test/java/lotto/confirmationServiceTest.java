package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class confirmationServiceTest {


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
}
