package lotto;

import java.util.List;

public class LottoService {
    private final int LOTTO_PRICE = 1000;

    public LottoService() {
    }

    public void run() {
        User user = new User();
        user.buyLotto(LOTTO_PRICE);

        Computer computer = new Computer();

        Analyst analyst = new Analyst(user.lottos, computer.getSixLottoNumber(), computer.getBonusNumber());
        analyst.calculate();
        analyst.printLottoResult(user.getUserMoney());
    }
}
