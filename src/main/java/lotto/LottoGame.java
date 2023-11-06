package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    List<Lotto> lottos;
    Lotto winningNumber;
    Integer bonusNumber;

    public LottoGame() {
        this.lottos = new ArrayList<>();
    }


    public void buy(int quantity) {
        for (int q = 0; q < quantity; q++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<List<Integer>> getLottos() {
        List<List<Integer>> lottosNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            lottosNumbers.add(numbers);
        }
        return lottosNumbers;
    }

    public void setWinningNumber(String[] numbers) {
        List<Integer> winningNumber = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
        this.winningNumber = new Lotto(winningNumber);
    }

    public void setBonusNumber(String number) {
        this.bonusNumber = Integer.parseInt(number);
    }
}
