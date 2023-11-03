package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRuleTest {

    @DisplayName("두 리스트를 비교해서 겹치는 숫자의 갯수를 반환하는 테스트입니다.")
    @Test
    void checkLottoCount() {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        int result = GameRule.countElement(list1, list2);

        assertThat(result).isEqualTo(6);
    }

}
