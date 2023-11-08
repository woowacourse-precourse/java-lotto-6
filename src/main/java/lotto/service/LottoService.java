package lotto.service;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.CustomerLotto;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PrizeType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
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
        return null;
    }

    public List<Prize> getPrizes(CustomerLotto winningLotto, List <Lotto> customerLottos){
        List <Prize> prizes = new ArrayList<>();
        for(int i=0; i<customerLottos.size();i++) {
            Prize prize = compareLotto(customerLottos.get(i),winningLotto);
            prize.setPrizeType(decidePrizeType(prize));
            prizes.add(prize);
        }
        return prizes;
    }
    private Prize compareLotto(Lotto lotto, CustomerLotto customerLotto){ //사용자의 로또 넘버와 당첨 넘버를 비교한다.
        int count = 0;
        boolean bonusMatch = false;
        List<Integer> winningNum = customerLotto.getLottos().getLotto();
        for(int i=0; i<winningNum.size();i++){
            if(lotto.getLotto().contains(winningNum.get(i))){
                count++;
            }
        }
        if(count == 5 && lotto.getLotto().contains(customerLotto.getBonusNum())){
            bonusMatch = true;
        }
        return new Prize(bonusMatch,count);
    }
    public void printPrize(List<Prize> prizes){
        System.out.println("당첨 통계");
        System.out.println("------");
        for(Prize prize:prizes){
            System.out.println(prize.getPrizeType().getMessage()+"-"+prize.getCount()+"개");
        }
    }
}
