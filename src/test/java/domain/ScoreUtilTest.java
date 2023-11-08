package domain;

import dto.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreUtilTest {

    private final ScoreUtil scoreUtil;

    public ScoreUtilTest() {
        scoreUtil = new ScoreUtil();
    }

    @Test
    @DisplayName("로토 당첨 내역 Map에 잘 저장되는지 확인하는 테스트")
    void updateScore() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        int bonusNumber = 45;
        Map<Integer, Integer> scoreMap = scoreUtil.updateScore(lottos, bonusNumber, winningNumbers);
        Assertions.assertEquals(scoreMap.get(0), 0);
        Assertions.assertEquals(scoreMap.get(1), 0);
        Assertions.assertEquals(scoreMap.get(2), 0);
        Assertions.assertEquals(scoreMap.get(3), 1);
        Assertions.assertEquals(scoreMap.get(4), 0);
        Assertions.assertEquals(scoreMap.get(5), 0);
        Assertions.assertEquals(scoreMap.get(6), 1);
    }
}