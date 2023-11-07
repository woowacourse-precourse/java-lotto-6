package service;

import model.Lottos;
import model.ResultLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {
    @Test
    void 당첨번호_결과_테스트(){
        Integer count = 8;
        Lottos lottos = new Lottos(count);

        LottoService service = new LottoService(count);
        List<ResultLotto> resultLottos = service.findResults(List.of(1,2,3,4,5,6),8);

        assertThat(resultLottos.size()).isEqualTo(count);
    }
}