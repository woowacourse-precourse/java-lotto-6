package lotto.LottoController;

import lotto.Lotto;
import lotto.LottoView.LottoView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoView view;
    private final InputCheck inpubCheck;

    public LottoController(){
        this.view = new LottoView();
        this.inpubCheck = new InputCheck(view);
    }

    public void run(){
        int purchaseAmount = inpubCheck.inputAmount();
        Lotto winNumbers = inpubCheck.inputNumbers();
        int bonusNumber = inpubCheck.inputBonus(winNumbers);
    }


}