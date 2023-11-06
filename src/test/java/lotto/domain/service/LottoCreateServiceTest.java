package lotto.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.domain.entity.Order;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LottoCreateServiceTest {
    private LottoCreateService lottoCreateService;

    @Mock
    private Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lottoCreateService = new LottoCreateService();
    }

    @DisplayName("5개 구매한만큼 로또 생성")
    @Test
    void purchaseLottos_구매한만큼_로또_생성() {
        int numberOfLottosToPurchase = 5;
        when(order.getNumberOfPurchaseLotto()).thenReturn(numberOfLottosToPurchase);

        List<Lotto> result = lottoCreateService.purchaseLottos(order);

        assertThat(result).hasSize(numberOfLottosToPurchase);
        for (Lotto lotto : result) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @DisplayName("당첨로또 생성")
    @Test
    void createWinningLotto_당첨로또_생성() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        WinningLotto result = lottoCreateService.createWinningLotto(numbers, bonusNumber);

        assertThat(result.getNumbers()).isEqualTo(numbers);
        assertThat(result.getBonusNumber()).isEqualTo(bonusNumber);
    }
}