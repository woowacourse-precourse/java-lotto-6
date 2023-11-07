package lotto.model;
import lotto.model.Lotto;
import lotto.utils.PrizeNumberValidator;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class PrizeTest {
    @DisplayName("6개 이상의 당첨번호가 입력되면 예외가 발생한다.")
    @Test
    void checkOverSixNumbers() {
        assertThatThrownBy(() -> new PrizeNumberValidator(List.of(1, 2, 3, 4, 5, 6, 7), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
