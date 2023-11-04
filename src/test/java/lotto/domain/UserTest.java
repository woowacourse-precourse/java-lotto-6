package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    @DisplayName("구입한 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    public void 구입_금액_천원_단위_테스트() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new User().purchaseLotto("1500");
        });
    }

    @Test
    @DisplayName("구입한 금액에 문자열이 입력되면 예외가 발생한다.")
    public void 구입_금액_문자열_테스트() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new User().purchaseLotto("aaa");
        });
    }

    @Test
    @DisplayName("구입한 금액이 0원이면 예외가 발생한다.")
    public void 구입_금액_최소_테스트() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new User().purchaseLotto("0");
        });
    }

}
