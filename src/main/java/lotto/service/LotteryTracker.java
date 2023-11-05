package lotto.service;

import static lotto.settings.LottoSettings.LOTTO_NUMBER_SIZE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.RankingRepository;
import lotto.view.View;

public class LotteryTracker {
    List<List<Integer>> result = new ArrayList<>();

    public void create(){
        RankingRepository.create();

        int size = LOTTO_NUMBER_SIZE.getNumber(); // 복권숫자 크기:6
        for(int i = 0; i<= size; i++){
            result.add(new ArrayList<>());
        }
    }

    public int countLottoIn(int index){
        return result.get(index).size();
    }

    public void matchingNumber(int cnt, Lotto buyLotto, int bonusNum){
        int rank = buyLotto.findRank(cnt, bonusNum);
        result.get(rank).add(cnt);
    }

    public void printResult() {
        //등수별 결과 출력
        for(int rank=5; rank>0;rank--){
            String prize = RankingRepository.getPrizeBy(rank);
            View.result(prize, countLottoIn(rank));
        }
    }
}
