package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void after() {
        Console.close();
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @DisplayName("로또 구매 갯수를 출력한다.")
    @Test
    void printLottoCountOfPurchase() {
        int lottosCount = 8;
        OutputView outputView = new OutputView();
        outputView.printLottoCountOfPurchase(lottosCount);
        assertThat(output()).contains("8개를 구매했습니다.");
    }

    @DisplayName("로또 번호를 출력한다.")
    @Test
    void printLottos() {
        OutputView outputView = new OutputView();
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8,21,23,41,42,43)),
                new Lotto(List.of(3,5,11,16,32,38)),
                new Lotto(List.of(7,11,16,35,36,44)),
                new Lotto(List.of(1,8,11,31,41,42)),
                new Lotto(List.of(13,14,16,38,42,45)),
                new Lotto(List.of(7,11,30,40,42,43)),
                new Lotto(List.of(2,13,22,32,38,45)),
                new Lotto(List.of(1,3,5,14,22,45))
        );
        outputView.printLottos(lottos);
        assertThat(output()).contains(
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "[7, 11, 16, 35, 36, 44]",
                "[1, 8, 11, 31, 41, 42]",
                "[13, 14, 16, 38, 42, 45]",
                "[7, 11, 30, 40, 42, 43]",
                "[2, 13, 22, 32, 38, 45]",
                "[1, 3, 5, 14, 22, 45]"
        );
    }
}