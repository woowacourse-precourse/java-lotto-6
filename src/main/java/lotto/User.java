package lotto;

import lotto.controller.InputManager;
import lotto.controller.MessageManager;
import lotto.controller.NumberManager;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class User {
    private int money;
    private int count;
    private List<Lotto> lottos;
    private Lotto winningNumber;
    private int bonusNumber;
    private EnumMap<Winner, Integer> winnersResult = new EnumMap<>(Winner.class);
    private int winnerMoney = 0;

    private InputManager inputManager;
    private NumberManager numberManager;
    private MessageManager messageManager;

    public User() {
        this.money = -1;
        this.inputManager = new InputManager();
        this.numberManager = new NumberManager();
        this.messageManager = new MessageManager();

        this.lottos = new ArrayList<>();

        Winner[] winners = Winner.values();
        for(Winner winner: winners){
            winnersResult.put(winner, 0);
        }
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

    public void predictBonusNumber(){
        bonusNumber = inputManager.inputBonusNumber(winningNumber);
    }

    public void showMyLottos(){
        System.out.println(count + MessageManager.BUY_LOTTOS);
        for(int i =0 ;i<count; i++){
            lottos.get(i).showNumbers();
        }
    }

    public void setWinningResult(int number){
        if (number >=3 && number <=6){
            winnersResult.put(Winner.getByMatch(number), winnersResult.get(Winner.getByMatch(number))+1);
        }
        if (number == -5){
            winnersResult.put(Winner.getByMatch(number), winnersResult.get(Winner.getByMatch(number))+1);
        }
    }

    public void compareLotto(){
        for(int i = 0; i < count; i++){
            setWinningResult(lottos.get(i).compareNumber(winningNumber, bonusNumber));
        }

        messageManager.showResult(winnersResult);
    }

    public void calculateMoney(){
        for(Winner winner: Winner.values()){
            winnerMoney += winner.getPrize() * winnersResult.get(winner);
        }
        messageManager.showRateMoney(winnerMoney / money * 100);
    }

    private void setCount(){
        count = money / 1000;
    }
}
