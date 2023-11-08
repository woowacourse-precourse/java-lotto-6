package lotto;

import lotto.service.LottoService;

public class Application {
    public static LottoService service = new LottoService();

    public static void main(String[] args) {
        service.calLottoCount();
        service.setCorrect();
        service.runCheckUserLottos();
        service.calReturnRate();
    }
}
