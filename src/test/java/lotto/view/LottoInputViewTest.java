package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputViewTest {
    private final LottoInputView lottoInputView = new LottoInputView();

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUp() {
        Console.close();
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("로또 번호 입력에 문자가 포함되어 있으면 에러메세지가 출력된다.")
    @Test
    void getWinningNumbersIncludeCharacter() {
        String userInput = "1,2,3,4,5,6A";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        lottoInputView.getWinningNumbers();

        assertThat(outputMessage.toString()).hasToString("당첨 번호를 입력해 주세요.\n[ERROR] 문자는 입력할 수 없습니다.\n");
    }

    @DisplayName("로또 번호 입력 정상 테스트.")
    @Test
    void getProperWinningNumbers() {
        String userInput = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        lottoInputView.getWinningNumbers();
    }

    @DisplayName("보너스 번호 입력에 문자가 포함되어 있으면 에러메세지가 출력된다.")
    @Test
    void getBonusNumberIncludeCharacter() {
        String userInput = "33A";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        lottoInputView.getBonusNumber();

        assertThat(outputMessage.toString()).hasToString("보너스 번호를 입력해 주세요.\n[ERROR] 문자는 입력할 수 없습니다.\n");
    }

    @DisplayName("보너스 번호 입력이 45를 초과하면 예외가 발생한다.")
    @Test
    void getBonusNumberOutOfLottoUpperBound() {
        String userInput = "46";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        lottoInputView.getBonusNumber();

        assertThat(outputMessage.toString()).hasToString("보너스 번호를 입력해 주세요.\n[ERROR] 로또번호는 1에서 45 사이여야 합니다.\n");
    }

    @DisplayName("보너스 번호 입력이 1미만이면 예외가 발생한다.")
    @Test
    void getBonusNumberOutOfLottoLowerBound() {
        String userInput = "0";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        lottoInputView.getBonusNumber();

        assertThat(outputMessage.toString()).hasToString("보너스 번호를 입력해 주세요.\n[ERROR] 로또번호는 1에서 45 사이여야 합니다.\n");
    }

    @DisplayName("보너스 번호 입력 정상 테스트.")
    @Test
    void getProperBonusNumber() {
        String userInput = "5";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        lottoInputView.getBonusNumber();
    }

}