package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.entity.Lotto;
import lotto.entity.Prize;
import lotto.model.Profit;
import lotto.model.Validator;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoService {
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int COUNT = 6;
    private List<Lotto> lottos;

    private final Profit profit;
    private final Input input;
    private final Output output;
    private final Validator validator;
    private Integer bonus;
    private Lotto drawLotto;
    public LottoService(Profit profit, Input input, Output output, Validator validator){
        this.lottos = new ArrayList<>();
        this.profit = profit;
        this.input = input;
        this.output = output;
        this.validator = validator;
    }
    public void startLotto(){

        Integer buyAmount = 0;
        while(true){
            try{
                String rawBuyAmount = input.buyAmount();
                buyAmount = validator.validateBuyAmount(rawBuyAmount);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        int count = buyAmount/1000;
        for(int i = 0; i<count; i++){
            List<Integer> generate = Randoms.pickUniqueNumbersInRange(MIN, MAX,COUNT);
            Lotto generatedLotto = new Lotto(generate);
            lottos.add(generatedLotto);

        }
        output.lottoResult(lottos);
    }
    public void drawNumber(){
        List<Integer> drawNumber = new ArrayList<>();
        while(true){
            try{
                String rawDrawNumber = input.pickSixNumber();
                drawNumber = validator.validatePickSixNumber(rawDrawNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }


        try{
            drawLotto = new Lotto(drawNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        while(true){
            try{
                String rawBonusNumber = input.pickBonusNumber();
                bonus = validator.validatePickBonusNumber(rawBonusNumber,drawLotto.getNumbers());
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }
    public void calculateProfit(){
        for(Lotto lotto1 : lottos){
           int count = matchCounter(lotto1);
           boolean isBonus = bonusMatch(lotto1);
           Prize prize = lottoChecker(count,isBonus);
//            System.out.println("prize = " + prize);
           profit.updateProfitRate(prize);
        }
    }
    public void resultOutput(){
        output.profitResult(profit);
    }

    private Integer matchCounter(Lotto generatedLotto){
        int count =0 ;
        for(Integer number: generatedLotto.getNumbers()){
            if(isNumberMatch(number)){
                count+=1;
            }
        }
//        System.out.println("매칭된 숫자"+count);
        return count;
    }
    private boolean bonusMatch(Lotto generatedLotto){
        return generatedLotto.getNumbers().contains(bonus);
    }
    private boolean isNumberMatch(Integer pickedNumber){
        if(drawLotto.getNumbers().contains(pickedNumber)){
            return true;
        }
        return false;
    }
    private Prize lottoChecker(Integer matchCount, boolean bonus){
        Prize result = Prize.OUT;
        for(Prize prize : Prize.values()){
            if(prizeMatcher(prize,matchCount,bonus)){
                result = prize;
            }
        }
        return result;
    }

    private boolean prizeMatcher(Prize prize, Integer matchCount, boolean bonus){
        return prize.getBonusMatch() == bonus && Objects.equals(prize.getMatchCount(), matchCount);
    }
}
