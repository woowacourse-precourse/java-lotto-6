package lotto.domain;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    @DisplayName("구입 금액을 잘못 입력하면 오류 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1100", "100", "3500", "12001", "50", "abcd", "12cd", " ", "9900", "0"})
    void validateInputMoney(String input) throws Exception {
        LottoMachine lottoMachine = new LottoMachine();

        Assertions.assertThatThrownBy(() ->
                lottoMachine.issuanceLotto(input))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("구입 금액에 따른 로또 생성 갯수")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "3000,3", "5000,5"})
    void createLottoNumber(String input, int output) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        LottoMachine lottoMachine = new LottoMachine();

        int createdNum = lottoMachine.issuanceLotto(input).size();

        Assertions.assertThat(createdNum).isEqualTo(Integer.valueOf(output));


    }

}