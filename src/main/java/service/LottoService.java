package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.User;
import model.WinningNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
enum RewardMoney{
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);
    private int money;

    RewardMoney( int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}

public class LottoService {
    public List<Integer> makeWinningNumber(String number){
        List<Integer> winning_number = new ArrayList<>();
        String[] numberList = number.split(",");

        for (String num : numberList) {
            try {
                winning_number.add(Integer.parseInt(num));
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }
        return winning_number;
    }
    public Lotto generateLottoNumber(){
        Set<Integer> lottoNumberSet = new HashSet<>();

        while (lottoNumberSet.size() <6){
            lottoNumberSet.add(Randoms.pickNumberInRange(1, 45));
        }
        ArrayList<Integer> lottoNumber = new ArrayList<>(lottoNumberSet);
        Collections.sort(lottoNumber);

        Lotto lotto = new Lotto(lottoNumber);

        return lotto;
    }

    public List<Lotto> makeLottoList(int price){
        List<Lotto> lottoList = new ArrayList<>();
        int lotto_count = price/1000;
        for(int i = 0; i<lotto_count;i++){
            lottoList.add(generateLottoNumber());
        }
        return lottoList;
    }

    public Map<String,Integer> calculateRanking(Lotto lotto, WinningNumber winningNumber){
        Map<String, Integer> lottoResult = new HashMap<>();
        int count =0;
        lottoResult.put("bonus", 0);
        for(int num:winningNumber.getWinning_number()){
            if(lotto.getNumbers().contains(num)){
                count++;
            }
        }
        if (lotto.getNumbers().contains(winningNumber.getBonus())) {
            lottoResult.replace("bonus", 1);
        }
        lottoResult.put("count", count);
        return lottoResult;
    }

    public int awardLotto(Map<String, Integer> lottoResult, User user){
        if (lottoResult.get("count") == 3){
            user.checkRanking("fifth");
        }else if(lottoResult.get("count") == 4){
            user.checkRanking("fourth");
        }else if(lottoResult.get("count") == 5){
            user.checkRanking("third");
        }else if(lottoResult.get("count") == 5 && lottoResult.get("bonus") == 1){
            user.checkRanking("second");
        }else if(lottoResult.get("count") == 6){
            user.checkRanking("first");
        }
        return 0;
    }

    public int calculateReward(User user){
        int reward = 0;
        reward = user.getFifth() * RewardMoney.FIFTH.getMoney()+
                user.getFourth() * RewardMoney.FOURTH.getMoney()+
                user.getThird() * RewardMoney.THIRD.getMoney()+
                user.getSecond() * RewardMoney.SECOND.getMoney()+
                user.getFirst() * RewardMoney.FIRST.getMoney();
        return reward;
    }
}
