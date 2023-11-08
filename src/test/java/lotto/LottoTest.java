package lotto;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.Lotto.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;

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

    @DisplayName("로또 안에 있는 당첨 번호 몇 개인지 세는 메서드 테스트")
    @Test
    void testCountingWinningNumberInLotto(){
        assertEquals(3, countWinningNumberInLotto(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(2, 4, 6, 8, 10, 12))));
    }

    @DisplayName("로또 번호, 보너스 번호, 당첨 번호로 등수 판단하는 메서드 테스트")
    @Test
    void testJudgingLottoRank() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // Rank.NOT 테스트 (count < 3)
        Lotto lottoRankNot = new Lotto(List.of(2, 4, 8, 9, 10, 12));
        Rank resultRankNot = judgeLottoRank(winningNumbers, lottoRankNot, bonusNumber);
        assertEquals(Rank.NOT, resultRankNot);

        // Rank.FIFTH 테스트 (count == 3)
        Lotto lottoRankFIFTH = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Rank resultRankFIFTH = judgeLottoRank(winningNumbers, lottoRankFIFTH, bonusNumber);
        assertEquals(Rank.FIFTH, resultRankFIFTH);

        // Rank.FOURTH 테스트 (count == 4)
        Lotto lottoRankFOURTH = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Rank resultRankFOURTH = judgeLottoRank(winningNumbers, lottoRankFOURTH, bonusNumber);
        assertEquals(Rank.FOURTH, resultRankFOURTH);

        // Rank.THIRD 테스트 (count == 5, 보너스 번호가 없을 때)
        Lotto lottoRankTHIRD = new Lotto(List.of(1,2,3,4,5,8));
        Rank resultRankTHIRD = judgeLottoRank(winningNumbers, lottoRankTHIRD, bonusNumber);
        assertEquals(Rank.THIRD, resultRankTHIRD);

        // Rank.SECOND 테스트 (count == 5, 보너스 번호와 일치)
        Lotto lottoRankSECOND = new Lotto(List.of(1,2,3,4,5,7));
        Rank resultRankSECOND = judgeLottoRank(winningNumbers, lottoRankSECOND, 7);
        assertEquals(Rank.SECOND, resultRankSECOND);

        // Rank.FIRST 테스트 (count == 6)
        Lotto lottoRankFIRST = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank resultRankFIRST = judgeLottoRank(winningNumbers, lottoRankFIRST, bonusNumber);
        assertEquals(Rank.FIRST, resultRankFIRST);
    }

    @DisplayName("한 정수가 당첨 번호 안에 있는지 판단하는 메서드 테스트")
    @Test
    void testCheckingLottoNumberInWinningNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // 포함되는 숫자 테스트
        int numberTrue = 3;
        assertTrue(checkLottoNumberInWinningNumber(winningNumbers, numberTrue));

        // 포함되지 않는 숫자 테스트
        int numberFalse = 7;
        assertFalse(checkLottoNumberInWinningNumber(winningNumbers, numberFalse));
    }


}