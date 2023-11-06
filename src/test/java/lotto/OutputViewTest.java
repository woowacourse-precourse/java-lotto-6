package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class OutputViewTest {


    ByteArrayOutputStream captureOutputValues() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        return outputStream;
    }


    @DisplayName("로또 구매 금액 요청 메세지 정상 작동 확인 테스트")
    @Test
    void printRequestBuyAmount_Different_ExceptionThrow() {
        ByteArrayOutputStream output = captureOutputValues();
        OutputView.printRequestBuyAmount();
        assertThat(output.toString()).isEqualTo("구입금액을 입력해 주세요.\n");
    }

    @DisplayName("로또 구매 갯수 메세지 정상 작동 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void printBuyCount_Different_ExceptionThrow(int buyAmount) {
        ByteArrayOutputStream output = captureOutputValues();
        OutputView.printBuyCount(buyAmount);
        assertThat(output.toString()).isEqualTo("\n" + buyAmount/1000 + "개를 구매했습니다.\n");
    }


    @DisplayName("생성된 로또 순차 출력 테스트")
    @Test
    void printCreatedLottos_EqualMessage_Success() {
        ByteArrayOutputStream output = captureOutputValues();
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lottos lottos = new Lottos(lottoList);
        OutputView.printCreatedLottos(lottos);
        assertThat(output.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n");
    }

    @DisplayName("당첨 번호 입력 요청 출력 테스트")
    @Test
    void printRequestWinningNumber_EqualMessage_Success() {
        ByteArrayOutputStream output = captureOutputValues();
        OutputView.printRequestWinningNumber();
        assertThat(output.toString()).isEqualTo("\n당첨 번호를 입력해 주세요.\n");
    }


    @DisplayName("보너스 번호 입력 요청 출력 테스트")
    @Test
    void printRequestBonusNumber_EqualMessage_Success() {
        ByteArrayOutputStream output = captureOutputValues();
        OutputView.printRequestBonusNumber();
        assertThat(output.toString()).isEqualTo("\n보너스 번호를 입력해 주세요.\n");
    }

    @DisplayName("당첨 결과 출력 테스트")
    @Test
    void printWinningResult_EqaulMessage_Success() {
        ByteArrayOutputStream output = captureOutputValues();
        int[] result = {0, 1, 2, 3, 4, 5};
        OutputView.printWinningResult(result);
        assertThat(output.toString()).isEqualTo("3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 2개\n"
                + "5개 일치 (1,500,000원) - 3개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 4개\n"
                + "6개 일치 (2,000,000,000원) - 5개\n");
    }


    @DisplayName("수익률 출력 테스트")
    @Test
    void printProfitRate_EqualMessage_Success() {
        ByteArrayOutputStream output = captureOutputValues();
        Game game = new Game();
        float buyAmount = 8000;
        int[] result = new int[]{0, 1, 0, 0, 0, 0};

        float profitRate = game.calculateProfitRate(8000, result);

        OutputView.printProfitRate(profitRate);
        assertThat(output.toString()).isEqualTo("총 수익률은 62.5%입니다.");
    }


}
