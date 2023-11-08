package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLottosTest {

    @Test
    @DisplayName("구매금액과 다른 로또 구매 수량 반환 시 실패")
    void getSize() {
        UserLottos userLottos = new UserLottos(10000);
        assertEquals(userLottos.getSize(), 10);
    }

    @Test
    @DisplayName("사용자가 구매한 로또 리스트가 구매 수량만큼 없을 시 실패")
    void getLottos() {
        UserLottos userLottos = new UserLottos(10000);
        assertEquals(userLottos.getLottos().size(), 10);
    }

    @Test
    @DisplayName("사용자가 구매한 로또들의 번호 문자열이 리스트와 다를 시 실패")
    void getLottosString() {
    }

    @Test
    @DisplayName("사용자의 로또 구매 금액과 다른 값을 반환 시 실패")
    void getAmount() {
        UserLottos userLottos = new UserLottos(10000);
        assertEquals(userLottos.getAmount(), 10000);
    }
}