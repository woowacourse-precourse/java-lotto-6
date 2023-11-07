package lotto.input;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import lotto.config.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceInputHandlerTest {

    PriceInputHandler priceInputHandler = new PriceInputHandler();

    private static void setIn(String input) {
        byte[] bytes = input.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"11123", "만원", "10000000000000"})
    void 구매입력_테스트(String input) {
        setIn(input);

        assertThatThrownBy(() ->
                        priceInputHandler.dividePaymentIntoLottoPrice())
                .isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "50000", "100000"})
    void 구매입력_테스트2(String input) {
        setIn(input);

        int amount = priceInputHandler.dividePaymentIntoLottoPrice();

        assertThat(amount).isEqualTo(Integer.parseInt(input) / Constants.LOTTO_PRICE);
    }
}