package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @DisplayName("주어진 수량만큼 로또를 생성한다.")
    @Test
    void getLottos(){
        //given
        LottoService lottoService = new LottoServiceImpl();
        int quantity = 3;

        //when
        List<List<Integer>> lottos = lottoService.getLottos(quantity);

        //then
        assertThat(lottos).isNotNull().hasSize(quantity);
    }
}