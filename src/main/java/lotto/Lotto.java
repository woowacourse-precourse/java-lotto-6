package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static int LOTTO_NUMBER = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public static List<Integer> auto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> lottoNumbers;
        for (int i = 0; i < numberOfLottos; i++) {
            lottoNumbers = Lotto.auto();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    public int checkLotto(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> intersectionNumbers = new ArrayList<>(this.numbers);
        intersectionNumbers.retainAll(winningNumbers);
        int commonNumber = intersectionNumbers.size();

        if (commonNumber==6) {
            return 1;
        }
        if (commonNumber == 5 && winningNumbers.contains(Integer.valueOf(bonusNumber))) {
            return 2;
        } else if (commonNumber >= 3) {
            return 8 - commonNumber;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
