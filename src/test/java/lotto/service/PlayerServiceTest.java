package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.CorrectCount;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerServiceTest {

    Player player;
    PlayerService playerService;

    @BeforeEach
    void beforeEach() {
        player = new Player(new CorrectLottoCalculator());
        playerService = new PlayerService(player,new LottoGenerator(),new WinningLottoCalculator());
    }

    @Test
    @DisplayName("주어진 구매 개수만큼 로또가 생성된다.")
    void lottoBuyTest(){
        //given
        int lottoCount = 8;
        //when
        playerService.buy(lottoCount);
        //then
        assertThat(player.getNumberOfLotto()).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("로또 숫자를 맞춘 개수를 정확하게 계산한다.")
    void lottoCheckTest(){
        //given
        final Lotto lotto = new Lotto(List.of(1,3,5,7,9,10));
        final List<Integer> WINNING_NUMBER = List.of(1,2,3,4,5,6);
        final int BONUS_NUMBER = 10;
        final int CORRECT_COUNT = 3;
        final int CORRECT_BONUS_COUNT = 1;
        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBER,BONUS_NUMBER);
        //when
        player.addLotto(lotto);
        playerService.check(winningNumbers);
        //then
        for (CorrectCount correctCount : player.getCorrectCounts()) {
            assertEquals(CORRECT_COUNT, correctCount.getCorrectNumberCount(),"맞춘 개수가 동일해야 한다.");
            assertEquals(CORRECT_BONUS_COUNT, correctCount.getCorrectBonusNumberCount(),"보너스 개수가 동일해야 한다.");
        }
    }
}
