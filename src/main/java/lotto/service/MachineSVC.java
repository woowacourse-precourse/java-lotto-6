package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;

import java.util.List;

public class MachineSVC {

    public LottoMachine SettingLotto(){
        InputView.insertMoney();
        Vendor vendor = new Vendor();
        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.setNumOfLotto(vendor.setMoney());
        lottoMachine.setLottos();

        return lottoMachine;
    }

    public static List<LottoValue> judgeWinningLotto(Client client, LottoMachine lottoMachine) {
        return lottoMachine.judgeWinningLotto(client);
    }


}
