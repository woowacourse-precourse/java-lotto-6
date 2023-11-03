package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCondition;
import lotto.domain.lotto.LottoRewardCondition;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.LottosRepository;
import lotto.domain.money.LottoMoney;
import lotto.dto.BuyingResults;
import lotto.dto.WinningResults;

public class LottoMachine {

    private static final String NOT_FOUND_LOTTO = "[ERROR] 로또 번호가 존재하지 않습니다.";
    private static final String DUPLICATES_BONUS_NUMBER = "[ERROR] 당첨 번호와 중복된 보너스 번호를 입력할 수 없습니다.";
    private static final String OUT_OF_RANGE_NUMBER = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";
    public static final String NOT_FOUNT_BONUS_NUMBER = "[ERROR] 보너스 숫자를 찾을 수 없습니다.";

    private final LottosRepository lottosRepository;

    public LottoMachine(final LottosRepository lottosRepository) {
        this.lottosRepository = lottosRepository;
    }

    public void buyLottos(final Supplier<List<Integer>> randomLottoSupplier, final int price) {
        LottoMoney lottoMoney = LottoMoney.from(price);
        List<Lotto> lottos = createLottos(randomLottoSupplier, lottoMoney);
        Lottos userLotto = new Lottos(lottos);
        lottosRepository.saveUserLottos(userLotto);
    }

    public BuyingResults createBuyingResults() {
        Lottos userLottos = findUserLottosObject();
        return BuyingResults.createFrom(userLottos);
    }

    public void addLottoNumbers(final List<Integer> numbers) {
        Lotto winningNumber = Lotto.from(numbers);
        lottosRepository.saveWinningNumber(winningNumber);
    }

    public void addBonusNumber(final int bonusNumber) {
        validateBonusNumber(bonusNumber);
        lottosRepository.saveBonusNumber(bonusNumber);
    }

    public WinningResults createWinningResult() {
        Lottos userLottos = findUserLottosObject();
        Lotto winningLotto = findWinningLottoObject();
        int bonusNumber = findBonusNumber();

        List<LottoRewardCondition> compareResults = userLottos.createCompareResults(winningLotto, bonusNumber);
        return WinningResults.from(compareResults);
    }

    private List<Lotto> createLottos(final Supplier<List<Integer>> randomLottoSupplier,
                                            final LottoMoney lottoMoney) {
        return Stream.generate(randomLottoSupplier)
                .limit(lottoMoney.createBuyingCount())
                .map(Lotto::from)
                .toList();
    }

    private Lottos findUserLottosObject() {
        return lottosRepository.findUserLottos()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_LOTTO));
    }

    private Lotto findWinningLottoObject() {
        return lottosRepository.findWinningLotto()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_LOTTO));
    }

    private void validateBonusNumber(final int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicates(bonusNumber);
    }

    private void validateRange(final int bonusNumber) {
        if (LottoCondition.isNotInRange(bonusNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
        }
    }

    private void validateDuplicates(final int bonusNumber) {
        Lotto winningLotto = findWinningLottoObject();
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATES_BONUS_NUMBER);
        }
    }

    private int findBonusNumber() {
        return lottosRepository.findBonusNumber()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUNT_BONUS_NUMBER));
    }
}
