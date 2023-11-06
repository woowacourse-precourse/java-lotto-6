package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.settings.LottoSettings.MAX_VALUE;
import static lotto.settings.LottoSettings.MIN_VALUE;
import static lotto.settings.LottoSettings.LOTTO_NUMBER_SIZE;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class LottoService {
    private final BuyLottoRepository buyLottoRepo = new BuyLottoRepository();
    public BuyLottoRepository quickPick(int purchaseCount){
        while(purchaseCount>0){
            Lotto lotto = new Lotto(createRandomNumbers());
            buyLottoRepo.add(lotto);

            extractAscendingNumbers(lotto.listToString());
            purchaseCount --;
        }
        return buyLottoRepo;
    }

    private void extractAscendingNumbers(String lottoNumber) {
        View.buyLottos(lottoNumber);
    }

    private List<Integer> createRandomNumbers() {
        return pickUniqueNumbersInRange(
                MIN_VALUE.getNumber(),
                MAX_VALUE.getNumber(),
                LOTTO_NUMBER_SIZE.getNumber());
    }

    public WinningLottoRepository createWinningNumber(){

        Lotto lotto = new Lotto(InputService.winningNumbers());
        BonusNumber bonusNumber = BonusNumber.from(InputService.bonusNumber());

        return WinningLottoRepository.of(lotto, bonusNumber);
    }
}
