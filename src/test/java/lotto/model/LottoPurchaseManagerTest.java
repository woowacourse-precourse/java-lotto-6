package lotto.model;

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
        assertThat(lottoPurchaseManager.getCount()).isEqualTo(3);
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

    @DisplayName("유효하지 않은 카운트일때 로또가 생성되지 않는지 확인")
    @Test
    void createInvalidCountLotto() {
        // given
        lottoPurchaseManager = new LottoPurchaseManager(100);

        // when
        lottoPurchaseManager.generateLottos();

        // then
        Assertions.assertThat(lottoPurchaseManager.getLottos().size()).isEqualTo(0);
    }
}