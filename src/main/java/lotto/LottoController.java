package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class LottoController {
    Money money;
    Lotto lotto;
    List<Lotto> lottos;
    int bonus;
    int maxRound;
    LottoController(){
    }

    public void setpMoney(int pMoney){
        try {
            this.money = new Money(pMoney);
            setMaxRound();
            lottos = new ArrayList<Lotto>();
        }catch(Exception e){
            throw new IllegalArgumentException(e.getMessage());
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

    public void startLotto(){
        for(int i=0;i<maxRound;i++){
            List<Integer>item = makeNumber(); // 생성
            Collections.sort(item); // 정렬
            lottos.add(new Lotto(item)); // 추가
            lottos.get(i).printNumbers(); // 출력
        }
    }

    private List<Integer> makeNumber(){
        List<Integer> item = new ArrayList<Integer>();
        while(item.size()<6){
            int select = Randoms.pickNumberInRange(1,45);
            if(!item.contains(select)){
                item.add(select);
            }
        }
        return item;
    }
}
