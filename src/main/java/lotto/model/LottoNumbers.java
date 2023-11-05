package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String comma = ",";
    private List<Lotto> winningLotto = new ArrayList<>();
    private List<Integer> randomNumbers;

    public List<Integer> createPlayerLotto() {
        randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
        List<Integer> playerLotto = new ArrayList<>(randomNumbers);
        Collections.sort(playerLotto);

        return playerLotto;
    }

    public List<Lotto> validateWinningLotto(String winningNumbers) {
        String[] winningNumbersArray = winningNumbers.split(comma);
        validateWinningLottoLength(winningNumbersArray);
        List<Integer> winningNumbersList = convertStringToInt(winningNumbersArray);
        winningLotto.add(new Lotto(winningNumbersList));

        return winningLotto;
    }

    private void validateWinningLottoLength(String[] winningNumbersArray) {
        if (winningNumbersArray.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private List<Integer> convertStringToInt(String[] winningNumbersArray) {
        List<Integer> winningNumbersList = new ArrayList<>();
        for (String winningNumber : winningNumbersArray) {
            winningNumbersList.add(Integer.parseInt(winningNumber));
        }
        return winningNumbersList;
    }


}
