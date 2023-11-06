package lotto.Controller;

import lotto.Factory.LottoContainer;
import lotto.IO.IO;
import lotto.Util.Validate;
import java.util.List;

public class Controller {
    private static LottoContainer lottoContainer;
    private int count;
    private int bonus;
    public Controller(LottoContainer lottoContainer) {
        this.lottoContainer = lottoContainer;
    }

    public void SettingLotto() { //사용자로부터 로또와 정답로또 입력받고 생성까지 끝내놓기
        String WinningLotto;
        List<Integer> WinningNum;

        purchaseLotto();
        lottoContainer.MakeContainer(count);
        WinningLotto = IO.InputWinningLotto();
        WinningNum = Validate.WinningLottoInput(WinningLotto);
        lottoContainer.MakeWinningLotto(WinningNum);
        settingBonus();
    }

    private void purchaseLotto() {
        String cash = IO.InputCash();
        Validate.CashIsInteger(cash);
        count = Integer.parseInt(cash) / 1000;
        IO.PrintCount(count);
    }

    private void settingBonus(){
        String bonusStr = IO.InputBonus();
        bonus = Integer.parseInt(bonusStr);
        Validate.isDuplicateBonus(lottoContainer, bonus);
    }

    public void RunLotto(){ //사용자의 로또와 정답로또 비교 후 rank 매기기

    }

    public void PrintResult(){ //매겨진 랭크 출력

    }
}
