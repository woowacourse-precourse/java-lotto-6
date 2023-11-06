package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Buyer;
import lotto.domain.LotteryWinningNumbers;
import lotto.dto.Lotto;
import lotto.dto.ResultCalculationSystem;
import lotto.repository.LottoRepository;
import lotto.validator.Validations;
import lotto.view.ErrorView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.enums.ErrorMessage.*;

public class Service {
    private final LottoRepository repository = LottoRepository.getInstance();
    private final ErrorView errorView = ErrorView.getInstance();
    private final Validations validations = new Validations();
    private final ResultCalculationSystem resultCalculationSystem = new ResultCalculationSystem();
    
    
    public void lottoPayment(String input) {
        int desiredPurchaseAmount = validations.validateEnteredLottoPayment(input);
        
        Buyer buyer = repository.getBuyer();
        buyer.setDesiredPurchaseAmount(desiredPurchaseAmount);
        buyer.setNumberOfLotto(desiredPurchaseAmount / 1000);

        createNewLottos(buyer.getLottos(), buyer.getNumberOfLotto());
    }

    private void createNewLottos(List<Lotto> lottos, int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoNumbers.sort(Comparator.naturalOrder());
            try {
                lottos.add(new Lotto(lottoNumbers));
            } catch (IllegalArgumentException e) {
                errorView.printErrorPage(INVALID_LOTTO_NUMBERS_COUNT_ERROR);
                i--;
            }
        }
    }

    public void saveLottoNumbers(String input) {
        List<Integer> lottoWinningNumbers = validations.validateEnteredLottoNumbers(input);
        
        LotteryWinningNumbers lotteryWinningNumbers = repository.getLotteryWinningNumbers();
        lotteryWinningNumbers.setWinningNumbers(lottoWinningNumbers);
    }

    public void saveBonusNumber(String input) {
        List<Integer> winningNumbers = repository.getLotteryWinningNumbers().getWinningNumbers();
        validations.validateEnteredBonusNumber(winningNumbers, input);
    }

    public int getNumberOfLottos() {
        return repository.getBuyer().getNumberOfLotto();
    }

    public void printLottos() {
        List<Lotto> lottos = repository.getBuyer().getLottos();
        for(Lotto lotto : lottos)
            lotto.printNumber();
    }

    public void printWinningResult() {
        List<Lotto> lottos = repository.getBuyer().getLottos();
        List<Integer> lottoWinningNumbers = repository.getLotteryWinningNumbers().getWinningNumbers();
        int bonusNumber = repository.getLotteryWinningNumbers().getBonusNumber();
        int desiredPurchaseAmount = repository.getBuyer().getDesiredPurchaseAmount();

        resultCalculationSystem.makeWinningResult(lottos, lottoWinningNumbers, bonusNumber);
        resultCalculationSystem.calculateRateOfReturn(desiredPurchaseAmount);

        resultCalculationSystem.printWinningResult();
    }
}
