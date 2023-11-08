package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import lotto.util.enums.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultComparatorTest {

    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    Lotto lotto;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        bonusNumber = new BonusNumber("7", winningNumbers);
        lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
    }

    @DisplayName("로또 번호와 당첨 번호를 비교해 일치하는 LottoResult Message를 반환하는 테스트")
    @Test
    void 최종_결과() {
        ResultComparator resultComparator = new ResultComparator(winningNumbers, bonusNumber);
        Optional<String> result = resultComparator.result(lotto);
        assertTrue(result.isPresent());
        assertEquals(LottoResult.MATCH_3.getDescription(), result.get());
    }
}