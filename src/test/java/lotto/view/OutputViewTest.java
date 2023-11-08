package lotto.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.shop.Shop;
import lotto.domain.user.User;
import lotto.dto.WinningResult;
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

    @Test
    @DisplayName("로또 당첨 내역을 출력한다.")
    void printLottoResult() {
        //given
        OutputView outputView = new OutputView();
        User user = new User();
        Shop shop = new Shop(new TestLottoMachine());
        user.buyLotto(8000, shop);
        user.checkLottoResult(new WinningLotto(List.of(11, 12, 13, 14, 15, 16), 17));
        //when
        outputView.printLottoStats(WinningResult.from(user));
        //then
        Assertions.assertThat(captor.toString())
                .contains("3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 0개",
                        "총 수익률은 62.5%입니다.");
    }
}