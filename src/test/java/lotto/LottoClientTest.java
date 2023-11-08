package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.ProfitCalculator;
import lotto.io.ConsoleLottoOutput;
import lotto.io.LottoInput;
import lotto.service.PurchaseService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoClientTest {

    LottoClient lottoClient = new LottoClient(new PurchaseService(
            () -> Stream.of(1, 2, 3, 10, 11, 12).map(LottoBall::new).toList()
    ),
            new LottoInput() {

                @Override
                public int getMoneyAmount() {
                    return 3000;
                }

                @Override
                public Lotto getLotto() {
                    return new Lotto(Stream.of(1, 2, 3, 4, 5, 6).map(LottoBall::new).toList());
                }

                @Override
                public LottoBall getBall() {
                    return new LottoBall(7);
                }
            },
            new ConsoleLottoOutput(),
            new ProfitCalculator()
    );

    ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setupOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("로또 클라이언트가 정상적으로 동작한다.")
    public void lottoClientTest() {
        // given
        lottoClient.startLottery();
        // when
        List<String> output = Arrays.stream(outputStream.toString()
                .split("\n"))
                .map(String::trim)
                .toList();
        // then
        Assertions.assertThat(output).containsExactlyElementsOf(
                List.of(
                        "구입금액을 입력해 주세요.",
                        "3개를 구매했습니다.",
                        "[1, 2, 3, 10, 11, 12]",
                        "[1, 2, 3, 10, 11, 12]",
                        "[1, 2, 3, 10, 11, 12]",
                        "당첨 번호를 입력해 주세요.",
                        "보너스 번호를 입력해 주세요.",
                        "당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 3개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 0개",
                        "총 수익률은 500.0%입니다."
                )
        );
    }
}
