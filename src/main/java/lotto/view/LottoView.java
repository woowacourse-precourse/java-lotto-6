package lotto.view;


import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.dto.LottoPrizeDto;

public class LottoView {
    private static final String BONUS_NUMBER_DUPLICATED_ERROR = "보너스 숫자는 당첨 번호와 중복될 수 없습니다.";
    public static final String ERROR = "[ERROR] ";

    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();

    public Money getLottoPurchasingCost() {
        Money money;
        do {
            money = inputView.getLottoPurchasingCost();
        } while (money == null);

        return money;
    }

    public void printPublishedLottos(int lottoCount, List<Lotto> lottos) {
        outputView.printPublishedLottos(lottoCount, lottos);
    }

    public void printWinningStatistics(LottoPrizeDto dto) {
        outputView.printWinningStatistics(dto);
    }

    public void printRateOfReturn(double rateOfReturn) {
        outputView.printRateOfReturn(rateOfReturn);
    }

    public Lotto getWinningLotto() {
        Lotto winningNumbers;
        do {
            winningNumbers = inputView.getWinningLotto();
        } while (winningNumbers == null);

        return winningNumbers;
    }

    public LottoNumber getBonusNumberWithDuplicationCheck(Lotto winningLotto) {
        LottoNumber bonusNumber;
        do {
            bonusNumber = getBonusNumber();
            if (winningNumbersContainsBonusNumber(winningLotto, bonusNumber)) {
                System.out.println(LottoView.ERROR + BONUS_NUMBER_DUPLICATED_ERROR);
                bonusNumber = null;
            }
        } while (bonusNumber == null);

        return bonusNumber;
    }

    private boolean winningNumbersContainsBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        return winningLotto.contains(bonusNumber.getNumber());
    }

    private LottoNumber getBonusNumber() {
        LottoNumber bonusNumber;
        do {
            bonusNumber = inputView.getBonusNumber();
        } while (bonusNumber == null);

        return bonusNumber;
    }

}
