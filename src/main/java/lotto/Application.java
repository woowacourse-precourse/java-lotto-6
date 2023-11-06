package lotto;

import lotto.domain.RandomNumberGenerator;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoServiceImpl(new RandomNumberGenerator());
        View view = new View();
    }
}
