package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validators.AmountValidator;
import validators.LottoValidator;

public class UserLotto {

    private int amount;
    private int lottoCount;

    private Lotto lotto;

    private int bonusNumber;

    public UserLotto (String purchasedAmount) throws IllegalArgumentException{
        if(AmountValidator.isVerifyAmount(purchasedAmount)) {
            int amount = Integer.parseInt(purchasedAmount);
            this.amount = amount;
            this.lottoCount = amount/1000;
        }
    }


    public void setInputLotto(String inputLotto) throws IllegalArgumentException{
        LottoValidator.verifyInputLotto(inputLotto);

        List<Integer> numbers = createUserLottoNumbers(inputLotto);
        LottoValidator.verifyLotto(numbers);

        setLotto(new Lotto(numbers));
    }

    private List<Integer> createUserLottoNumbers(String inputLotto){
        return Arrays.stream(inputLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public void setInputBonusLotto(String inputBonusLotto) throws IllegalArgumentException{
        LottoValidator.verifyBonusLotto(inputBonusLotto, this.lotto.getNumbers());
        setBonusNumber(Integer.parseInt(inputBonusLotto));
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    private void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
