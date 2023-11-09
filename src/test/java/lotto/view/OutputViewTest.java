package lotto.view;

import static lotto.utils.StringUtils.countOccurrences;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("기능20 테스트 : 로또 0개를 구해 했을 때 그 결과를 잘 출력한다.")
    void printPurchaseResultCorrectlyWhenPurchaseZeroLotto() {
        // given
        int totalPurchaseCount = 0;
        List<Lotto> lottoList = new ArrayList<>();

        // when
        OutputView.printPurchaseResult(lottoList);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).contains("0개를 구매했습니다.");
        assertThat(count).isEqualTo(0);
    }


    @Test
    @DisplayName("기능20 테스트 : 로또 1개를 구해 했을 때 그 결과를 잘 출력한다.")
    void printPurchaseResultCorrectlyWhenPurchaseOneLotto() {
        // given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        // when
        OutputView.printPurchaseResult(lottoList);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).contains("1개를 구매했습니다.");
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("기능20 테스트 : 로또 5개를 구해 했을 때 그 결과를 잘 출력한다.")
    void printPurchaseResultCorrectlyWhenPurchaseFiveLotto() {
        // given
        int purChaseCount = 5;
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < purChaseCount; i++) {
            lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }

        // when
        OutputView.printPurchaseResult(lottoList);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).contains("5개를 구매했습니다.");
        assertThat(count).isEqualTo(5);
    }

}