package controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.constant.ErrorMessage;
import lotto.model.LottoDatas;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameControllerTest {

    private LottoService lottoService;
    private LottoDatas lottoDatas;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void init() {
        lottoDatas = new LottoDatas();
        lottoService = new LottoService(lottoDatas);
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수 입력시 오류 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1200", "2100", "3100"})
    void 예외_테스트_1000으로_떨어지지_않는_수_입력(String purchase) {
        assertThatThrownBy(() -> lottoService.convertPurchaseToCount(purchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_NOT_UNDIVIDED_NUMBER_OF_THOUSAND.getMessage());
    }

    @DisplayName("숫작가 아닌 수 입력시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1200J", "asdf", "포비", "1234!"})
    void 숫자가_아닌_수_입력(String inputPurchase) {
        assertThatThrownBy(() -> lottoService.convertPurchaseToCount(inputPurchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_NOT_INTEGER_NUMBER.getMessage());
    }

    @DisplayName("구입 금액 넣을시 로또 구입개수로 변환 되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"2000", "5000", "10000"})
    void 변환_테스트(String inputPurchase) {
        lottoService.convertPurchaseToCount(inputPurchase);
        int number = Integer.parseInt(inputPurchase);
        assertEquals(lottoDatas.getLottoCount(), number / 1000);

    }

}
