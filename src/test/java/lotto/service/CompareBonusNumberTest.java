package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import lotto.Lotto;
import lotto.readUserInput.BonusNumbers;
import lotto.readUserInput.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompareBonusNumberTest {
    private Lotto lotto;
    private CompareBonusNumber compareBonusNumber;
    private BonusNumbers bonusNumbers;

    @BeforeEach
    void beforeSetUp() {
        lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        compareBonusNumber = new CompareBonusNumber(lotto);
        bonusNumbers = new BonusNumbers();
    }

    @AfterEach
    void afterEach() {
        BonusNumbers.number = 0;
        Console.close();
    }

    @Test
    void 보너스있는지확인() {
        String inputNumber = "1";
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        bonusNumbers.read();
        Assertions.assertThat(compareBonusNumber.isThereBonus()).isEqualTo(true);
    }

    @Test
    void 보너스없는지확인() {
        String inputNumber = "10";
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        bonusNumbers.read();
        Assertions.assertThat(compareBonusNumber.isThereBonus()).isEqualTo(false);
    }
}