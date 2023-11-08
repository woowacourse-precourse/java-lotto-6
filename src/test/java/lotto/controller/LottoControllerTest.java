package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {
    @DisplayName("금액에 대한 모든 예외를 발생시키고, 입력을 반복하여 받는지 확인")
    @Test
    void play_WithInvalidPurchaseAmount() {
        assertSimpleTest(() -> {
            runException("", "abc", "900", "8532");
            assertThat(output()).contains(
                    "입력이 존재하지 않습니다.",
                    "숫자 이외의 문자는 포함될 수 없습니다.",
                    "최소 1000원의 금액을 입력해야 합니다.",
                    "금액은 1000원 단위로 입력해야 합니다."
            );
        });
    }

    @DisplayName("당첨 번호에 대한 모든 예외를 발생시키고, 입력을 반복하여 받는지 확인")
    @Test
    void play_WithInvalidWinningNumber() {
        assertSimpleTest(() -> {
            runException("5000", "", "1:2:3:4:5:6", "1,2,3,4,5,6,7", "1,2,3,4,5,46", "1,2,3,3,4,5");
            assertThat(output()).contains(
                    "입력이 존재하지 않습니다.",
                    "입력 형식이 올바르지 않습니다.",
                    "당첨 번호는 6개의 숫자로 이루어져야 합니다.",
                    "숫자 범위는 1부터 45까지 가능합니다.",
                    "6개의 번호는 중복될 수 없습니다."
            );
        });
    }

    @DisplayName("보너스 번호에 대한 모든 예외를 발생시키고, 입력을 반복하여 받는지 확인")
    @Test
    void play_WithInvalidBonusNumber() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "6", "", "a", "-1", "47");
            assertThat(output()).contains(
                    "당첨 번호와 보너스 번호는 중복될 수 없습니다.",
                    "입력이 존재하지 않습니다.",
                    "값은 숫자만 가능합니다.",
                    "숫자 범위는 1부터 45까지 가능합니다.",
                    "숫자 범위는 1부터 45까지 가능합니다."
            );
        });
    }

    @DisplayName("게임을 정상적으로 진행시키고, 정확한 결과를 출력하는지 확인")
    @Test
    void play_WithValidInput() {
        // InputStream 설정
        // 유저는 5개의 로또를 구매하며, 당첨 번호는 1,2,3,4,5,6,7
        command("5000", "1,2,3,4,5,6", "7");

        // OutStream 설정
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // 유저의 로또 번호 임의 설정
        LottoGenerator lottoGenerator = spy(new LottoGenerator());
        when(lottoGenerator.createLottoByPrice(new Money(5000L)))
                .thenReturn(List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 3, 4, 5, 6, 7)),
                                new Lotto(List.of(1, 3, 4, 5, 6, 8)),
                                new Lotto(List.of(1, 4, 5, 6, 8, 9)),
                                new Lotto(List.of(1, 3, 4, 10, 11, 12))
                        )
                );

        LottoController lottoController = new LottoController(new LottoViewController(), lottoGenerator);
        lottoController.play();

        assertThat(out.toString()).contains(
                "5개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[1, 3, 4, 5, 6, 7]",
                "[1, 3, 4, 5, 6, 8]",
                "[1, 4, 5, 6, 8, 9]",
                "[1, 3, 4, 10, 11, 12]",
                "당첨 통계",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 40631100.0%입니다."
        );
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {
        LottoController lottoController = new LottoController();
        lottoController.play();
    }
}