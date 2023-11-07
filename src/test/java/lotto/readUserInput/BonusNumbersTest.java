package lotto.readUserInput;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusNumbersTest {
    private BonusNumbers bonusNumbers;

    @BeforeEach
    void beforeSetUp() {
        bonusNumbers = new BonusNumbers();
        BonusNumbers.number = 0;
        Console.close();
    }

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 보너스번호입력() {
        String number = "1";
        System.setIn(new ByteArrayInputStream(number.getBytes()));
        bonusNumbers.read();
        Assertions.assertThat(BonusNumbers.number).isEqualTo(1);
    }
}