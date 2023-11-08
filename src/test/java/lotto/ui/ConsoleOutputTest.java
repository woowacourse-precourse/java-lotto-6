package lotto.ui;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleOutputTest {
    private static final String LOTTO_PRICE_REQUEST = "구입금액을 입력해 주세요.";

    @Test
    @DisplayName("로또 구입금액 입력 요청 출력")
    void 로또_구입금액_입력_요청_출력() {
        //given
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        //when
        Output output = new ConsoleOutput();
        output.printLottoPriceRequest();

        //then
        String result = captor.toString().trim();
        assertThat(result).isEqualTo(LOTTO_PRICE_REQUEST);
    }

    @Test
    @DisplayName("로또 내역 출력")
    void 로또_내역_출력() {
        //given
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(32, 33, 34, 35, 36, 37)));

        //when
        Output output = new ConsoleOutput();
        output.printPurchasedLotto(lottos);

        //then
        String result = captor.toString().trim();
        assertThat(result).contains("2개를 구매했습니다", "[1, 2, 3, 4, 5, 6]", "[32, 33, 34, 35, 36, 37]");
    }
}