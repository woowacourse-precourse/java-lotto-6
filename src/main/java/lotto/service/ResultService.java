package lotto.service;

import static lotto.settings.LottoSettings.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.RankingRepository;
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

        // 몇개맞았는지 저장
        List<List<Integer>> result = new ArrayList<>();

        createResult(buyLottoRepo, result, winningLotto, bonusNumber);
        printResult(result);
    }

    private static void createResult(BuyLottoRepository buyLottoRepo, List<List<Integer>> result, Lotto winningLotto,
                                  BonusNumber bonusNumber) {
        int size = SIZE.getNumber(); // 복권숫자 크기:6

        for(int i = 0; i<= size; i++){
            result.add(new ArrayList<>());
        }

        for (Lotto lotto : buyLottoRepo.getLottos()) {
            int cnt=0;
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> winningNum = winningLotto.getNumbers();

            for (Integer number : numbers) {
                if(winningNum.contains(number)) cnt++;
            }
            //맞은 개수만큼 등수 지정
            if(cnt==3){
                result.get(5).add(cnt);}
            else if(cnt==4){
                result.get(4).add(cnt);}
            else if(cnt==5){
                if(numbers.contains(bonusNumber.getNumber())){
                    result.get(2).add(cnt);
                }
                result.get(3).add(cnt);
            }
            else if(cnt==6){
                result.get(1).add(cnt);}
        }
    }

    private static void printResult(List<List<Integer>> result) {

        RankingRepository.create();

        //등수별 결과 출력
        for(int i=5; i>0;i--){
            View.result(RankingRepository.getRank(i), result.get(i).size());
        }
    }
}
