package lotto.view;

import static lotto.view.GameView.printReturnRate;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameViewTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("실수형 변수가 제대로 출력되는지 확인")
    @Test
    void printReturnRateTest1() {
        float returnRate1 = 10.0f;

        printReturnRate(returnRate1);
        String expectedOutput1 = "총 수익률은 10%입니다.";
        assertEquals(expectedOutput1, outputStream.toString().trim());
        outputStream.reset();
    }

    @DisplayName("실수형 변수가 제대로 출력되는지 확인")
    @Test
    void printReturnRateTest2() {
        float returnRate2 = 5.5f;

        printReturnRate(returnRate2);
        String expectedOutput2 = "총 수익률은 5.5%입니다.";
        assertEquals(expectedOutput2, outputStream.toString().trim());
        outputStream.reset();
    }

    @DisplayName("실수형 변수가 제대로 출력되는지 확인")
    @Test
    void printReturnRateTest3() {
        float returnRate3 = 3.33f;

        printReturnRate(returnRate3);
        String expectedOutput3 = "총 수익률은 3.33%입니다.";
        assertEquals(expectedOutput3, outputStream.toString().trim());
        outputStream.reset();
    }
}