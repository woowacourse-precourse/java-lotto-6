package lotto.lottoTest;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static lotto.service.LottoService.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    public Lotto makeLotto(String input) {
        String[] numbers = input.split(",");
        List<Integer> inputNumbers = new ArrayList<>();
        for (String number : numbers) {
            inputNumbers.add(Integer.parseInt(number));
        }
        return new Lotto(inputNumbers);
    }

    public void init(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("당첨_번호를_입력받는_테스트")
    public void lottoWinningNumberTest(){
        //given
        String winningNumbers = "1,2,3,4,5,6";
        init(winningNumbers);

        //when
        Lotto userLotto = makeLotto(winningNumbers);

        Lotto lotto = enterWinningNumbers();

        //then
        for(int number : userLotto.getLotto()){
            assertThat(lotto.getLotto()).contains(number);
        }
    }
}
