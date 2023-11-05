package lotto.controller;

import lotto.domain.Money;
import lotto.domain.WinningNum;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private WinningNum winningNum;
    private Money money;

    public LottoController(){
        inputMoney();
        inputWinningNum();
        System.out.println(winningNum.getWinningNum());
    }

    public Money inputMoney(){
        OutputView.inputBuyMessage();
        while(true){
            try{
                money = new Money(InputView.inputMoney());
                return money;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNum inputWinningNum(){
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
}
