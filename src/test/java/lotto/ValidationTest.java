package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.util.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidationTest extends NsTest {
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 구입금액이_1000원_단위가_아니면_예외_처리 () {
        int input = 1500;
        assertThatThrownBy(() -> Validator.purchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
