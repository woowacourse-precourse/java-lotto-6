package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Quicksort;
import lotto.model.Lotto;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }
    public void run(){
        int tryNumber = lottoView.requestMoney();
        List<Lotto> Lottos = makeLottoNumber(tryNumber);
        lottoView.printLottos(Lottos,tryNumber);
        List<Integer> winning_number = lottoView.requestWinningLOTTO();
        int bonus_number = lottoView.requestBonusNumber();
    }

    public List<Lotto> makeLottoNumber(int tryNumber) {
        List<Lotto> Lottos = new ArrayList<>();
        for(int i=0;i<tryNumber;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lottos.add(new Lotto(sortNumber(numbers)));
        }
        return Lottos;
    }

    private List<Integer> sortNumber(List<Integer> numbers) {
        Quicksort quicksort = new Quicksort();
        quicksort.sort(numbers);
        return numbers;
    }

}
