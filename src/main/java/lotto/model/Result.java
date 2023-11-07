package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.util.LottoCheck;
import lotto.view.InputMessage;

public class Result {
    private Lotto winLotto;
    private int bonusNumber;
    private LottoCheck winLottoCheck;

    public void getWinLotto() {
        System.out.println("\n" + InputMessage.REQUEST_WIN_LOTTO.getMsg());
        String winLotto = Console.readLine();

        winLottoCheck = new LottoCheck();
       this.winLotto = new Lotto(winLottoCheck.winLottoErrorCheck(winLotto));
    }


    public void getBonusNumber() {
        System.out.println("\n" + InputMessage.REQUEST_BONUS_LOTTO.getMsg());
        String bonusLotto = Console.readLine();

        winLottoCheck = new LottoCheck();
        this.bonusNumber = winLottoCheck.bonusLottoErrorCheck(bonusLotto);
    }

    public void compareToLotto(Lotto lotto) {

    }
}
