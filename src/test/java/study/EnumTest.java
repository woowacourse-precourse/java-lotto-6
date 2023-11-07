package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import lotto.constant.PrizeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EnumTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUp() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("Enum.values() 호출 시 enum 선언 순서대로 출력된다.")
    @Test
    void printAllEnumValues() {
        System.out.println(Arrays.stream(PrizeMessage.values()).toList());
        assertThat(outputMessage.toString()).hasToString("[FIRST, SECOND, THIRD, FOURTH, FIFTH]\n");
    }

}
