package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.constants.Constants;

public class Customer {
    private final int numberOfLottoTicket;
    private final int money;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private EnumMap<Reward, Integer> prizes = new EnumMap<>(Reward.class);
    private int prizeSum = 0;
    public Customer(int money, int numberOfLottoTicket) {
        this.money = money;
        this.numberOfLottoTicket = numberOfLottoTicket;
        setPrizes();

    }
    public int getMoney(){
        return this.money;
    }

    public int getNumberOfLottoTicket() {
        return numberOfLottoTicket;
    }

    public void purchaseLotto(Lotto lotto) {
        purchasedLottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return this.purchasedLottos;
    }

    private void setPrizes() {
        prizes.put(Reward.MATCH_THREE, 0);
        prizes.put(Reward.MATCH_FOUR, 0);
        prizes.put(Reward.MATCH_FIVE_NOT_BONUS, 0);
        prizes.put(Reward.MATCH_FIVE_BONUS, 0);
        prizes.put(Reward.MATCH_SIX, 0);

    }

    public EnumMap<Reward, Integer> getPrizes() {
        return prizes;
    }
    public int getTotalPrize(){
        for(Reward reward : Reward.values()){
            if(reward.getCount() == Constants.ZERO){
                continue;
            }
            prizeSum  += (int) (prizes.get(reward) * reward.getPrize());
        }
       return prizeSum;
    }
}
