package lotto.domain;

import lotto.controller.LottoController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {
    @DisplayName("로또 번호와 당첨번호를 비교해 등수 확인")
    @Test
    void lottoRankTest(){
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "7";

        LottoController controller = new LottoController();

        // 3개 일치
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        Rank rank = Rank.calculateRank(userLotto, new WinningNumber(new Lotto(winningNumbers), bonusNumber));
        assertEquals(Rank.FIFTH, rank);

        // 5개 일치 (보너스 볼 불일치)
        userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        rank = Rank.calculateRank(userLotto, new WinningNumber(new Lotto(winningNumbers), bonusNumber));
        assertEquals(Rank.THIRD, rank);

        // 5개 일치 (보너스 볼 일치)
        userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        rank = Rank.calculateRank(userLotto, new WinningNumber(new Lotto(winningNumbers), bonusNumber));
        assertEquals(Rank.SECOND, rank);
    }
}
