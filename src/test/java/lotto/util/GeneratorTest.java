package lotto.util;

import java.util.List;
import lotto.domain.Lotto;
import lotto.parser.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratorTest {
    @DisplayName("랜덤 로또 6개를 생성한다.")
    @Test
    void printMessage() {
        int number = Parser.parsePurchaseAmount("8000");
        List<Lotto> ticket = Generator.publishTicket(number);
        for (Lotto lotto : ticket) {
            System.out.println(lotto.getNumbers());
        }
    }
}
