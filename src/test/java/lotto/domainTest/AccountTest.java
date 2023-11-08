package lotto.domainTest;

import lotto.contants.LottoEnum;
import lotto.domain.services.Account;
import lotto.util.Printer;
import lotto.controller.view.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @DisplayName("로또 추첨 결과와 구입금액으로 수익률을 정산")
    @Test
    void accountTest(){
        //Arrange
        Account account = new Account(new Output(new Printer()));
        Map<LottoEnum.grade, Integer> map = new HashMap<>();

        map.put(LottoEnum.grade.FIRST, 0);
        map.put(LottoEnum.grade.SECOND, 0);
        map.put(LottoEnum.grade.THIRD, 0);
        map.put(LottoEnum.grade.FOURTH, 2);
        map.put(LottoEnum.grade.FIFTH, 3);
        int amount = 200000;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Act
        account.profitAccount(map, amount);
        String expectedOutput = "57.5%";
        String output = outContent.toString().trim();

        //Assert
        assertThat(output).contains(expectedOutput);
    }
}
