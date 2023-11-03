package lotto;

import lotto.view.InputView;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {


    @DisplayName("로또 번호의 입력이 공백이 입력되면 예외가 발생한다.")
    @Test
    void readBuyAmount_Space_ExceptionThrown() {

        assertThatThrownBy(() -> InputView.readBuyAmount()).isInstanceOf(IllegalArgumentException.class);

    }


}
