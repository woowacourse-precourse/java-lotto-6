package lotto.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompanyTest {

    private static ByteArrayOutputStream outputMessage;

    String getOutput() {
        return outputMessage.toString();
    }

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("구입 금액에 해당하는 만큼 로또 발행")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 8000, 10000})
    void 구입_금액에_해당하는_만큼_로또_발행(int buyAmount) throws Exception {
        //given
        Company company = new LottoCompany();

        //when
        List<Lotto> lottoList = company.generateLottoList(buyAmount);

        //then
        assertThat(lottoList.size()).isEqualTo(buyAmount / 1000);
    }

    @DisplayName("발행한 로또 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.")
    @Test
    void 발행한_로또_번호_출력() throws Exception {
        //given
        Company company = new LottoCompany();
        int buyAmount = 8000;

        //when
        List<Lotto> lottoList = company.generateLottoList(buyAmount);
        company.printLottoList(lottoList);

        //then
        assertThat(getOutput()).contains("8개를 구매했습니다.");
    }
}