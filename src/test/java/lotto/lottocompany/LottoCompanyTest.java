package lotto.lottocompany;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCompanyTest {
    
    @DisplayName("N개의 로또를 발행한다.")
    @Test
    void publishNLotto() {
        //given
        int publishCount = 5;
        LottoCompany lottoCompany = new LottoCompany();
    
        //when
        lottoCompany.publishNLotto(5);
    
        //then
        assertThat(lottoCompany.getLottoBundle().getBundle().size()).isEqualTo(publishCount);
    }

}
