package lotto.view;

import lotto.domain.Lotto;
import lotto.controller.inputvalidate.InputValidateAnswer;
import lotto.controller.inputvalidate.InputValidateBonus;
import lotto.controller.inputvalidate.InputValidateMoney;
import lotto.repository.LottoRepository;
import lotto.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidateTest {
    InputValidateMoney inputValidateMoney;
    InputValidateAnswer inputValidateAnswer;
    InputValidateBonus inputValidateBonus;

    Repository repository = new LottoRepository();

    @BeforeEach
    void appconfig(){
        inputValidateMoney = new InputValidateMoney();
        inputValidateAnswer = new InputValidateAnswer();
        inputValidateBonus = new InputValidateBonus(repository);
        repository.setAnswerLotto(new Lotto(List.of(1,2,3,4,5,7)));
        repository.setBonusNumber(6);
    }

    @Test
    void lottoCountValidate_숫자가_아닌_값_입력() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidateMoney.lottoCountValidate("asdf")).isEqualTo(0);
        assertThat(outContent.toString()).contains("[ERROR]");
    }

    @Test
    void lottoCountValidate_숫자가_1000단위가_아닌_값_입력() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidateMoney.lottoCountValidate("1200")).isEqualTo(0);
        assertThat(outContent.toString()).contains("[ERROR]");
    }
    @Test
    void lottoCountValidate_정상_값_입력() {
        assertThat(inputValidateMoney.lottoCountValidate("2000")).isEqualTo(2);
    }

    @Test
    void lottoAnswerValidate_정상_값_입력() {
        assertThat(inputValidateAnswer.lottoAnswerValidate("1,2,3,4,5,6").size()).isEqualTo(6);
        assertThat(inputValidateAnswer.lottoAnswerValidate("1,2,3,4,5,6").get(5)).isEqualTo(6);
    }
    @Test
    void lottoAnswerValidate_범위틀린_값_입력() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidateAnswer.lottoAnswerValidate("1,2,3,4,5,60").isEmpty()).isEqualTo(true);
        assertThat(outContent.toString()).contains("[ERROR]");
    }
    @Test
    void lottoAnswerValidate_다른_값_입력(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidateAnswer.lottoAnswerValidate("asdfaf,werdfs,we").isEmpty()).isEqualTo(true);
        assertThat(outContent.toString()).contains("[ERROR]");
    }

    @Test
    void bonusNumValidate_정상적인_값_입력() {
        assertThat(inputValidateBonus.bonusNumValidate("6")).isEqualTo(6);
    }
    @Test
    void bonusNumValidate_틀린_값_입력() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidateBonus.bonusNumValidate("asd")).isEqualTo(0);
        assertThat(outContent.toString()).contains("[ERROR]");
    }
    @Test
    void bonusNumValidate_범위틀린_값_입력() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidateBonus.bonusNumValidate("65")).isEqualTo(0);
        assertThat(outContent.toString()).contains("[ERROR]");
    }
}