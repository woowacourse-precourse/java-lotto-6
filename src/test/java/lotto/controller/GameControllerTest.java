package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.service.GameService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameControllerTest {

    @AfterEach
    void afterEach () {
        Console.close();
    }

    @Test
    void 입력데이터_테스트() {
        int purchaseAmount = 4000;
        String winningNumbers = "1,2,3,4,5,6";
        int bonusNumber = 8;

        String inputData = purchaseAmount + "\n" + winningNumbers + "\n" + bonusNumber;
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);
        gameController.play();


        List<Lotto> lottos = gameService.getLottos();

        assertThat(gameService.getPurchaseAmount()).isEqualTo(purchaseAmount);


        assertThat(lottos.get(0).getNumbers().size()).isEqualTo(6);
        assertThat(lottos.get(1).getNumbers().size()).isEqualTo(6);
        assertThat(lottos.get(2).getNumbers().size()).isEqualTo(6);
        assertThat(lottos.get(3).getNumbers().size()).isEqualTo(6);


        Lotto winningLotto = gameService.getWinningLotto();
        assertThat(winningLotto.getNumbers().get(0)).isEqualTo(1);
        assertThat(winningLotto.getNumbers().get(1)).isEqualTo(2);
        assertThat(winningLotto.getNumbers().get(2)).isEqualTo(3);
        assertThat(winningLotto.getNumbers().get(3)).isEqualTo(4);
        assertThat(winningLotto.getNumbers().get(4)).isEqualTo(5);
        assertThat(winningLotto.getNumbers().get(5)).isEqualTo(6);
        assertThat(winningLotto.getNumbers().size()).isEqualTo(6);


        assertThat(gameService.getBonusNumber()).isEqualTo(bonusNumber);
    }

}