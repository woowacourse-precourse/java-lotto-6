package lotto.manager;

import static lotto.utils.constant.LottoWinningConstant.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import lotto.utils.constant.LottoWinningConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {

    private Judge judge;
    private WinningLotto winningLotto;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    private static final List<Integer> FIRST_PLACE_LIST = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> SECOND_PLACE_LIST = List.of(1, 2, 3, 4, 5, 7);
    private static final List<Integer> THIRD_PLACE_LIST = List.of(1, 2, 3, 4, 5, 9);
    private static final List<Integer> FOURTH_PLACE_LIST = List.of(1, 2, 3, 4, 9, 10);
    private static final List<Integer> FIFTH_PLACE_LIST = List.of(1, 2, 3, 8, 9, 10);
    private static final List<List<Integer>> NUMBER_LIST = List.of(
            FIRST_PLACE_LIST, SECOND_PLACE_LIST, THIRD_PLACE_LIST, FOURTH_PLACE_LIST, FIFTH_PLACE_LIST
    );

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = BonusNumber.of(7);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        judge = Judge.of(winningLotto);
    }

    @DisplayName("당첨 번호화 일치하는 정보를 알맞게 저장한다")
    @Test
    void validateJudge() {
        // given
        Map<LottoWinningConstant, Integer> statistics = new HashMap<>();
        for (LottoWinningConstant lottoWinningConstant : LottoWinningConstant.values()) {
            statistics.put(lottoWinningConstant, 1);
        }
        statistics.put(NONE, 0);
        // when
        for (List<Integer> numbers : NUMBER_LIST) {
            judge.judge(new Lotto(numbers));
        }
        Map<LottoWinningConstant, Integer> result = judge.getStatistics();

        // then
        assertThat(result).usingRecursiveComparison()
                .isEqualTo(statistics);

    }
}