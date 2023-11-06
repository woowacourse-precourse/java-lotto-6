package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameViewTest {

    private LottoGameView lottoView;

    @BeforeEach
    public void init() {
        lottoView = new LottoGameView();
    }

    @AfterEach
    public void close() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a","123a"," ","1500","123"})
    @DisplayName("로또 구입 금액을 입력한  결과가 1000단위로 나누어 떨어지는 숫자가 아닌 경우 예외 발생")
    public void testPurchaseInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(IllegalArgumentException.class, lottoView::inputPurchaseAmount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000","2000","25000"})
    @DisplayName("구입금액이 1000단위로 나누어 떨어지면 통과")
    public void testInputIsMultiple1000(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(lottoView::inputPurchaseAmount);
    }
}