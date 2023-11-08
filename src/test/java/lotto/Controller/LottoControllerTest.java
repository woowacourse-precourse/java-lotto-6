package lotto.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.Domain.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    private static LottoController lottoController;

    @BeforeAll
    static void init() {
        lottoController = new LottoController();
        lottoController.setWinnerLotto(new Lotto(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoController.setBonusNumber(7);
    }

    @DisplayName("구입 가능한 로또 개수 연산 테스트")
    @Test
    void checkPurchaseAmountTest() {
        int purchaseAmount = lottoController.calcAvailableAmount(50000);
        assertThat(purchaseAmount).isEqualTo(50);
    }

    @DisplayName("로또 결과 도출 테스트(일반 5개 hit, 보너스 1개 hit")
    @Test
    void checkLottoResultTest0() {
        int[] result = lottoController.compareWinnerAndPurchased(new Lotto(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));
        assertThat(result[0]).isEqualTo(5);
        assertThat(result[1]).isEqualTo(1);
    }

    @DisplayName("로또 결과 도출 테스트(일반 6개 hit, 보너스 0개 hit")
    @Test
    void checkLottoResultTest1() {
        int[] result = lottoController.compareWinnerAndPurchased(new Lotto(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertThat(result[0]).isEqualTo(6);
        assertThat(result[1]).isEqualTo(0);
    }

    @DisplayName("로또 결과 도출 테스트(일반 0개 hit, 보너스 0개 hit")
    @Test
    void checkLottoResultTest2() {
        int[] result = lottoController.compareWinnerAndPurchased(new Lotto(
                new ArrayList<>(Arrays.asList(8, 9, 10, 11, 12, 13))));
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(0);
    }

    @DisplayName("로또 결과 도출 테스트(일반 0개 hit, 보너스 1개 hit")
    @Test
    void checkLottoResultTest3() {
        int[] result = lottoController.compareWinnerAndPurchased(new Lotto(
                new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12))));
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(1);
    }
}
