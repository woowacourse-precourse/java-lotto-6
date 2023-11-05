package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class ResultService {
//    3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개
//    총 수익률은 62.5%입니다.
    public static void play(BuyLottoRepository buyLottoRepo, WinningLottoRepository winningLottoRepo){
        View.winningStatistics();
        Lotto winningLotto = winningLottoRepo.getLotto();
        BonusNumber bonusNumber = winningLottoRepo.getBonusNumber();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<=7;i++){
            result.add(new ArrayList<>());
        }
        for (Lotto lotto : buyLottoRepo.getLottos()) {
            int cnt=0;
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> winningNum = winningLotto.getNumbers();

            for (Integer number : numbers) {
                if(winningNum.contains(number)) cnt++;
            }

            if(cnt==5){
                if(numbers.contains(bonusNumber.getNumber())) cnt +=2;
            }
            result.get(cnt).add(cnt);
        }


        //결과 출력
        for(int i=3; i<=7;i++){
            List<Integer> list = result.get(i);
            if(i==7){
                System.out.println(i-2+"개 일치 + 보너스 볼 일치 - "+list.size()+"개");
                break;
            }
            System.out.println(i+"개 일치 - "+list.size()+"개");
        }
    }
}
