package lotto.service;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LuckyLotto;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PrizeType;

import java.util.*;
import java.util.stream.Stream;

public class LottoController {
    List<Prize> prizes=new ArrayList<>();
    public List <Lotto> createRandomLotto(int money){
        int num = money / 1000;
        List <Lotto> lottos = Stream.generate(()-> {
            List<Integer> sortedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .toList();
            return new Lotto(sortedNumbers);
        })
                .limit(num)
                .toList();
        printLotto(num,lottos);
        return lottos;
    }
    public void printLotto(int num,List<Lotto> lottos){
        System.out.println(num+"개를 구매했습니다.");
        for(Lotto lotto:lottos){
            System.out.println(lotto.getLotto());
        }
    }
    public PrizeType decidePrizeType(Prize prize){
        if(prize.getCount() == 6){
           return PrizeType.FIRST;
        }
        if(prize.getCount()==5&&prize.isBonusMatch()){
            return PrizeType.SECOND;
        }
        if(prize.getCount()==5&&!prize.isBonusMatch()){
            return PrizeType.THIRD;
        }
        if(prize.getCount()==4){
            return PrizeType.FOURTH;
        }
        if(prize.getCount()==3){
            return PrizeType.FIFTH;
        }
        return PrizeType.NOTHING;
    }

    public List<Prize> getPrizes(LuckyLotto luckyLotto, List <Lotto> customerLottos){
        List <Prize> prizes = new ArrayList<>();
        for(int i=0; i<customerLottos.size();i++) {
            Prize prize = compareLotto(customerLottos.get(i),luckyLotto);
            prize.setPrizeType(decidePrizeType(prize));
            prizes.add(prize);
        }
        return prizes;
    }
    private Prize compareLotto(Lotto lotto, LuckyLotto luckyLotto){ //사용자의 로또 넘버와 당첨 넘버를 비교한다.
        int count = 0;
        boolean bonusMatch = false;
        List<Integer> winningNum = luckyLotto.getLottos().getLotto();
        for(int i=0; i<winningNum.size();i++){
            if(lotto.getLotto().contains(winningNum.get(i))){
                count++;
            }
            if(count == 5 && lotto.getLotto().contains(luckyLotto.getBonusNum())){
                bonusMatch = true;
            }
        }
        System.out.println(count);
        return new Prize(bonusMatch,count);
    }
    public double caculateMoney(int compentation,int money){
        double caculate = (double) (compentation - money) / money ;
        return Math.round((caculate*100.0)*100.0)/100.0;
    }
    public int decideCompentation(List<Prize> prizes){
        int max = 0;
        for (Prize prize:prizes){
            int compentation = prize.getPrizeType().getCompentation();
            if(max<compentation){
                max = compentation;
            }
        }
        return max;
    }
    public void printCaculate(double compentationRate){
        System.out.println("총 수익률은" + compentationRate+"% 입니다.");
    }
    public void printPrize(List<Prize> prizes) {
        System.out.println("당첨 통계");
        System.out.println("------");

        for (PrizeType prizeType : PrizeType.values()) {
            int count = 0;
            int prizeAmount = 0;

            for (Prize prize : prizes) {
                if (prize.getPrizeType() == prizeType) {
                    count = prize.getCount();
                    break;
                }

            }
            String message = prizeType.getMessage();
            System.out.println(message + "-" + count + "개");
        }
    }

}
