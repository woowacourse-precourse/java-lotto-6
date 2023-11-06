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
    @DisplayName("당첨번호 검증")
    void validate() {
        ArrayList<Integer> winningNumA = new ArrayList<>(List.of(1, 2, 3, 4, 5)); //5개 입력
        ArrayList<Integer> winningNumB = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5)); //중복 입력
        ArrayList<Integer> winningNumC = new ArrayList<>(List.of(1, 2, 3, 4, 5,46)); //범위 초과
        ArrayList<Integer> winningNumD = new ArrayList<>(List.of(1, 2, 3, 4, 5,6)); //정상 입력

        assertThrows(IllegalArgumentException.class,()->{
            WinningNumValidator.validate(winningNumA);
        });

        assertThrows(IllegalArgumentException.class,()->{
            WinningNumValidator.validate(winningNumB);
        });

        assertThrows(IllegalArgumentException.class,()->{
            WinningNumValidator.validate(winningNumC);
        });

        WinningNumValidator.validate(winningNumD);
    }

    @Test
    @DisplayName("보너스 번호 검증")
    void bonusValidate() {
        WinningNum winningNum = new WinningNum(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Integer bonusNumA = 1;
        Integer bonusNumB = 46;

        assertThrows(IllegalArgumentException.class,()->{ //중복
            winningNum.setBonusNumber(bonusNumA);
        });

        assertThrows(IllegalArgumentException.class,()->{ //범위
            winningNum.setBonusNumber(bonusNumB);
        });
    }
}