package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

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
        String[] userInputWinningNumbers = winningNumbers.split(comma);
        List<Integer>  winningNumber = convertStringToInt(userInputWinningNumbers);
        winningLotto.add(new Lotto(winningNumber));

        return winningLotto;
    }

    private List<Integer> convertStringToInt(String[] winningNumbers) {
        List<Integer> userInputWinningNumber = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            userInputWinningNumber.add(Integer.parseInt(winningNumber));
        }
        return userInputWinningNumber;
    }


}
