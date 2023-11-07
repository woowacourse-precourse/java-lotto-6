package lotto.controller;

import lotto.domain.Client;
import lotto.domain.LottoMachine;
import lotto.domain.LottoValue;
import lotto.service.ClientSVC;
import lotto.service.MachineSVC;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final MachineSVC machineSVC;
    private final ClientSVC clientSVC;

    public LottoController() {
        this.machineSVC = new MachineSVC();
        this.clientSVC = new ClientSVC();
    }

    public void run() {
        LottoMachine lottoMachine = machineSVC.SettingLotto();

        OutputView.printLotto(lottoMachine);

        Client client = new Client();
        clientSVC.insertLottoNumber(client);
        clientSVC.insertBonusNumber(client);

        List<LottoValue> matchedLottos = MachineSVC.judgeWinningLotto(client, lottoMachine);

        OutputView.printResult(matchedLottos);
        OutputView.showProfit(matchedLottos, lottoMachine.getNumOfLotto());




    }

}
