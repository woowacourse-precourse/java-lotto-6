package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class LottoController {
    Money money;
    Lotto lotto;
    int bonus;
    int maxRound;
    LottoController(int pMoney){
        try {
            this.money = new Money(pMoney);
            setMaxRound();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] "+e.getMessage());
        }
    }

    private void setBonus(int bonus){
        this.bonus = bonus;
    }
    private void setMaxRound(){
        maxRound = this.money.getPMoney()/1000;
    }
    public int getMaxRound(){
        return maxRound;
    }
    public void setLotto(List<Integer> number, int bonus){
        this.lotto = new Lotto(number);
        setBonus(bonus);
    }
}
