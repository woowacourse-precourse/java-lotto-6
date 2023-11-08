package lotto.model;

import lotto.LottoNumberGenerator.LottoGenerator;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private int totalPrice;
    private int amountOfLotto;
    private List<Lotto> lottoNumbers;
    private BonusNumber bonusNumber;
    private WinningLotto winningLotto;

    public Game(int amountOfLotto) {
        totalPrice = 0;
        lottoNumbers = new ArrayList<>();
        this.amountOfLotto = amountOfLotto;
    }

    public void createBonusNumber(String bonusNumber) {
        InputValidator.validateIsWinningLottoNumberContains(bonusNumber, winningLotto.getWinningLottoNumbers());
        this.bonusNumber = BonusNumber.create(bonusNumber);
    }

    public void createWinningLotto(String inputWinningLotto) {
        this.winningLotto = new WinningLotto(inputWinningLotto);
    }

    public void generateLottoNumber(LottoGenerator lottoGenerator) {
        for (int i = 0; i < amountOfLotto; i++) {
            List<Integer> modifiable = new ArrayList<>(lottoGenerator.pickLottoNumber());
            sortLottoNumbers(modifiable);
            lottoNumbers.add(new Lotto(modifiable));
        }
    }

    private void sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public int getAmountOfLotto() {
        return amountOfLotto;
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Integer> compareLotto() {
        List<Integer> list = new ArrayList<>();
        for (Lotto lotto : lottoNumbers) {
            list.add(lotto.isContainWinningLottoNumber(winningLotto.getWinningLottoNumbers()));
        }
        return list;
    }

    public List<Boolean> compareBonusLotto() {
        List<Boolean> bonusLotto = new ArrayList<>();
        for (Lotto lotto : lottoNumbers) {
            bonusLotto.add(containBonusLotto(lotto));
        }
        return bonusLotto;
    }

    public boolean containBonusLotto(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public void checkLottoResult(int lotto, boolean bonus) {
        for (Rank rank : Rank.values()) {
            totalPrice += rank.checkPrice(lotto, bonus);
        }
    }
}
