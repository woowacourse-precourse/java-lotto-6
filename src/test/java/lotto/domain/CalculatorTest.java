package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void calculateTheRateOfReturn() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Calculator.calculateTheRateOfReturn(List.of(0,0,0,0,1), 8000);
        String result = outputStream.toString();
        String expected = "3개 일치 (5,000원) - 1개" + System.lineSeparator()
                + "4개 일치 (50,000원) - 0개"+System.lineSeparator()
                + "5개 일치 (1,500,000원) - 0개" +System.lineSeparator()
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개"+System.lineSeparator()
                + "6개 일치 (2,000,000,000원) - 0개"+System.lineSeparator()
                + "총 수익률은 62.5%입니다."+System.lineSeparator();
        assertThat(result).isEqualTo(expected);

        System.setOut(standardOut);
    }
}