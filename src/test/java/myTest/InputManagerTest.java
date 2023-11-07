package myTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.InputManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    private InputManager inputManager;

    @BeforeEach
    void setUp() {
        inputManager = new InputManager();
    }

    @Test
    void 예외_테스트_입력받은_금액이_1000원_단위가_아닐_때() {
        String money = "5500";
        assertThatThrownBy(() -> inputManager.moneyValidate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또는 1000원 단위로 구매 할 수 있습니다.");
    }

    @Test
    void 예외_테스트_당첨_번호를_6개보다_많이_입력_했을_때() {
        List<Integer> correctNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> inputManager.sizeValidate(correctNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 예외_테스트_당첨_번호를_6개보다_적게_입력_했을_때() {
        List<Integer> correctNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> inputManager.sizeValidate(correctNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 예외_테스트_당첨_번호_중_1부터_45사이의_숫자가_아닐_때() {
        String input = "60";
        assertThatThrownBy(() -> inputManager.numberRangeValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1 ~ 45까지의 숫자만 가능합니다.");
    }

    @Test
    void 예외_테스트_당첨_번호_중_중복된_숫자가_있을_때() {
        List<Integer> correctNumbers = List.of(1, 2, 3);
        int number = 3;
        assertThatThrownBy(() -> inputManager.duplicateValidate(correctNumbers, number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복 된 번호가 존재 할 수 없습니다.");
    }

    @Test
    void 예외_테스트_당첨_번호_중_문자가_섞여_있을_때() {
        String input = "1,2,3,4,5,6번";
        assertThatThrownBy(() -> inputManager.inputToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 형식입니다.");
    }
}