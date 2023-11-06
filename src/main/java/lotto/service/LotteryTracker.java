package lotto.service;

import static lotto.settings.LottoSettings.LOTTO_NUMBER_SIZE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.RankingRepository;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class LotteryTracker {
    static List<List<Integer>> result = new ArrayList<>();

    public static LotteryTracker create(){
        RankingRepository.create();

        int size = LOTTO_NUMBER_SIZE.getNumber(); // 복권숫자 크기:6
        for(int i = 0; i<= size; i++){
            result.add(new ArrayList<>());
        }
        return new LotteryTracker();
    }

    public int countLottoIn(int index){
        return result.get(index).size();
    }

    public void matching(BuyLottoRepository buyLottoRepo, WinningLottoRepository winningLottoRepo) {
        int correctNum =0;
        int bonusNum = winningLottoRepo.getBonusNumber();

        for (Lotto buyLotto : buyLottoRepo.getLottos()) {
            correctNum = winningLottoRepo.countMatchingNumber(buyLotto);
            matchingNumber(correctNum,buyLotto,bonusNum);
        }
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
