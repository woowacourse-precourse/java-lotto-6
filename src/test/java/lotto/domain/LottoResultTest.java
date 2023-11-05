package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoWinningNumbers lottoWinningNumbers;

    @BeforeEach
    void setUp() {
        lottoWinningNumbers = new LottoWinningNumbers();
        consoleInput("1,2,3,4,5,6", "7");
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
    }

    @DisplayName("당첨 갯수가 5개인지 확인")
    @Test
    void MachCountTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoResult lottoResult = new LottoResult(lottoWinningNumbers);
        List<Integer> purchaseNumber = List.of(1, 2, 3, 4, 6, 9);
        Method method = lottoResult.getClass().getDeclaredMethod("getLottoMatchCount", List.class);
        method.setAccessible(true);

        int matchCount = (int) method.invoke(lottoResult, purchaseNumber);
        assertThat(matchCount).isEqualTo(5);
    }



    private void consoleInput(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }
}
