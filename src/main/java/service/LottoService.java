package service;

import common.Constant;
import common.LottoNumberGenerator;
import dto.Purchase;
import model.Amount;
import model.Bonus;
import model.Lotto;
import model.Reward;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    private static int count = 0;
    private static List<Lotto> lottos = new ArrayList<>();
    private static EnumMap<Reward, Integer> reward = new EnumMap<>(Reward.class);
    private static LottoService instance = new LottoService();
    private LottoService(){
        reward.put(Reward.FIRST, 0);
        reward.put(Reward.SECOND, 0);
        reward.put(Reward.THIRD, 0);
        reward.put(Reward.FOURTH, 0);
        reward.put(Reward.FIFTH, 0);
    }

    public static LottoService getInstance(){
        return instance;
    }

    public Purchase start(Amount amount){
        count = divideAmount(amount.getAmount());
        for(int i = 0; i<count; i++){
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumber());
            lottos.add(lotto);
        }
        return new Purchase(lottos, count);
    }

    private int divideAmount(int amount){
        return amount / Constant.DIVIDE_UNIT;
    }

    public EnumMap<Reward, Integer> pick(Lotto lotto, Bonus bonus) {
        for(Lotto l : lottos){
            List<Integer> duplication = new ArrayList<>();
            duplication = l.getNumbers().stream().filter(s -> lotto.getNumbers().contains(s))
                    .collect(Collectors.toList());
            int sameCount = duplication.size();

            boolean isSameBonus = false;
            if(l.getNumbers().contains(bonus.getBonus())) isSameBonus = true;

            setReward(sameCount, isSameBonus);
        }
        return reward;
    }

    private void setReward(int sameCount, boolean isSameBouns){
        if(sameCount == Reward.FIRST.getSameCount())
            reward.put(Reward.FIRST, reward.get(Reward.FIRST) + 1);
        else if(sameCount == Reward.SECOND.getSameCount() && isSameBouns)
            reward.put(Reward.SECOND, reward.get(Reward.SECOND) + 1);
        else if(sameCount == Reward.THIRD.getSameCount() && ! isSameBouns)
            reward.put(Reward.THIRD, reward.get(Reward.THIRD) + 1);
        else if(sameCount == Reward.FOURTH.getSameCount())
            reward.put(Reward.FOURTH, reward.get(Reward.FOURTH) + 1);
        else if (sameCount == Reward.FIFTH.getSameCount())
            reward.put(Reward.FIFTH, reward.get(Reward.FIFTH) + 1);
    }

    public double calRateOfReturn(Amount amount){
        double earn = 0;
        for(Map.Entry<Reward, Integer> entry : reward.entrySet()){
            int rewardAmount = entry.getKey().getReward();
            int sameCount = entry.getValue();
            earn += rewardAmount * sameCount;
        }
        return earn / amount.getAmount() * 100;
    }
}
