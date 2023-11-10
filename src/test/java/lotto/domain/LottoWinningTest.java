package lotto.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoWinningTest {

    @Test
    public void testWinningCheck() {
        LottoWinning lottoWinning = new LottoWinning();

        // Creating purchased lottos
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));

        // Winning numbers and bonus number
        List<Integer> winningNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);
        int bonusNumber = 13;

        // Redirect console output for checking LottoRanking
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        lottoWinning.winningCheck(purchasedLottos, winningNumbers, bonusNumber);

        // Reset console output
        System.setOut(System.out);

        String[] rankings = outputStream.toString().trim().split(System.lineSeparator());

        assertEquals("FOURTH", rankings[0]); // Expected ranking for the first lotto
        assertEquals("MISS", rankings[1]); // Expected ranking for the second lotto
    }
}
