package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.settings.LottoRange.MAX_VALUE;
import static lotto.settings.LottoRange.MIN_VALUE;
import static lotto.settings.LottoRange.SIZE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.view.View;

public class LottoService {
    private final BuyLottoRepository buyLottoRepository = new BuyLottoRepository();
    public BuyLottoRepository quickPick(int purchaseCount){
        while(purchaseCount>0){
            Lotto lotto = new Lotto(createRandomNumbers());
            buyLottoRepository.add(lotto);

            numberExtraction(lotto.listToString());
            purchaseCount --;
        }
        return buyLottoRepository;
    }

    private static void numberExtraction(String lottoNumber) {
        View.buyLottos(lottoNumber);
    }

    private List<Integer> createRandomNumbers() {
        return pickUniqueNumbersInRange(
                MIN_VALUE.getNumber(),
                MAX_VALUE.getNumber(),
                SIZE.getNumber());
    }

    public void createWinningNumber(){
        View.requestWinningNumber();
        InputService.winningNumbers();

        View.requestBonusNumber();
        InputService.number();
    }
}
