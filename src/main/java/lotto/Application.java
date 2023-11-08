package lotto;

import lotto.controllers.DongHangLottery;
import lotto.controllers.LottoNumberChecker;
import lotto.controllers.LottoStoreManager;
import lotto.views.LottoView;

import static lotto.views.MessageManager.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoStoreManager();
    }
}