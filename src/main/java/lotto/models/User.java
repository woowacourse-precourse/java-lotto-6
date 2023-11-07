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

    public void buyLotteries(Machine machine){
        int numberOfLotteries = money / Constant.LOTTO_PRICE;
        for(int i = 0; i < numberOfLotteries; i++){
            lotteries.add(machine.newLottery());
        }
    }
}
