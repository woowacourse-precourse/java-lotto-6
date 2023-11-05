package lotto.controller;

import lotto.domain.BonusNum;
import lotto.domain.Money;
import lotto.domain.WinningNum;
import lotto.util.MakeLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private Money money;
    private WinningNum winningNum;
    private BonusNum bonusNum;

    public LottoController(){
        inputMoney();
        MakeLotto makeLotto = new MakeLotto(money.getLottoTickets());
        inputWinningNum();
        inputBonusNum();
    }

    public Money inputMoney(){
        OutputView.inputBuyMessage();
        while(true){
            try{
                money = new Money(InputView.inputMoney());
                OutputView.printBlank();
                return money;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNum inputWinningNum(){
        OutputView.printBlank();
        OutputView.inputWinningNumMessage();
        while(true){
            try{
                winningNum = new WinningNum(InputView.inputWinningNum());
                return winningNum;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNum inputBonusNum(){
        OutputView.printBlank();
        OutputView.inputBonusNumMessage();
        while(true){
            try {
                bonusNum = new BonusNum(InputView.inputBonusNum(), winningNum.getWinningNum());
                return bonusNum;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
