package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {

    @Test
    void 구매금액_입력_테스트() {
        GameService gameService = new GameService();
        gameService.setPurchaseAmount(1000);

        assertThat(gameService.getPurchaseAmount()).isEqualTo(1000);
    }

    @Test
    void 로또_6자리숫자_발행_테스트() {
        GameService gameService = new GameService();
        gameService.setPurchaseAmount(1000);
        gameService.publishLottoNumbers();

        List<Lotto> lottos = gameService.getLottos();

        assertThat(lottos.get(0).getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또_구매금액_발행_테스트() {
        GameService gameService = new GameService();
        gameService.setPurchaseAmount(3000);
        gameService.publishLottoNumbers();

        List<Lotto> lottos = gameService.getLottos();

        assertThat(lottos.get(0).getNumbers().size()).isEqualTo(6);
        assertThat(lottos.get(1).getNumbers().size()).isEqualTo(6);
        assertThat(lottos.get(2).getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또_구매금액_발행_예외테스트() {
        GameService gameService = new GameService();
        gameService.setPurchaseAmount(4000);
        gameService.publishLottoNumbers();

        List<Lotto> lottos = gameService.getLottos();

        assertThat(lottos.get(3).getNumbers().size()).isEqualTo(6);
        assertThatThrownBy(() -> lottos.get(4)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> lottos.get(5)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void 당첨번호_입력_테스트() {
        GameService gameService = new GameService();
        gameService.createWinningLotto(Arrays.asList(1,2,3,4,5,6));

        Lotto winningLotto = gameService.getWinningLotto();

        assertThat(winningLotto.getNumbers().get(0)).isEqualTo(1);
        assertThat(winningLotto.getNumbers().get(1)).isEqualTo(2);
        assertThat(winningLotto.getNumbers().get(2)).isEqualTo(3);
        assertThat(winningLotto.getNumbers().get(3)).isEqualTo(4);
        assertThat(winningLotto.getNumbers().get(4)).isEqualTo(5);
        assertThat(winningLotto.getNumbers().get(5)).isEqualTo(6);
        assertThat(winningLotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 당첨번호_중복입력_예외테스트() {
        GameService gameService = new GameService();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> gameService.createWinningLotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_범위초과_예외테스트() {
        GameService gameService = new GameService();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> gameService.createWinningLotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_범위미만_예외테스트() {
        GameService gameService = new GameService();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> gameService.createWinningLotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_입력_테스트() {
        GameService gameService = new GameService();
        int inputBonusNumber = 2;
        gameService.setBonusNumber(inputBonusNumber);

        assertThat(gameService.getBonusNumber()).isEqualTo(inputBonusNumber);
    }
}