package lotto.model.Game;

import lotto.LottoNumberGenerator.LottoGenerator;
import lotto.model.Lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private int amountOfLotto;
    private List<Lotto> lottoNumbers;

    public Game(int amountOfLotto) {
        lottoNumbers = new ArrayList<>();
        this.amountOfLotto = amountOfLotto;
    }

    public void generateLottoNumber(LottoGenerator lottoGenerator) {
        for (int i = 0; i < amountOfLotto; i++) {
            List<Integer> generatedLottoNumber = lottoGenerator.pickLottoNumber();
            sortLottoNumbers(generatedLottoNumber);
            lottoNumbers.add(new Lotto(generatedLottoNumber));
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
}
