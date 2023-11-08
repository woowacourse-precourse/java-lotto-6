package lotto.controller;

import lotto.domain.*;
import lotto.util.Validation;
import lotto.view.UserView;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    private LottoWallet lottoWallet;
    private LottoMachine lottoMachine;
    private final LottoManager lottoManager;

    public LottoController() {
        this.lottoManager = LottoManager.getInstance();
        this.lottoMachine = new LottoMachine();
    }


}
