package lotto.validation;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.service.ValidateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class validationTest {
    ValidateService validateService = new ValidateService();

    @Test
    @DisplayName("구입금액 입력시 숫자가 아닌값을 입력하면 예외가 일어난다")
    void 번호에_숫자가아닌값_입력() {
        String inputItem = "18000;";

        assertThatThrownBy(() -> validateService.validateNumber(inputItem)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
    }


}
