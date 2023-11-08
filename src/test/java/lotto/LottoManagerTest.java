package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void printLottosCorrectlyDisplaysLottoNumbers() {
        LottoManager manager = new LottoManager();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(6, 4, 32, 19, 23, 42)),
                new Lotto(Arrays.asList(34, 25, 27, 6, 14, 17)),
                new Lotto(Arrays.asList(4, 7, 14, 39, 43, 22))
        );

        manager.printLottos(lottos);

        String expectedOutput = "3개를 구매했습니다.\n" +
                "[4, 6, 19, 23, 32, 42]\n" +
                "[6, 14, 17, 25, 27, 34]\n" +
                "[4, 7, 14, 22, 39, 43]\n";
        assertThat(outContent.toString()).isEqualToIgnoringNewLines(expectedOutput);
    }

    @Test
    void purchaseLottosReturnsCorrectNumberOfLottos() {
        LottoManager manager = new LottoManager();
        int purchaseAmount = 5000;
        List<Lotto> lottos = manager.purchaseLottos(purchaseAmount);

        assertThat(lottos).hasSize(5);
    }

    @Test
    void purchaseLottosThrowsExceptionForInvalidAmount() {
        LottoManager manager = new LottoManager();
        int invalidPurchaseAmount = 1500;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> manager.purchaseLottos(invalidPurchaseAmount))
                .withMessageContaining("[ERROR]");
    }


}
