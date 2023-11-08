package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCalculatorTest {

    private Set<Integer> winningNumbers;
    private int bonusNumber;
    private LottoResultCalculator lottoResultCalculator;

    @BeforeEach
    void setUp() {
        winningNumbers = Set.of(3, 12, 18, 23, 34, 41);
        bonusNumber = 42;
        lottoResultCalculator = new LottoResultCalculator(winningNumbers, bonusNumber);
    }

    @DisplayName("정확한 매치 수와 보너스 매치 여부를 반환한다")
    @Test
    void calculateResult() {
        Set<Integer> userNumbers = Stream.of(3, 12, 18, 22, 29, 7).collect(Collectors.toSet());
        LottoResultCalculator.LottoResult result = lottoResultCalculator.calculateResult(userNumbers);
        assertEquals(result.getMatchCount(), result.getMatchCount());
        assertEquals(result.isBonusMatch(), result.isBonusMatch());
    }

}
