package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratorTest {
    @DisplayName("랜덤 로또 6개를 생성한다.")
    @Test
    void printMessage() {
        Generator generator = new Generator();
        List<Lotto> ticket = generator.publishTicket();
        for (Lotto lotto : ticket) {
            System.out.println(lotto.getNumbers());
        }
    }
}
