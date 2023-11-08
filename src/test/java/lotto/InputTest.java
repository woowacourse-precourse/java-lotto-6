package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.model.Cashier;
import lotto.model.Lotto;
import lotto.util.Parser;
import lotto.util.StringUtil;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @ParameterizedTest
    @EmptySource
    void 입력_하지_않았을_때_예외_발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtil.checkEmpty(input))
                .withMessage(ErrorMessage.REQUIRED_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "eight"})
    void 입력_값이_숫자가_아닐_때_예외_발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtil.checkNumber(input))
                .withMessage(ErrorMessage.IS_NOT_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {8001})
    void 구입_금액이_천원_단위가_아닐_때_null_반환(int purchaseAmount) {
        Cashier cashier = new Cashier();

        List<Lotto> lottos = cashier.takeOrder(purchaseAmount);

        assertThat(lottos).isNull();
    }

    @Test
    void 구입_금액이_0원일_때_null_반환() {
        Cashier cashier = new Cashier();
        int purchaseAmount = 0;

        List<Lotto> lottos = cashier.takeOrder(purchaseAmount);

        assertThat(lottos).isNull();
    }

    @ParameterizedTest
    @NullSource
    void 입력_값이_null일_때_예외_발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtil.checkNull(input))
                .withMessage(ErrorMessage.NULL);
    }

    @Test
    void 입력_받은_구입_금액을_검증_및_정수형으로_파싱_성공() {
        String purchaseAmount = "8000";

        int result = Parser.stringToInt(purchaseAmount);

        assertThat(result).isEqualTo(8000);
    }
}