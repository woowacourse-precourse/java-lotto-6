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

public class LottoReturnTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        consoleInput("1,2,3,4,5,6", "7");
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers();
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
        BonusNumber bonusNumber = new BonusNumber(winningNumbersInfo);
        lottoResult = new LottoResult(winningNumbersInfo, bonusNumber);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    private void consoleInput(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }

    @DisplayName("당첨금액 구하는 테스트")
    @Test
    void getLottoReturnTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 5, 8, 9, 11));
        Lotto lotto3 = new Lotto(List.of(11, 21, 31, 41, 5, 6));

        List<Lotto> purchaseLottoNumbers = List.of(lotto1, lotto2, lotto3);

        LottoCount lottoCount = lottoResult.getLottoStatus(purchaseLottoNumbers);
        LottoReturn lottoReturn = new LottoReturn(lottoCount);

        Method method = lottoReturn.getClass().getDeclaredMethod("getLottoReturn");
        method.setAccessible(true);

        int returnAmount = (int) method.invoke(lottoReturn);
        assertThat(returnAmount).isEqualTo(2000005000);
    }

    @DisplayName("5000원으로 구매해서 5등에 당첨되면 수익률은 100%다")
    @Test
    void calculateReturnRate() {
        Lotto lotto1 = new Lotto(List.of(11, 22, 33, 44, 7, 9));
        Lotto lotto2 = new Lotto(List.of(1, 2, 5, 8, 9, 11));
        Lotto lotto3 = new Lotto(List.of(11, 21, 31, 41, 5, 6));
        Lotto lotto4 = new Lotto(List.of(10, 21, 31, 41, 5, 6));
        Lotto lotto5 = new Lotto(List.of(11, 21, 31, 41, 5, 6));

        List<Lotto> purchaseLottoNumbers = List.of(lotto1, lotto2, lotto3, lotto4, lotto5);

        LottoCount lottoCount = lottoResult.getLottoStatus(purchaseLottoNumbers);
        LottoReturn lottoReturn = new LottoReturn(lottoCount);
        int purchasePrice = 5000;

        double returnRate = lottoReturn.getLottoReturnRate(purchasePrice);
        // Assert
        assertThat(returnRate).isEqualTo(100.0);
    }
}
