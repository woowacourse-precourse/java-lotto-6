package lotto.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.shop.Shop;
import lotto.domain.user.User;
import lotto.mock.TestLottoMachine;
import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("로또 구매 내역을 출력한다.")
    void printLottoOrder() {
        //given
        OutputView outputView = new OutputView();
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8))
        );

        //when
        outputView.printLottoOrder(lottos);
        //then
        Assertions.assertThat(captor.toString())
                .contains("3개를 구매했습니다.",
                        "[1, 2, 3, 4, 5, 6]",
                        "[2, 3, 4, 5, 6, 7]",
                        "[3, 4, 5, 6, 7, 8]");
    }
}