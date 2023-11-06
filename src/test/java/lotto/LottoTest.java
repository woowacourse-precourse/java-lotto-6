package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



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

    @DisplayName("당첨되지 않은 로또는 0개, 당첨된 로또는 1개 이상이다.")
    @Test
    void findLottoWinner(){
        LottoResultWinners lottoResultWinners = new LottoResultWinners();
        lottoResultWinners.add(new LottoResult(Rank.SIX_MATCH.getNumberOfMatch(),Rank.SIX_MATCH.getBonus()));
        lottoResultWinners.add(new LottoResult(Rank.FIVE_MATCH_BONUS.getNumberOfMatch(),Rank.FIVE_MATCH_BONUS.getBonus()));
        lottoResultWinners.add(new LottoResult(Rank.FIVE_MATCH_BONUS.getNumberOfMatch(),Rank.FIVE_MATCH_BONUS.getBonus()));
        lottoResultWinners.add(new LottoResult(Rank.THREE_MATCH.getNumberOfMatch(),Rank.THREE_MATCH.getBonus()));

        assertThat(lottoResultWinners.getNumberOfWinner(Rank.SIX_MATCH) == 1);
        assertThat(lottoResultWinners.getNumberOfWinner(Rank.FIVE_MATCH) == 0);
        assertThat(lottoResultWinners.getNumberOfWinner(Rank.FIVE_MATCH_BONUS) == 2);
        assertThat(lottoResultWinners.getNumberOfWinner(Rank.THREE_MATCH) == 1);
    }
}