package lotto;

import java.util.List;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoServiceImpl();
        List<List<Integer>> myLottoNumbers = lottoService.buyLotto();

    }
}
