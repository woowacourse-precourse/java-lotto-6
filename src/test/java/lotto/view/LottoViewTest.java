package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoShop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    @DisplayName("Lotto 출력 포맷 테스트")
    public void printLottoTest(){
        //given
        List checkNumber = List.of(1,2,3,4,5,6);
        String printResult = "[1, 2, 3, 4, 5, 6]\n";
        //when
        Lotto lotto = new Lotto(checkNumber);
        LottoView lottoView = new LottoView();
        //then
        lottoView.printLottoNumber(lotto.getNumbers());
        assertThat(printResult).isEqualTo(outContent.toString());
    }
}
