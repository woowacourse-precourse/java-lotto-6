package lotto.model;

import static lotto.utility.Constants.LOTTO_LENGTH;
import static lotto.utility.Constants.MAX_LOTTO_NUMBER;
import static lotto.utility.Constants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<Integer> winningNumbers;
    private static Integer bonusNumber;
    private Integer purchaseAmount;
    private Integer purchaseLottoNumber;
    private List<Lotto> lottos;
    public User() {
        lottos = new ArrayList<>();
    }

    public static void setWinningNumbers(List<Integer> winningNumbers) {
        User.winningNumbers = winningNumbers;
    }

    public static List<Integer> getWinningNumbers() {
        return User.winningNumbers;
    }

    public static void setBonusNumber(Integer bonusNumber) {
        User.bonusNumber = bonusNumber;
    }

    public static Integer getBonusNumber() {
        return User.bonusNumber;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getPurchaseLottoNumber() {
        return purchaseLottoNumber;
    }

    public void setPurchaseLottoNumber(Integer purchaseLottoNumber) {
        this.purchaseLottoNumber = purchaseLottoNumber;
    }

    public void setLottos() {
        for (int i=0; i<purchaseLottoNumber; i++) {
            this.lottos.add(generateLotto());
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH);
        Lotto newLotto = new Lotto(numbers);
        return newLotto;
    }

}
