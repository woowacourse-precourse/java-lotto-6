package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalLottoControllerTest {
    private TotalLottoController controller;
    private PrintStream out = System.out;
    private OutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void eachTestCase() {
        controller = new TotalLottoController();
        Console.close();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("1,000원 단위로 입력받으면 정상적으로 1,000원에 한개의 로또가 발급된다.")
    @Test
    void issueLottosByValidMoney() {
        String moneyAmount = "3000";
        provideInput(moneyAmount);
        Lottos lottos = controller.issueLottos();
        assertThat(lottos.issuedSize())
                .isEqualTo(3);
    }

    @DisplayName("1,000원 단위로 입력하지 않으면, 예외가 처리된 후 다시 입력을 받는다.")
    @Test
    void issueLottosByInvalidMoney() {
        String moneyAmount = "3100";
        provideInput(moneyAmount);
        assertThatThrownBy(() -> controller.issueLottos())
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("당첨 로또를 입력받을 때, 유효한 숫자를 입력했을 경우 정상 발급")
    @Test
    void issueLottoResultByValidNumbers() {
        String number = "1,2,3,4,5,6";
        String bonusNumber = "7";
        provideInput(number, bonusNumber);
        LottoResult lottoResult = controller.issueLottoResult();
        assertThat(lottoResult.getBonusNumber())
                .isEqualTo(7);
    }

    @DisplayName("당첨 로또를 입력받을 때 보너스 번호가 중복된다면, 예외가 발생한다.")
    @Test
    void issueLottoResultByDuplicateBonusNumber() {
        String number = "1,2,3,4,5,6";
        String bonusNumber = "6";
        provideInput(number, bonusNumber);
        assertThatThrownBy(() -> controller.issueLottoResult())
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("당첨 로또를 입력받을 때 번호가 중복된다면, 예외가 발생한다.")
    @Test
    void issueLottoResultByDuplicateNumber() {
        String number = "1,2,3,4,6,6";
        String bonusNumber = "7";
        provideInput(number, bonusNumber);
        assertThatThrownBy(() -> controller.issueLottoResult())
                .isInstanceOf(NoSuchElementException.class);
    }

    void provideInput(String ...str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : str) {
            stringBuilder.append(s)
                    .append("\n");
        }
        ByteArrayInputStream testIn = new ByteArrayInputStream(stringBuilder.toString().getBytes());
        System.setIn(testIn);
    }
}