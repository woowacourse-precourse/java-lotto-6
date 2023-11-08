package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;


class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void init() {
        inputView = InputView.getInstance();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", "a", "money"})
    @DisplayName("구매금액이 공백또는 문자가 입력된 경우")
    void 구매금액이_공백_또는_문자(String inputString) throws Exception {
        //given
        System.setIn(readUserInput(inputString));
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.readPurchaseAmount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000", "100000"})
    @DisplayName("구매금액이 정상적으로 입력된 경우")
    void 구매금액이_정상입력인_경우(String inputString) throws Exception {
        //given
        System.setIn(readUserInput(inputString));
        //when
        //then
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "\n",
            ",",
            "1",
            "1,2,3",
            "1,2,3,4,5.6",
            "a,b,c,d,e,f",
            "1,2,3,4,5,5",
            "1,2,3,4,5,67"
    })
    @DisplayName("당첨 번호를 비정상적으로 입력한 경우")
    void 당첨번호를_비정상적으로_입력한_경우(String winningNumber) throws Exception {
        //given
        System.setIn(readUserInput(winningNumber));
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.readWinningLotto());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6",
            "1,2,3,4,5,45"
    })
    @DisplayName("당첨 번호를 정상적으로 입력한 경우")
    void 당첨번호를_정상적으로_입력한_경우(String winningNumber) throws Exception {
        //given
        System.setIn(readUserInput(winningNumber));
        //when
        String winningLotto = inputView.readWinningLotto();
        //then
        assertThat(winningLotto).isEqualTo(winningNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "36", "25", "36", "45", "23"})
    @DisplayName("보너스번호 정상적으로 경우")
    void 보너스번호_정상적으로_입력한_경우(String bonusNumber) throws Exception {
        //given
        System.setIn(readUserInput(bonusNumber));
        //when
        String validBonusNumber = inputView.readBonusNumber();
        //then
        assertThat(validBonusNumber).isEqualTo(bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "\n",
            "a",
            "helloworld",
            ","
    })
    @DisplayName("보너스번호 비정상적으로 경우")
    void 보너스번호_비정상적으로_입력한_경우(String bonusNumber) throws Exception {
        //given
        System.setIn(readUserInput(bonusNumber));
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.readBonusNumber());
    }
    public InputStream readUserInput(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }

}