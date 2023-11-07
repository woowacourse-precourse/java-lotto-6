package lotto.validator;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATE;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.view.BonusNumberView;
import lotto.view.LottoView;
import lotto.view.PurchaseView;

public class CheckValidator {

    private PurchaseView purchaseView;
    private LottoView lottoView;
    private BonusNumberView bonusNumberView;

    public CheckValidator(PurchaseView purchaseView, LottoView lottoView, BonusNumberView bonusNumberView){
        this.purchaseView = purchaseView;
        this.lottoView = lottoView;
        this.bonusNumberView = bonusNumberView;
    }


    public Purchase validatePurchase() {
        while (true) {
            try {
                int money = purchaseView.requestMoney();
                return new Purchase(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto validateLotto() {
        while (true) {
            try {
                List<Integer> numbers = lottoView.numbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber validateBonusNumber(List<Integer> numbers) {
        while (true) {
            try {
                int number = bonusNumberView.bonusNumber();
                validateBonusNumberNotInLottoNumbers(number ,numbers);
                return new BonusNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void validateBonusNumberNotInLottoNumbers(int bonusNumber, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}


