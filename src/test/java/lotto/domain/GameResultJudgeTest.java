package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.vo.Lotto;
import lotto.vo.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임결과 판단 확인")
class GameResultJudgeTest {

    @Test
    void 결과_정상_판단() {
        // given
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // 4등 - 4개 맞고 보너스 틀림
                new Lotto(List.of(1, 2, 3, 4, 7, 9)), // 4등 - 4개 맞고 보너스 맞음
                new Lotto(List.of(1, 2, 3, 8, 9, 10)), // 5등 - 3개 맞고 보너스 틀림
                new Lotto(List.of(1, 2, 3, 7, 9, 10)), // 5등 - 3개 맞고 보너스 맞음
                new Lotto(List.of(1, 2, 10, 11, 12, 13)), // 꽝 - 2개맞음
                new Lotto(List.of(1, 10, 11, 12, 13, 14)), // 꽝 - 1개맞음
                new Lotto(List.of(10, 11, 12, 13, 14, 15)) // 꽝 - 0개맞음
        );
        Map<Rank, Integer> expectedResult = Map.of(
                Rank.RANK_1, 3,
                Rank.RANK_2, 4,
                Rank.RANK_3, 7,
                Rank.RANK_4, 2,
                Rank.RANK_5, 2,
                Rank.UNRANK, 3
        );

        // when
        Map<Rank, Integer> result = GameResultJudge.judge(winLotto, lottos);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}