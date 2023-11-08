package service;

import common.Constant;
import common.LottoNumberGenerator;
import dto.Purchase;
import dto.Result;
import model.Amount;
import model.Bonus;
import model.Lotto;
import model.Reward;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private static int count = 0;
    private static List<Lotto> lottos = new ArrayList<>();
    private static List<Result> results = new ArrayList<>();
    private static EnumMap<Reward, Integer> reward = new EnumMap<>(Reward.class);
    private static LottoService instance = new LottoService();
    private LottoService(){}

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

    public void pick(Lotto lotto, Bonus bonus) {
        for(Lotto l : lottos){
            List<Integer> duplication = new ArrayList<>();
            duplication = l.getNumbers().stream().filter(s -> lotto.getNumbers().contains(s))
                    .collect(Collectors.toList());
            int sameCount = duplication.size();

            boolean isSameBonus = false;
            if(l.getNumbers().contains(bonus)) isSameBonus = true;

            results.add(new Result(sameCount, isSameBonus));
        }
    }
}
