package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Buyer;
import lotto.dto.LotteryWinningNumbers;
import lotto.domain.Lotto;
import lotto.domain.LotteryRankInfo;
import lotto.repository.LottoRepository;
import lotto.validator.Validations;
import lotto.view.ErrorView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static lotto.enums.ErrorMessage.*;
import static lotto.enums.GuideMessage.INFORM_PURCHASED_LOTTOS_NUMBERS_MESSAGE;

public class LotteryService {
    private static final LotteryService singleton = new LotteryService();
    private final LottoRepository repository = LottoRepository.getInstance();
    private final ErrorView errorView = ErrorView.getInstance();
    private final Validations validations = Validations.getInstance();
    private final ResultCalculationService resultCalculationService = ResultCalculationService.getInstance();

    private LotteryService() {
    }

    public static LotteryService getInstance() {
        return singleton;
    }

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

    public List<String> getNumberOfLottos() {
        int numberOfLotto = repository.getBuyer().getNumberOfLotto();

        return List.of(String.format(INFORM_PURCHASED_LOTTOS_NUMBERS_MESSAGE.getMessage(), numberOfLotto));
    }

    public void printLottos() {
        List<Lotto> lottos = repository.getBuyer().getLottos();

        for (Lotto lotto : lottos)
            lotto.printNumber();
    }

    public List<String> printWinningResult() {
        Buyer buyer = repository.getBuyer();
        LotteryWinningNumbers lotteryWinningNumbers = repository.getLotteryWinningNumbers();

        resultCalculationService.makeWinningResult(buyer, lotteryWinningNumbers);

        resultCalculationService.calculateRateOfReturn(buyer);

        return resultCalculationService.printWinningResult(buyer);
    }
}
