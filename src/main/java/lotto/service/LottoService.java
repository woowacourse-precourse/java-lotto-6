package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;

public class LottoService {
    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int winsCount;

    /* Constant */
    private final Integer LOTTO_SIZE = 6;

    public LottoService() {
        lottos = new ArrayList<>();
        winningNumbers = new ArrayList<>();
    }

    public void addRandomLotto(Integer lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = getRandomNumbers();
            sortNumbers(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
        }
    }

    public void addWiningNumbers() {
        String input = InputView.getUserInput();
        String[] strings = input.split(",");

        for (String str : strings) {
            winningNumbers.add(Integer.parseInt(str));
        }
    }

    public void getBonusNumber() {
        bonusNumber = Integer.parseInt(InputView.getUserInput());
    }

    public void calculateLottoWinningNumbers() {
        for (Lotto lotto : lottos) {
            checkWinsCount(lotto);
        }
    }

    private void isSame(int num, int winningNum) {
        if (num == winningNum) {
            winsCount++;
        }
    }

    private void checkWinsCount(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < winningNumbers.size(); j++) {
                isSame(numbers.get(i), winningNumbers.get(j));
            }
        }
    }

    private List<Integer> getRandomNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
