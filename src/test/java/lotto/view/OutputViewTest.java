package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    List<Lotto> lottos;
    OutputView outputView = new OutputView();

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(byteArrayOutputStream));
        lottos = List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(7,8,9,10,11,12)));
    }

    @AfterEach
    void afterInit() {
        Console.close();
        System.setOut(System.out);
        byteArrayOutputStream.reset();
    }

    @Test
    @DisplayName("구매로또 출력 확인")
    void 구매로또_출력_확인() {
        outputView.showPurchasedLottos(lottos);
        String expectedOutput = "2개를 구매했습니다.\n" + "[1, 2, 3, 4, 5, 6]\n" + "[7, 8, 9, 10, 11, 12]\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("당첨내역 출력 확인 - 5000원")
    void 당첨내역_3개_일치_출력_확인() {
        Lotto winningNumbers = new Lotto(List.of(2, 4, 6, 8, 10, 12));
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int purchaseAmount = 1000;
        outputView.showPrizeResult(lottos, winningLotto, purchaseAmount);
        String expectedOutput = "\n당첨 통계\n" + "---\n" + "3개 일치 (5,000원) - 1개\n" + "4개 일치 (50,000원) - 0개\n" + "5개 일치 (1,500,000원) - 0개\n" + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" + "6개 일치 (2,000,000,000원) - 0개\n" + "총 수익률은 500.0%입니다.\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("당첨내역 출력 확인 - 50,000원")
    void 당첨내역_4개_일치_출력_확인() {
        Lotto winningNumbers = new Lotto(List.of(2, 4, 6, 8, 10, 1));
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int purchaseAmount = 1000;
        outputView.showPrizeResult(lottos, winningLotto, purchaseAmount);
        String expectedOutput = "\n당첨 통계\n" + "---\n" + "3개 일치 (5,000원) - 0개\n" + "4개 일치 (50,000원) - 1개\n" + "5개 일치 (1,500,000원) - 0개\n" + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" + "6개 일치 (2,000,000,000원) - 0개\n" + "총 수익률은 5000.0%입니다.\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("당첨내역 출력 확인 - 1,500,000원")
    void 당첨내역_5개_일치_출력_확인() {
        Lotto winningNumbers = new Lotto(List.of(2, 4, 6, 8, 3, 1));
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int purchaseAmount = 1000;
        outputView.showPrizeResult(lottos, winningLotto, purchaseAmount);
        String expectedOutput = "\n당첨 통계\n" + "---\n" + "3개 일치 (5,000원) - 0개\n" + "4개 일치 (50,000원) - 0개\n" + "5개 일치 (1,500,000원) - 1개\n" + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" + "6개 일치 (2,000,000,000원) - 0개\n" + "총 수익률은 150000.0%입니다.\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("당첨내역 출력 확인 - 30,000,000원")
    void 당첨내역_5개_보너스_일치_출력_확인() {
        Lotto winningNumbers = new Lotto(List.of(2, 4, 6, 8, 3, 1));
        int bonusNumber = 1;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int purchaseAmount = 1000;
        outputView.showPrizeResult(lottos, winningLotto, purchaseAmount);
        String expectedOutput = "\n당첨 통계\n" + "---\n" + "3개 일치 (5,000원) - 0개\n" + "4개 일치 (50,000원) - 0개\n" + "5개 일치 (1,500,000원) - 0개\n" + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" + "6개 일치 (2,000,000,000원) - 0개\n" + "총 수익률은 3000000.0%입니다.\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("당첨내역 출력 확인 - 2,000,000,000원")
    void 당첨내역_6개_일치_출력_확인() {
        Lotto winningNumbers = new Lotto(List.of(2, 4, 6, 5, 3, 1));
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int purchaseAmount = 1000;
        outputView.showPrizeResult(lottos, winningLotto, purchaseAmount);
        String expectedOutput = "\n당첨 통계\n" + "---\n" + "3개 일치 (5,000원) - 0개\n" + "4개 일치 (50,000원) - 0개\n" + "5개 일치 (1,500,000원) - 0개\n" + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" + "6개 일치 (2,000,000,000원) - 1개\n" + "총 수익률은 200000000.0%입니다.\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }
}