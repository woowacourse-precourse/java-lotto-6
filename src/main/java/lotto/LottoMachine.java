package lotto;

import java.util.List;

import static lotto.Utils.Message.LOTTO_AMOUNT;

public class LottoMachine {
    private final LottoJudge lottoJudge;

    public LottoMachine() {
        this.lottoJudge = new LottoJudge();
    }

    public List<Integer> makeLotto() {
        List<Integer> lottoNumbers = lottoJudge.userLottoNumber();
        return lottoNumbers;

    }

    public int makeBonusNumber(List<Integer> lottoNumbers) {
        int bonusNumber = lottoJudge.userBonusNumber(lottoNumbers);
        return bonusNumber;
    }

    public int lottoAmount(int money) {
        int amount = money / 1000;
        return amount;
    }

    public int lottoMoney() {
        return lottoJudge.userMoney();
    }

    public void printLottoAmount(int amount) {
        System.out.println(amount + LOTTO_AMOUNT.getValue());
    }

}
