package lotto.Controller;

import lotto.LottoFactory.*;
import lotto.IO.IO;
import lotto.Util.RateCalculator;
import lotto.Util.Validate;
import java.util.List;
import java.util.NoSuchElementException;

public class Controller {
    private static LottoContainer lottoContainer;
    private static LottoController lottoController;
    private int count;
    private int bonus;
    public Controller(LottoContainer lottoContainer, LottoController lottoController) {
        this.lottoContainer = lottoContainer;
        this.lottoController = lottoController;
    }

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

    public void RunLotto() {
        for (Lotto lotto : lottoContainer.getLottoContainer()) {
            Boolean isBonusDuplicate = lotto.getNumbers().contains(bonus);
            lottoController.CheckDuplicateNum(lottoContainer, lotto, isBonusDuplicate);
        }
        int AllPrize = lottoController.returnAllPrize();
        int cash = count*1000;
        double rate = RateCalculator.returnRate(AllPrize,cash);
        PrintResult(rate);
    }

    public void PrintResult(double rate){
        IO.printRanking(LottoRank.values());
        IO.printRate(rate);
    }

}
