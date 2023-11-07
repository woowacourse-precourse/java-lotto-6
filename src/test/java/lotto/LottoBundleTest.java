package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import model.Lotto;
import model.LottoBundle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {
    private LottoBundle bundle;

    // 테스트 후 인스턴스 상태 초기화
    @AfterEach
    void tearDown() {
        bundle.clear();
    }

    @DisplayName("로또 묶음이 사용자가 입력 한 금액에 부합하는 로또의 개수로 이뤄져 있는지 확인하는 테스트")
    @Test
    void lottoBundleHasCorrectSize() {
        //given
        bundle = LottoBundle.getInstance();
        //when
        bundle.addLotto(10);
        //then
        assertThat(bundle.getLottoBundle()).hasSize(10);
    }

    @DisplayName("로또 묶음의 요소들이 Lotto의 인스턴스인지 확인하는 테스트")
    @Test
    void lottoBundleMadeUpOfLotto() {
        //given
        bundle = LottoBundle.getInstance();
        //when
        bundle.addLotto(10);
        //then
        assertThat(bundle.getLottoBundle()).allMatch(element -> element instanceof Lotto);
    }
}
