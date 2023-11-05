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
    public void setLotto(List<Integer> number){
        this.lotto = new Lotto(number);
    }
    public void setLotto(int bonus){
        validate(bonus);
        setBonus(bonus);
    }
    private void validate(int bonus){
        if(lotto.getNumbers().contains(bonus))
            throw new IllegalArgumentException("보너스번호는 당첨번호와 다른 숫자여야 합니다.");
        if(bonus<=0||bonus>45)
            throw new IllegalArgumentException("보너스번호는 1이상 45이하의 숫자여야 합니다.");
    }
    public void startLotto(){
        for(int i=0;i<maxRound;i++){
            List<Integer>item = makeNumber(); // 생성
            lottos.add(new Lotto(item)); // 추가
        }
    }
    private List<Integer> makeNumber(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
    public void showLottos(){
        for(int i=0;i<maxRound;i++){
            lottos.get(i).printNumbers(); // 출력
        }
    }

    public double showLottoReward(){
        for(int i=0;i<maxRound;i++)
        {
            checkNumber(i);
        }
        money.printReward();
        return money.getRRate();
    }

    public void checkNumber(int index){
        List<Integer> item = lottos.get(index).getNumbers();
        double count = 0;
        for(int i=0;i<item.size();i++){
            if(lotto.getNumbers().contains(item.get(i))){
                count++;
            }
        }
        if(count==5){
           count+=checkBonus(item);
        }
        money.addReward(count);
    }
    private double checkBonus(List<Integer> item){
        if(item.contains(bonus)) return 0.5;
        return 0;
    }
}
