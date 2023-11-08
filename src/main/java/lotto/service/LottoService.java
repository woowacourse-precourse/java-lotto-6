package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.settings.LottoSettings.LOTTO_NUMBER_SIZE;
import static lotto.settings.LottoSettings.MAX_VALUE;
import static lotto.settings.LottoSettings.MIN_VALUE;

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
            purchaseCount --;
        }
        return buyLottoRepo;
    }
    public List<String> extractAscendingNumbers() {
        return buyLottoRepo.extractAscendingNumbers();
    }

    public void printNumbers(List<String> buyLottosNumber) {
        for (String lottoNumber : buyLottosNumber) {
            View.buyLottos(lottoNumber);
        }
        View.spaceSkipTwice();
    }

    public List<Integer> createRandomNumbers() {
        return pickUniqueNumbersInRange(
                MIN_VALUE.getNumber(),
                MAX_VALUE.getNumber(),
                LOTTO_NUMBER_SIZE.getNumber());
    }

    public WinningLottoRepository createWinningLotto(){

        Lotto winningLotto = Input.winningNumbers();
        View.spaceSkip();
        BonusNumber bonusNumber = Input.bonusNumber(winningLotto);

        return WinningLottoRepository.of(winningLotto, bonusNumber);
    }
}
