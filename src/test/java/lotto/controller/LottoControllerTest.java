package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.generator.FixedLottosGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);
        FixedLottosGenerator fixedLottosGenerator = new FixedLottosGenerator(lottos);
        lottoController = new LottoController(fixedLottosGenerator);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        Console.close();
    }

    @DisplayName("기능테스트를한다.")
    @Test
    void testRun() {
        String input = "30000\n" +
                "1,2,3,4,5,6\n" +
                "7\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        String expectedOutput = "구입금액을 입력해 주세요.\n\n" +
                "3개를 구매했습니다.\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[1, 2, 3, 4, 5, 7]\n" +
                "[1, 2, 3, 8, 9, 10]\n" +
                "\n당첨 번호를 입력해 주세요.\n" +
                "\n보너스 번호를 입력해 주세요.\n" +
                "\n당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n" +
                "총 수익률은 6,766,683.3%입니다.\n";
        lottoController.run();
        assertThat(expectedOutput).isEqualTo(outputStream.toString());
    }
}
