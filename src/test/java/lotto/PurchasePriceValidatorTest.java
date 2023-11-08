package lotto;

import lotto.validator.PurchasePriceValidator;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class PurchasePriceValidatorTest {

    private static final PurchasePriceValidator purcharsePriceValidator = new PurchasePriceValidator();

    @Test
    void 구매_가격_정상_입력() {
        assertThatCode(() -> purcharsePriceValidator.validate("3000"))
                .doesNotThrowAnyException();
    }

    @Test
    void 구매_가격_숫자_외_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> purcharsePriceValidator.validate("3d"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구매_가격_숫자_외_문자_입력2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> purcharsePriceValidator.validate("-20"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구매_가격_잘못된_단위_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> purcharsePriceValidator.validate("1002"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
