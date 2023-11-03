package lotto.service;

import static lotto.constant.LottoInfo.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class PlayerServiceTest {

    @Mock
    private Player mockPlayer = mock(Player.class);

    @Mock
    private LottoService mockLottoService = mock(LottoService.class);

    private final PlayerService playerService = new PlayerService(mockLottoService, mockPlayer);

    @Test
    @DisplayName(value = "로또 복권의 금액이 1,000원일 때 구입 금액에 알맞은 수량의 로또 복권을 구입하는지 확인")
    void purchaseLottoBy5000Won() {
        long buyingPrice = 5000;
        int quantity = (int) (buyingPrice / LOTTO_PRICE.getInfo());

        Lotto mockLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Mockito.when(mockLottoService.generateLotto()).thenReturn(mockLotto);
        Mockito.when(mockPlayer.getPurchasedLotto()).thenReturn(
                new ArrayList<>(
                        List.of(mockLotto, mockLotto, mockLotto, mockLotto, mockLotto)
                )
        );

        assertThat(playerService.purchaseLotto(buyingPrice).size()).isEqualTo(quantity).isEqualTo(5);
    }

    @Test
    void compareLottoNumbers() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Lotto mockLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Mockito.when(mockPlayer.getPurchasedLotto())
                .thenReturn(new ArrayList<>(List.of(mockLotto)));

        Mockito.when(mockLottoService.compareLotto(mockLotto, inputNumbers))
                .thenReturn(6);

        int[] lottoResult = playerService.compareLottoNumbers(inputNumbers, bonusNumber);
        assertThat(lottoResult[1]).isEqualTo(1);
    }

}