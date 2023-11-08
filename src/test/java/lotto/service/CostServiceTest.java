package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.domain.Cost;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CostServiceTest {
    private CostService costService;
    private WinningLotto winningLotto;

    @BeforeEach
    void initTest() {
        costService = new CostService();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @DisplayName("구매금액을 생성할 수 있다.")
    @CsvSource(value = {"'3000':3000", "'5000':5000", "'180000':180000"}, delimiter = ':')
    void fetchValidatedBonusTest(String readLine, int expect) {
        System.setIn(createInputStream(readLine));
        Cost cost = costService.fetchValidatedCost();
        Assertions.assertThat(cost.getCost()).isEqualTo(expect);
    }

    private InputStream createInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
