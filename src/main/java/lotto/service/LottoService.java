package lotto.service;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
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
    public void compareLotto(List<Lotto> customerLotto,List<Integer> winningNum){ //사용자의 로또 넘버와 당첨 넘버를 비교한다.
        int maxScore = 0;
        for(int i=0; i<customerLotto.size();i++){
            List<Integer> lotto = customerLotto.get(i).getLotto();
            for(int j=0; j<i;j++){
                if(lotto.get(j).equals(winningNum.get(i))){
                    maxScore++;
                }
            }
        }
    }
}
