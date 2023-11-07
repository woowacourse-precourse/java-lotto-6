package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoResult lottoResult;
    private LottoWinningNumbers lottoWinningNumbers;

    @BeforeEach
    void setUp() {
        lottoWinningNumbers = new LottoWinningNumbers();
        consoleInput("1,2,3,4,5,6", "7");
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
        BonusNumber bonusNumber = new BonusNumber(winningNumbersInfo);
        lottoResult = new LottoResult(winningNumbersInfo, bonusNumber);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("당첨번호 5개가 맞고 보너스번호가 맞으면 2등이다.")
    @Test
    void BonusCountTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> purchaseNumber = List.of(1, 2, 3, 4, 6, 7);
        Method matchCountMethod = lottoResult.getClass().getDeclaredMethod("calculateLottoMatchCount", List.class);
        matchCountMethod.setAccessible(true);
        Method bonusCheck = lottoResult.getClass().getDeclaredMethod("bonusNumberCheck", int.class, List.class);
        bonusCheck.setAccessible(true);

        int matchCount = (int) bonusCheck.invoke(lottoResult,
                (int) matchCountMethod.invoke(lottoResult, purchaseNumber), purchaseNumber);

        assertThat(matchCount).isEqualTo(15);
    }

    @DisplayName("당첨번호 6개 테스트")
    @Test
    void matchCount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> purchaseNumber = List.of(1, 2, 3, 4, 6, 5);
        Method matchCountMethod = lottoResult.getClass().getDeclaredMethod("calculateLottoMatchCount", List.class);
        matchCountMethod.setAccessible(true);
        Method bonusCheck = lottoResult.getClass().getDeclaredMethod("bonusNumberCheck", int.class, List.class);
        bonusCheck.setAccessible(true);

        int matchCount = (int) bonusCheck.invoke(lottoResult,
                (int) matchCountMethod.invoke(lottoResult, purchaseNumber), purchaseNumber);

        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("로또 여러개 당첨 테스트")
    @Test
    void multipleMatchCount() {

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 5, 8, 9, 11));
        Lotto lotto3 = new Lotto(List.of(11, 21, 31, 41, 5, 6));

        List<Lotto> purchaseLottoNumbers = List.of(lotto1, lotto2, lotto3);

        LottoCount lottoCount = lottoResult.getLottoStatus(purchaseLottoNumbers);

        assertThat(lottoCount.getSixCount()).isEqualTo(1);
        assertThat(lottoCount.getThreeCount()).isEqualTo(1);
    }

    private void consoleInput(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }
}
