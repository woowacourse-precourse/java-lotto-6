package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TargetNumberHandlerTest {

    TargetNumberHandler targetNumberHandler = new TargetNumberHandler();

    @AfterEach
    void closeConsole(){
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,1,2,3,4,5", "0,2,3,4,5,6","46,2,3,4,5,6"})
    @DisplayName("타겟번호는 로또를 만들 수 있는 입력이여야 한다.")
    void 타겟번호_테스트(String input){
        setIn(input);

        Assertions.assertThatThrownBy(()->
                targetNumberHandler.setTargetLottoByInput())
                .isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,1,25", "1,43,23,21,6,7","1  , 2,  34, 5, 7, 9 "})
    @DisplayName("타겟번호는 로또를 만들 수 있는 입력이여야 한다.")
    void 타겟번호_테스트2(String input){
        setIn(input);

        Lotto lotto = targetNumberHandler.setTargetLottoByInput();
        
    }

    private static void setIn(String input){
        byte[] bytes = input.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
    }
}
