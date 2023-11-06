package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberAddController {

    private final LottoManager lottoManager = LottoManager.getInstance();
    private final IOManager ioManager = new IOManager();

    public void handle() {
        List<Lotto> lottoList = lottoManager.generateLottoList();;
        ioManager.printLottoList(lottoList);
    }
}
