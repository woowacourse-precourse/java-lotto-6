package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private GameService gameService = new GameService();

    @DisplayName("구입금액을 받아 당첨 로또를 생성한다.")
    @Test
    public void initGame_구입금액_받아_당첨번호_생성(){
        //given
        int lottoMoney = 5000;

        //when
        gameService.initGame(lottoMoney);

        //then
        assertThat(gameService.getWinningLottos().size()).isEqualTo(lottoMoney / Lotto.LOTTO_PRICE);
    }

}