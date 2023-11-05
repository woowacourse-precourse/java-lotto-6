import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;
import lotto.model.Game;

public class LottoGame implements Game {
    private static final int lottoNumbers = 6;
    private static final int lottoPirce = 1000;
    private final int lottoPurchaseAmount;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoGame(int lottoPurchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoPurchaseAmount = validateLottoPurchaseAmount(lottoPurchaseAmount);
        winningLotto = new Lotto(validateDuplicates(winningNumbers));
        this.bonusNumber = validateBonusNumber(winningNumbers, bonusNumber);
    }

    private int validateLottoPurchaseAmount(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount % lottoPirce != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 " + lottoPirce + "원 단위입니다.");
        }

        return lottoPurchaseAmount;
    }

    private List<Integer> validateDuplicates(List<Integer> winningNumbers) {
        Set<Integer> numberSet = new HashSet<>(winningNumbers);
        if (numberSet.size() != lottoNumbers) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 " + lottoNumbers + "개의 숫자입니다.");
        }

        return winningNumbers;
    }

    private int validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return bonusNumber;
    }
}