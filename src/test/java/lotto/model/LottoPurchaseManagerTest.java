package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseManagerTest {

    private LottoPurchaseManager lottoPurchaseManager;

    @DisplayName("구입 금액을 입력했을 때, 구입 개수가 제대로 계산되는지 확인")
    @Test
    void createLottoCount(){
        // given
        lottoPurchaseManager = new LottoPurchaseManager(3000);

        // when, then
        assertThat(lottoPurchaseManager.getPurchaseCount()).isEqualTo(3);
    }

    @DisplayName("로또 생성 로직이 제대로 작동하는지 확인")
    @Test
    void createLottoNumbers() {
        // given
        lottoPurchaseManager = new LottoPurchaseManager(3000);

        // when
        lottoPurchaseManager.generateLottos();

        // then
        lottoPurchaseManager.getLottos().forEach(System.out::println);
    }

    @DisplayName("구입 금액이 제대로 입력되는지 확인한다.")
    @Test
    void inputNormalAccount() {
        // given
        lottoPurchaseManager = new LottoPurchaseManager(8000);

        // when, then
        Assertions.assertThat(lottoPurchaseManager.getPurchaseAmount()).isEqualTo(8000);
    }

    @DisplayName("구입 금액에 음수가 입력되면 예외 메시지가 출력된다")
    @Test
    void inputNegativeAccount1() {
        // given
        int invalidNum = -1000;

        // when, then
        assertThatThrownBy(() -> lottoPurchaseManager = new LottoPurchaseManager(invalidNum))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원을 넘지 않으면 예외가 발생한다")
    @Test
    void inputSmallAccount() {
        // given
        int invalidNum = 100;

        // when, then
        assertThatThrownBy(() -> lottoPurchaseManager = new LottoPurchaseManager(invalidNum))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위로 입력되지 않으면 예외가 발생한다")
    @Test
    void inputNotMultipleOf1000() {
        // given
        int invalidNum = 1234;

        // when, then
        assertThatThrownBy(() -> lottoPurchaseManager = new LottoPurchaseManager(invalidNum))
            .isInstanceOf(IllegalArgumentException.class);
    }
}