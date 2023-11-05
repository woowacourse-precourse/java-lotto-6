package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputViewTest {
    private final LottoInputView lottoInputView = new LottoInputView();

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @DisplayName("로또 번호 입력에 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void getWinningNumbersIncludeCharacter() {
        String userInput = "1,2,3,4,5,6A";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(lottoInputView::getWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 정상 테스트.")
    @Test
    void getProperWinningNumbers() {
        String userInput = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        lottoInputView.getWinningNumbers();
    }

    @DisplayName("보너스 번호 입력에 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void getBonusNumberIncludeCharacter() {
        String userInput = "33A";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(lottoInputView::getBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 45를 초과하면 예외가 발생한다.")
    @Test
    void getBonusNumberOutOfLottoUpperBound() {
        String userInput = "46";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(lottoInputView::getBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 1미만이면 예외가 발생한다.")
    @Test
    void getBonusNumberOutOfLottoLowerBound() {
        String userInput = "0";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(lottoInputView::getBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
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