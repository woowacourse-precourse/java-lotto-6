package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.enums.LottoRule;
import lotto.enums.UserInterfaceMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoInputDrawNumberServiceTest {
    @DisplayName("잘못된_당첨_번호_형식")
    @ParameterizedTest(name = "{index}. {displayName} - drawNumber: {0}")
    @ValueSource(strings = {"1, 2, 3, a, 5", "1, 2, 3, 가, 5"})
    void 잘못된_당첨_번호_형식(String drawNumber) {
        assertThatThrownBy(() -> LottoInputDrawNumberService.getInstance().saveDrawNumber(drawNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(UserInterfaceMessage.ERROR_NUMBER_INCLUSIVE.getValue(),
                        LottoRule.START.getValue(), LottoRule.END.getValue()));
    }

    @DisplayName("당첨_번호_개수_잘못_입력")
    @ParameterizedTest(name = "{index}. {displayName} - drawNumber: {0}")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6, 7"})
    void 당첨_번호_개수_잘못_입력(String drawNumber) {
        assertThatThrownBy(() -> LottoInputDrawNumberService.getInstance().saveDrawNumber(drawNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInterfaceMessage.ERROR_PREFIX.getValue()
                        + String.format(UserInterfaceMessage.REQUEST_INPUT_PRICE_INFO.getValue(),
                        LottoRule.START.getValue(), LottoRule.END.getValue()));
    }

    @DisplayName("당첨_번호_입력_개수_체크")
    @ParameterizedTest(name = "{index}. {displayName} - drawNumber: {0}")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void 당첨_번호_입력_개수_체크(String drawNumber) {
        LottoInputDrawNumberService lottoInputDrawNumberService = LottoInputDrawNumberService.getInstance();
        lottoInputDrawNumberService.saveDrawNumber(drawNumber);
        assertThat(lottoInputDrawNumberService.getLottoDrawNumber().size()).isEqualTo(
                Arrays.stream(drawNumber.replace(" ","")
                        .split(",")).count());
    }
}