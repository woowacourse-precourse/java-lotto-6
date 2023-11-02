package lotto.views;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    void 출력_테스트() {
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        List<Lotto> publish = lottoService.publish(5);
        outputView.lottoQuantityAndNumber(publish);
    }
}
