package lotto;

import lotto.controller.InputManager;
import lotto.controller.MessageManager;
import lotto.controller.NumberManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private int money;
    private int count;
    private List<Lotto> lottos;
    private Lotto winningNumber;

    private InputManager inputManager;
    private NumberManager numberManager;

    public User() {
        this.money = -1;
        this.inputManager = new InputManager();
        this.numberManager = new NumberManager();

        this.lottos = new ArrayList<>();
    }
    public void payMoney(){
        while (money == -1){
            money = inputManager.inputMoney();
        }

        setCount();
    }
    public void buyLottos(){
        for(int i = 0; i<count; i++){
            lottos.add(numberManager.createLotto());
        }
    }

    public void predictWinningNumber(){
        do {
            winningNumber = inputManager.inputWinningNumber();
        }while(winningNumber == null || !winningNumber.validate());
    }

    public void showMyLottos(){
        System.out.println(count + MessageManager.BUY_LOTTOS);
        for(int i =0 ;i<count; i++){
            lottos.get(i).showNumbers();
        }
    }

    private void setCount(){
        count = money / 1000;
    }
}
