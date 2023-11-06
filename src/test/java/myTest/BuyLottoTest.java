package myTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.BuyLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuyLottoTest {

    private BuyLotto buyLotto;

    @BeforeEach
    void setUp() {
        buyLotto = new BuyLotto();
    }

    @Test
    void 예외_테스트_입력받은_금액에_문자가_포함되어_있을_때() {
        String money = "10000원";
        assertThatThrownBy(() -> buyLotto.moneyValidate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    void 예외_테스트_입력받은_금액이_1000원_단위가_아닐_때() {
        String money = "5500";
        assertThatThrownBy(() -> buyLotto.moneyValidate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또는 1000원 단위로 구매 할 수 있습니다.");
    }

    @Test
    void 예외_테스트_당첨_번호를_6개보다_많이_입력_했을_때() {
        String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> buyLotto.correctNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 입력 해 주세요.");
    }

    @Test
    void 예외_테스트_당첨_번호를_6개보다_적게_입력_했을_때() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> buyLotto.correctNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 입력 해 주세요.");
    }

    @Test
    void 예외_테스트_당첨_번호_중_1부터_45사이의_숫자가_아닐_때() {
        String input = "1,2,3,4,5,60";
        assertThatThrownBy(() -> buyLotto.correctNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERRER] 로또 번호는 1 ~ 45 사이의 숫자만 존재 할 수 있습니다.");
    }

    @Test
    void 예외_테스트_당첨_번호_중_중복된_숫자가_있을_때() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> buyLotto.correctNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복 된 번호가 존재 할 수 없습니다.");
    }
}