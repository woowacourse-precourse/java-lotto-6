package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lottos;
import lotto.util.Quicksort;
import lotto.model.Lotto;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        int tryNumber = lottoView.requestMoney();
        Lottos lottos = new Lottos(tryNumber);
        lottoView.printLottos(lottos.getLottos(), tryNumber);
        List<Integer> winning_number = lottoView.requestWinningLOTTO();
        winning_number.add(lottoView.requestBonusNumber());
        for(Lotto lotto: lottos.getLottos()){
            lottos.checkRank(winning_number,lotto);
        }
        lottoView.printLottoRank(lottos);
    }

//    public List<Lotto> makeLottoNumber(int tryNumber) {
//        List<Lotto> Lottos = new ArrayList<>();
//        for (int i = 0; i < tryNumber; i++) {
//            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Lottos.add(new Lotto(sortNumber(numbers)));
//        }
//        return Lottos;
//    }
//
//    private List<Integer> sortNumber(List<Integer> numbers) {
//        Quicksort quicksort = new Quicksort();
//        quicksort.sort(numbers);
//        return numbers;
//    }

//    public List<Integer> checkWinningCount(List<Lotto> Lottos, List<Integer> winning_numbers){
//        List<Integer> winning_count = Arrays.asList(0, 0, 0, 0, 0);
//        for (Lotto lotto : Lottos) {
//            int count = 0;
//            count = compareNumber(lotto, winning_numbers);
//        }
//    }
//
//    public int compareNumber(Lotto lotto, List<Integer> winning_numbers) {
//        int count = 0;
//        for (int number : lotto.getNumbers()) {
//            if (winning_numbers.contains(number)) {
//                count++;
//            }
//        }
//        return count;
//    }
}
