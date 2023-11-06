package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


class WinningTest {
    @DisplayName("model_Winning_보너스_볼_업데이트")
    @Test
    public void model_Winning_updateBonus() {
        Long equalCount = 5L;
        int bonusNumber = 7;
        List<Integer> userNumbers = Arrays.asList(1,3,5,7,22,44);
        Winning winning = new Winning(equalCount);
        winning.updateBonus(userNumbers, bonusNumber);

        assertThat(winning.getBonus()).contains("보너스 볼");
    }

    @DisplayName("model_Winning_보너스_볼_업데이트_하지_않음")
    @Test
    public void model_Winning_not_updateBonus() {
        Long equalCount = 5L;
        int bonusNumber = 6;
        List<Integer> userNumbers = Arrays.asList(1,3,5,7,22,44);
        Winning winning = new Winning(equalCount);
        winning.updateBonus(userNumbers, bonusNumber);

        assertThat(winning.getBonus()).contains("");
    }
}
