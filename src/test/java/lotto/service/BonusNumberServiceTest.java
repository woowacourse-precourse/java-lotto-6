package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusNumberServiceTest {
    private BonusNumberService bonusNumberService;
    private WinningLotto winningLotto;

    @BeforeEach
    void initTest() {
        bonusNumberService = new BonusNumberService();
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @DisplayName("Bonus번호를 생성할 수 있다.")
    @CsvSource(value = {"'8':8", "'9':9", "'45':45"}, delimiter = ':')
    void fetchValidatedBonusTest(String readLine, int expect) {
        System.setIn(createInputStream(readLine));
        Bonus bonus = bonusNumberService.fetchValidatedBonus(winningLotto);
        Assertions.assertThat(bonus.getNumber()).isEqualTo(expect);
    }

    private InputStream createInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }


}
