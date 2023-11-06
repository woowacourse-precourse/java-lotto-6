package domain;

import static util.ErrorMessage.CANT_DUPLICATE_NUMBER;
import static view.InputView.inputBonusNumber;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if(!validateDuplicate(lotto, bonusNumber)){
            while(true){
                if(validateDuplicate(lotto, inputBonusNumber())){
                    break;
                }
            }
        }

    }

    private boolean validateDuplicate(Lotto lotto, int bonusNumber){
        try {
            if (lotto.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println(CANT_DUPLICATE_NUMBER.getErrorMessage());
            return false;
        }
        return true;
    }
}
