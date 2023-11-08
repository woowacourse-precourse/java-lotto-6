package lotto.Controller;

import lotto.IO.IO;
import lotto.LottoFactory.LottoContainer;
import lotto.Validate;

import java.util.List;
import java.util.NoSuchElementException;

public class SettingLotto implements Setting{
    private static LottoContainer lottoContainer;
    private int count;
    private int bonus;

    public SettingLotto(LottoConfiguration lottoConfig) {
        this.lottoContainer = lottoConfig.getLottoContainer();
    }

    @Override
    public void SettingLotto() {
        String WinningLotto;
        List<Integer> WinningNum;

        purchaseLotto();
        lottoContainer.MakeContainer(count);
        IO.PrintBuyLotto(lottoContainer);

        WinningLotto = IO.InputWinningLotto();
        WinningNum = Validate.WinningLottoInput(WinningLotto);
        lottoContainer.MakeWinningLotto(WinningNum);

        settingBonus();
    }

    private void purchaseLotto() {
        try{
            String cash = IO.InputCash();
            Validate.CashForm(cash);
            count = Integer.parseInt(cash) / 1000;
            IO.PrintCount(count);

        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void settingBonus(){
        String bonusStr = IO.InputBonus();
        bonus = Integer.parseInt(bonusStr);
        Validate.isDuplicateBonus(lottoContainer, bonus);
    }

    @Override
    public int returnCount() {
        return count;
    }

    @Override
    public int returnBonus() {
        return bonus;
    }
}

