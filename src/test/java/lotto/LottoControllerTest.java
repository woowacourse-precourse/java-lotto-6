package lotto;

import Controller.LottoController;
import Model.Lotto;
import Model.PurchaseAmount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    private final int testPurchaseAmount = 5000;
    private LottoController lottoController;

    @BeforeEach
    void beforeEach() {
        lottoController = new LottoController();
        PurchaseAmount purchaseAmount = new PurchaseAmount(testPurchaseAmount);

        lottoController.publishMyLotto(purchaseAmount);
    }

    @DisplayName("로또 리스트 발행 시 크기 확인")
    @Test
    void testMyLottoSize() {
        int expectedLottoAmount = testPurchaseAmount / 1000;
        List<Lotto> lottoNumbers = lottoController.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(expectedLottoAmount);
    }

    @DisplayName("상금 계산")
    @Test
    void calculatePrize() {
        List<Integer> matchingCounts = List.of(1, 2, 3, 1, 1);

        int actualPrize = lottoController.calculatePrize(matchingCounts);
        int expectedPrize = 2034605000;

        assertThat(actualPrize).isEqualTo(expectedPrize);
    }
}
