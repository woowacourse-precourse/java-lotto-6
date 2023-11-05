package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import lotto.config.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceInputHandlerTest {

    PriceInputHandler priceInputHandler = new PriceInputHandler();

    @AfterEach
    void closeConsole(){
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"11123","만원","10000000000000"})
    void 구매입력_테스트(String input) {
        setIn(input);

        Assertions.assertThatThrownBy(()->
                priceInputHandler.dividePaymentIntoLottoPrice())
                .isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000","50000","100000"})
    void 구매입력_테스트2(String input) {
        setIn(input);

        int amount = priceInputHandler.dividePaymentIntoLottoPrice();

        Assertions.assertThat(amount).isEqualTo(Integer.parseInt(input)/ AppConfig.LOTTO_PRICE);
    }
    private static void setIn(String input) {
        byte[] bytes = input.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
    }
}