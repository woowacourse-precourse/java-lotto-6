package lottovender;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputViewTest {

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @AfterEach
    void closeConsole(){
        Console.close();
        //Console클래스의 readline()은 scanner객체를 한번만 불러오고 공유하고 있음
        //매번 테스트를 진행해도 첫번째 테스트에서 생성된 Scanner가 다음 테스트에도 계속 사용됨
        //두번째 테스트부터 할당한 System.in이 Scanner에 주입되지 않아 NoSuchElementException이 발생하는것임
        //따라서 Console.close()로 기존에 생성된 Scanner를 닫아주고 다시 생성해줘야 함
    }

    @DisplayName("구매 금액을 빈칸으로 입력할 시 예외 발생")
    @Test
    void input_blank() {
        InputStream inputPrice = setReadLine(" ");
        System.setIn(inputPrice);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.inputLottoPrice();
        });
    }

    @DisplayName("숫자가 아닐경우 예외 처리")
    @Test
    void input_not_a_number() {
        InputStream inputPrice = setReadLine("error");
        System.setIn(inputPrice);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.inputLottoPrice();
        });
    }

    @DisplayName("천원 단위로 나누어떨어지지않는 경우 예외 처리")
    @Test
    void input_can_not_be_divided_by_1000() {
        InputStream inputPrice = setReadLine("1004");
        System.setIn(inputPrice);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.inputLottoPrice();
        });
    }
}