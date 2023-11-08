package lotto;

import lotto.validator.BonusNumValidator;
import lotto.validator.WinningLottoValidator;
import lotto.validator.WinningNumsValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 당첨 로또를 검증하는 클래스
 */
public class WinningLottoValidatorTest {

    private WinningLottoValidator bonusNumValidator = new WinningLottoValidator(new WinningNumsValidator(), new BonusNumValidator());

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되는 경우 예외 발생")
    void duplicateNum() {
        List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNum = 6;
        assertThatThrownBy(() -> bonusNumValidator.isUniqueBonusNum(winningNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
