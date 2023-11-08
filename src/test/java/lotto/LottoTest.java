package lotto;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCheckRankWhenRankIsSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        RankEnum result = lotto.checkRank(winnerNumbers, bonusNumber);
        assertEquals(RankEnum.SECOND, result);
    }

    @Test
    public void testCheckRankAllCase() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        RankEnum result1 = lotto.checkRank(winningNumbers, bonusNumber);
        assertEquals(RankEnum.FIRST, result1);

        List<Integer> winningNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber2 = 6;
        RankEnum result2 = lotto.checkRank(winningNumbers2, bonusNumber2);
        assertEquals(RankEnum.SECOND, result2);

        List<Integer> winningNumbers3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber3 = 6;
        RankEnum result3 = lotto.checkRank(winningNumbers3, bonusNumber3);
        assertEquals(RankEnum.THIRD, result3);

        List<Integer> winningNumbers4 = Arrays.asList(1, 2, 3, 4, 7, 8);
        int bonusNumber4 = 6;
        RankEnum result4 = lotto.checkRank(winningNumbers4, bonusNumber4);
        assertEquals(RankEnum.FORTH, result4);
    }

}