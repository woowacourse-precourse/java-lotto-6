package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.GameRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRuleTest {
    GameRule gameRule = new GameRule();

    @DisplayName("게임의 수익률을 반환하는 테스트 입니다.")
    @Test
    void checkProfit() {
        List<Integer> list1 = new ArrayList<>(List.of(1, 0, 0, 0, 0));

        String result = gameRule.calculateProfit(8000, list1);

        assertThat(result).isEqualTo("62.5");
    }
}
