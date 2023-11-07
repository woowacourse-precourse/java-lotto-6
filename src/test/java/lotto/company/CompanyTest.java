package lotto.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompanyTest {

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

}