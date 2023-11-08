package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {

    @Test
    @DisplayName("정상적인 값을 넣을 경우, 생성 되는지 테스트")
    public void testValidWinningLotto() {
        WinningLotto result = new WinningLotto(makeValidLotto(),10);

        Assertions.assertEquals(10, result.getBonusNumber());
        Assertions.assertEquals(List.of(1,2,3,4,5,6), result.getLotto().getNumbers());
    }

    @Test
    @DisplayName("보너스 숫자가 로또 숫자에 이미 있는 경우 테스트")
    public void testDuplicateBonusNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new WinningLotto(makeValidLotto(), 5));
    }

    @Test
    @DisplayName("보너스 숫자 범위 벗어난 경우 테스트")
    public void testInvalidBonusNumberRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new WinningLotto(makeValidLotto(), 46));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new WinningLotto(makeValidLotto(), -1));
    }


    private Lotto makeValidLotto() {
        return new Lotto(List.of(1,2,3,4,5,6));
    }

}
