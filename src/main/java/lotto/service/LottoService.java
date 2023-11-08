package lotto.service;

import lotto.model.Lotto;
import lotto.util.Constants;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public Lotto createWinningNumber(final String lottoNumbers) {
        String[] splitNumbers = lottoNumbers.split(Constants.SPLIT);
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : splitNumbers) {
            winningNumber.add(Integer.parseInt(number));
        }
        return new Lotto(winningNumber);
    }
}
