package lotto.domain;

import lotto.domain.validation.LottoAdditionNumberValidation;
import lotto.domain.validation.LottoWinningNumberValidation;
import lotto.view.EnterLottoWinningNumberView;

import java.util.List;

public class EnterLottoWinningNumbersDomain {
    private final EnterLottoWinningNumberView enterLottoWinningNumberView;
    private final LottoWinningNumberValidation lottoWinningNumberValidation;
    private final LottoAdditionNumberValidation lottoAdditionNumberValidation;
    private List<Integer> lottoWinningNumber;

    public EnterLottoWinningNumbersDomain() {
        this.enterLottoWinningNumberView = new EnterLottoWinningNumberView();
        this.lottoWinningNumberValidation = new LottoWinningNumberValidation();
        this.lottoAdditionNumberValidation = new LottoAdditionNumberValidation();
    }

    public List<Integer> userSetWinningNumberLogic() {
        repeatUntilUserInputsValidWinningNumbers();
        repeatUntilUserInputsValidAdditionNumbers();
        return List.copyOf(lottoWinningNumber);
    }

    private void repeatUntilUserInputsValidWinningNumbers(){
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                lottoWinningNumber = inputAndValidateLottoWinningNumbers();
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void repeatUntilUserInputsValidAdditionNumbers() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                lottoWinningNumber = inputAndValidateLottoAdditionNumbers();
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputAndValidateLottoWinningNumbers() {
        String winningNumber = enterLottoWinningNumberView.enterLottoWinningNumber();
        return lottoWinningNumberValidation.winningNumberValidation(winningNumber);
    }

    private List<Integer> inputAndValidateLottoAdditionNumbers() {
        String additionNumber = enterLottoWinningNumberView.enterAdditionNumber();
        return lottoAdditionNumberValidation.additionLottoWinningNumberValidation(additionNumber, lottoWinningNumber);
    }
}
