package lotto.domain.controller;

import lotto.domain.AllOfRandomLottoList;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.service.ClientService;
import lotto.domain.service.LottoService;
import lotto.global.utils.console.ConsoleUtil;
import lotto.global.utils.constant.OutputType;


public class LottoController {
    private final ClientService clientService;
    private final LottoService lottoService;

    public LottoController(ClientService clientService, LottoService lottoService) {
        this.clientService = clientService;
        this.lottoService = lottoService;
    }

    public void run() {
        AllOfRandomLottoList allOfRandomLottoList = getLottoList();
        Lotto inputLotto = clientService.getLottoNumbers();
        BonusNumber bonusNumber = clientService.getBonusNumber(inputLotto);
        lottoService.outputCorrectLottoList(allOfRandomLottoList, inputLotto, bonusNumber);
    }

    private AllOfRandomLottoList getLottoList() {
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_PURCHASE_PRICE.getComment());
        int lottoCount = clientService.getLottoCount();
        return lottoService.getLottoList(lottoCount);
    }
}
