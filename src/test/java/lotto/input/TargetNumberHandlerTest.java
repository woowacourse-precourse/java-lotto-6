package lotto.input;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TargetNumberHandlerTest {

    TargetNumberHandler targetNumberHandler = new TargetNumberHandler();

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
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,1,2,3,4,5", "0,2,3,4,5,6", "46,2,3,4,5,6"})
    @DisplayName("타겟번호는 로또를 만들 수 있는 입력이여야 한다.")
    void 타겟번호_테스트(String input) {
        setIn(input);

        assertThatThrownBy(() ->
                        targetNumberHandler.setTargetLottoByInput())
                .isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "0", "46"})
    @DisplayName("보너스 번호는 타겟번호와 겹칠 수 없다. 1~45의 범위를 넘을 수 없다.")
    void 타겟번호_테스트2(String input) {
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        setIn(input);
        assertThatThrownBy(() ->
                        targetNumberHandler.setBonusByInput(target))
                .isInstanceOf(NoSuchElementException.class);
    }
}
