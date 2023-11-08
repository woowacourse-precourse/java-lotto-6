package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }

    }

    // TODO: 추가 기능 구현

    public static List<Integer> randomNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers;
    }

    public static void startLotto(int numberOfLotto) {
        List<Lotto> lottos = createLotto(numberOfLotto);
        printLotto(lottos);

        List<Integer> winningNumbers = WinningNumber.inputWinningNumber();
        int bonusNumber = WinningNumber.inputBonusNumber(winningNumbers);
        WinningNumber.compareToLotto(lottos, winningNumbers, bonusNumber);
    }

    public static List<Lotto> createLotto(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lotto = Lotto.randomNumber();
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> sortedList = new ArrayList<>(lotto.numbers);
            sortedList.sort(Comparator.naturalOrder());
            System.out.println(sortedList);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
