package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.InputLottoNumException;
import lotto.util.ParseString;

public class InputWinningNumberService {
    InputLottoNumException inputLottoNumException = new InputLottoNumException();
    ParseString parser = new ParseString();

    public void addWinningNum(List<Integer> lotto, String[] splitedInput) {
        for (int i = 0; i < splitedInput.length; i++) {
            lotto.add(Integer.parseInt(splitedInput[i]));
        }
    }

    public List<Integer> getWinningNum(String[] splitedInput) {
        List<Integer> lotto = new ArrayList<>();
        addWinningNum(lotto, splitedInput);
        Collections.sort(lotto);
        return lotto;
    }

    public Lotto setWinningNum(String input) {
        getNumbers(input);
        return new Lotto(getWinningNum(parser.split(input)));
    }

    public void setBonusNum(Lotto lotto, String bonusNum) {
        inputLottoNumException.validateBonus(lotto.getNumbers(), bonusNum);
        lotto.setBonusNum(Integer.parseInt(bonusNum));
    }

    public void getNumbers(String numbers) {
        inputLottoNumException.validateException(parser.split(numbers));
    }
}
