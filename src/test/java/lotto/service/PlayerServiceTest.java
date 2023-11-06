package lotto.service;

import lotto.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerServiceTest {

    Player player;
    PlayerService playerService;
    static LottoGenerator lottoGenerator;
    static WinningLottoCalculator winningLottoCalculator;

    @BeforeAll
    static void beforeAll(){
        lottoGenerator = new LottoGenerator();
        winningLottoCalculator = new WinningLottoCalculator();
    }

    @BeforeEach
    void beforeEach() {
        player = new Player();
        playerService = new PlayerService(player,lottoGenerator,winningLottoCalculator);
    }

    @Test
    @DisplayName("주어진 구매 개수만큼 로또가 생성된다.")
    void lottoBuyTest(){
        //given
        int lottoCount = 8;
        //when
        playerService.buy(lottoCount);
        //then
        Assertions.assertThat(player.getNumberOfLotto()).isEqualTo(lottoCount);
    }
}