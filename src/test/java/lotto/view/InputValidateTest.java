package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidateTest {
    InputValidate inputValidate;

    @BeforeEach
    void appconfig(){
        inputValidate = new InputValidate();
    }

    @Test
    void lottoCountValidate_숫자가_아닌_값_입력() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidate.lottoCountValidate("asdf")).isEqualTo(0);
        assertThat(outContent.toString()).isEqualTo("[ERROR] 로또 구매 금액 형식이 맞지 않습니다.\r\n");
    }

    @Test
    void lottoCountValidate_숫자가_1000단위가_아닌_값_입력() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidate.lottoCountValidate("1200")).isEqualTo(0);
        assertThat(outContent.toString()).isEqualTo("[ERROR] 로또 구매 금액 형식이 맞지 않습니다.\r\n");
    }
    @Test
    void lottoCountValidate_정상_값_입력() {
        assertThat(inputValidate.lottoCountValidate("2000")).isEqualTo(2000);
    }

    @Test
    void lottoAnswerValidate_정상_값_입력() {
        assertThat(inputValidate.lottoAnswerValidate("1,2,3,4,5,6").size()).isEqualTo(6);
        assertThat(inputValidate.lottoAnswerValidate("1,2,3,4,5,6").get(5)).isEqualTo(6);
    }

    @Test
    void lottoAnswerValidate_다른_값_입력(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidate.lottoAnswerValidate("asdfaf,werdfs,we").isEmpty()).isEqualTo(true);
        assertThat(outContent.toString()).isEqualTo("[ERROR] 로또 번호 형식이 맞지 않습니다.\r\n");
    }

    @Test
    void bonusNumValidate_정상적인_값_입력() {
        assertThat(inputValidate.bonusNumValidate("6")).isEqualTo(6);
    }
    @Test
    void bonusNumValidate_틀린_값_입력() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        assertThat(inputValidate.bonusNumValidate("asd")).isEqualTo(0);
        assertThat(outContent.toString()).isEqualTo("[ERROR] 로또 구매 금액 형식이 맞지 않습니다.\r\n");
    }
}