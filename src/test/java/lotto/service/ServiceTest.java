package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Game;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    @DisplayName("로또 여러개를 구매한다.")
    @Test
    void purchaseLottos() {
        //given
        int amount = 2000;

        //when
        Buyer buyer = new Buyer(2000);
        Service service = new Service();
        service.purchaseLottos(buyer);

        //then
        assertThat(buyer.getLottos().size()).isEqualTo(2);
    }

    @DisplayName("로또 당첨 통계를 생성한다.")
    @Test
    void checkLottoStats() {
        //given
        int amount = 2000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        Buyer buyer = new Buyer(amount);
        buyer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        buyer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        Game game = new Game(winningNumbers, bonusNumber);
        Service service = new Service();
        service.checkLottoStats(buyer, game);

        //then
        assertThat(buyer.getResult()).isNotNull();
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateReturnRate() {
        //given
        int amount = 2000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        Buyer buyer = new Buyer(amount);
        buyer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        buyer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        Game game = new Game(winningNumbers, bonusNumber);
        Service service = new Service();
        service.checkLottoStats(buyer, game);
        service.calculateReturnRate(buyer);

        //then
        assertThat(buyer.getReturnRate()).isEqualTo(101500000);
    }
}
