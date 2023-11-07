package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.GameRule;
import lotto.Utils.LottoResultCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRuleTest {
    GameRule gameRule = new GameRule();

    @DisplayName("두 리스트를 비교해서 겹치는 숫자의 갯수를 반환하는 테스트입니다.")
    @Test
    void checkLottoCount() {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        int result = LottoResultCalculator.countElement(list1, list2);

        assertThat(result).isEqualTo(6);
    }

//    @DisplayName("로또 번호들과 비교할 로또 1개와 보너스 번호를 입력하는 테스트입니다.")
//    @Test
//    void calculateResultTest() {
//        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
//        List<Lotto> list2 = new ArrayList<>();
//        list2.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 6개 hit
//        list2.add(new Lotto(List.of(1, 2, 3, 11, 13, 14))); // 3개 hit
//        list2.add(new Lotto(List.of(1, 2, 11, 10, 9, 7)));  // 2개 hit
//        list2.add(new Lotto(List.of(1, 2, 3, 4, 5, 16))); // 5개
//        list2.add(new Lotto(List.of(1, 2, 3, 4, 5, 10))); // 5개 + 보너스 예정
//
//        List<Integer> cpuBonus = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        int playerBonus = 5;
//
//        List<Integer> answer = new ArrayList<>(List.of(1, 0, 1, 1, 1));
//
//        List<Integer> result = gameRule.calculateResult(new Cpu(list2, cpuBonus, 5000),
//                new Player(new Lotto(list1), playerBonus));
//
//        assertThat(result).isEqualTo(answer);
//    }

    @DisplayName("게임의 수익률을 반환하는 테스트 입니다.")
    @Test
    void checkProfit() {
        List<Integer> list1 = new ArrayList<>(List.of(1, 0, 0, 0, 0));

        String result = gameRule.calculateProfit(8000, list1);

        assertThat(result).isEqualTo("62.5");
    }
}
