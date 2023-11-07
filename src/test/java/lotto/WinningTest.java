package lotto;

import java.util.List;
import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.model.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.constant.ErrorConst.WINNING_HAS_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningTest {

    @Test
    @DisplayName("당첨 번호 6개와 보너스 번호 1개 사이에 중복이 있으면 예외가 발생한다")
    void createWinningByDuplicatedNumber() {
        Lotto main = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(3);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Winning(main, bonus);
        }).withMessage(WINNING_HAS_DUPLICATE);
    }

    @Test
    @DisplayName("모든 검증을 통과하면 당첨 번호+보너스 번호가 생성된다")
    void createWinningSuccessfully() {
        Lotto main = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);

        Winning winning = new Winning(main, bonus);
        assertThat(winning).isNotNull();

        assertThat(winning)
                .extracting("main")
                .extracting("numbers")
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winning)
                .extracting("bonus")
                .extracting("number")
                .isEqualTo(7);

    }

}
