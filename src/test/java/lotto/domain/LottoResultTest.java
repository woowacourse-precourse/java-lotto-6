package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoResult lottoResult;
    private LottoWinningNumbers lottoWinningNumbers;

    @BeforeEach
    void setUp() {
        lottoWinningNumbers = new LottoWinningNumbers();
    }

    @DisplayName("당첨번호 5개가 맞고 보너스번호가 맞으면 2등이다.")
    @Test
    void BonusCountTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        consoleInput("1,2,3,4,5,6", "7");
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
        BonusNumber bonusNumber = new BonusNumber(winningNumbersInfo);
        lottoResult = new LottoResult(winningNumbersInfo, bonusNumber);
        List<Integer> purchaseNumber = List.of(1, 2, 3, 4, 6, 7);
        Method matchCountMethod = lottoResult.getClass().getDeclaredMethod("calculateLottoMatchCount", List.class);
        matchCountMethod.setAccessible(true);
        Method bonusCheck = lottoResult.getClass().getDeclaredMethod("bonusNumberCheck", int.class, List.class);
        bonusCheck.setAccessible(true);

        int matchCount = (int) bonusCheck.invoke(lottoResult,
                (int) matchCountMethod.invoke(lottoResult, purchaseNumber), purchaseNumber);

        assertThat(matchCount).isEqualTo(15);
    }


    private void consoleInput(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }
}
