package lotto.controller;

import lotto.manager.IOManager;
import lotto.Lotto;
import lotto.manager.LottoManager;

import java.util.List;

public class LottoNumberAddController {

    private final LottoManager lottoManager = LottoManager.getInstance();
    private final IOManager ioManager = new IOManager();

    public void handle() {
        List<Lotto> lottoList = lottoManager.generateLottoList();
        ioManager.printLottoList(lottoList);
    }
}
