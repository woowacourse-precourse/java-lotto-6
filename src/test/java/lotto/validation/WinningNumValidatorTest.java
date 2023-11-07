package lotto.validation;

import lotto.domain.WinningNum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumValidatorTest {

    @Test
    @DisplayName("당첨번호에 입력이 6개가 아닐 경우 에러")
    void 당첨번호_갯수_부족() {
        ArrayList<Integer> winningNum = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        assertThrows(IllegalArgumentException.class,()->{
            WinningNumValidator.validate(winningNum);
        });
    }

    @Test
    @DisplayName("당첨번호에 중복입력이 있을 경우 에러")
    void 당첨_중복() {
        ArrayList<Integer> winningNum = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        assertThrows(IllegalArgumentException.class,()->{
            WinningNumValidator.validate(winningNum);
        });
    }

    @Test
    @DisplayName("당첨번호가 범위를 벗어날 경우 에러")
    void 범위_초과() {
        ArrayList<Integer> winningNum = new ArrayList<>(List.of(1, 2, 3, 4, 5,46));

        assertThrows(IllegalArgumentException.class,()->{
            WinningNumValidator.validate(winningNum);
        });
    }

    @Test
    @DisplayName("보너스 번호 중복 검증")
    void 보너스번호_중복() {
        WinningNum winningNum = new WinningNum(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Integer bonusNumA = 1;

        assertThrows(IllegalArgumentException.class,()->{
            winningNum.setBonusNumber(bonusNumA);
        });
    }

    @Test
    @DisplayName("보너스 번호 범위 예외")
    void 보너스번호_범위_예외() {
        WinningNum winningNum = new WinningNum(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Integer bonusNumB = 46;

        assertThrows(IllegalArgumentException.class,()->{ //범위
            winningNum.setBonusNumber(bonusNumB);
        });
    }
}