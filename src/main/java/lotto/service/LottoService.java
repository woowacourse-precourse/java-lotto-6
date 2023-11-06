package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.settings.ErrorMessage.DUPLICATE_NUM;
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

    public WinningLottoRepository createWinningLotto(){
        // 올바르게 입력할 때까지 계속 입력받습니다.
        Lotto winningLotto = inputWinningNumber();
        BonusNumber bonusNumber = inputBonusNumber(winningLotto);
        return WinningLottoRepository.of(winningLotto, bonusNumber);
    }

    private  Lotto inputWinningNumber() {
        while(true){
            try {
                return new Lotto(Input.winningNumbers());
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber(Lotto winningLotto) {
        while(true){
            try {
                BonusNumber bonusNumber = BonusNumber.from(Input.bonusNumber());
                validateBonusNumInLotto(winningLotto,bonusNumber);
                return bonusNumber;
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
            }
        }
    }

    private void validateBonusNumInLotto(Lotto lotto, BonusNumber bonusNumber) {
        int bonusNum = bonusNumber.getNumber();
        if(lotto.has(bonusNum)){
            throw new IllegalArgumentException(DUPLICATE_NUM.getMessage());
        }
    }
}
