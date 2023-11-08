package lotto.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.configs.Constant;
import lotto.configs.Prize;

public class User {
    private int money;
    private HashMap<Prize, Integer> prizes;
    private List<Lotto> lotteries;

    public User() {
        this.money = 0;
        this.prizes = new HashMap<>();
        this.lotteries = new ArrayList<>();
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public HashMap<Prize, Integer> getPrizes() {
        return prizes;
    }

    public double getRateOfAmount(){
        return (double) prizes.values().stream().mapToInt(Integer::intValue).sum() / money;
    }

    public boolean hasMoney(){
        return this.money >= Constant.LOTTO_PRICE;
    }

    public void buyLottery(Machine machine){
        lotteries.add(machine.newLottery());
        this.money -= Constant.LOTTO_PRICE;
    }

    public List<Lotto> getLotteries(){
        return lotteries;
    }

    public void collectPrize(Machine machine){
        for(Lotto lotto : lotteries){
            Prize prize = machine.payPrize(lotto);
            prizes.put(prize, prizes.getOrDefault(prize, 0)+1);
        }
    }
}
