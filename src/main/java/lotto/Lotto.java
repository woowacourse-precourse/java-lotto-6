package lotto;

import util.ErroerMessage;
import util.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicationCheck(numbers);
        rangeCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
        }
    }
    private void duplicationCheck(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (numbers.size() != checkNumbers.size()) throw new IllegalArgumentException(ErroerMessage.DUPLICATION_ERROR);
    }

    private void rangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if ((number > 46) || (number < 1)) throw new IllegalArgumentException(ErroerMessage.RANGE_ERROR);
        }
    }
    // TODO: 추가 기능 구현
    public static Lotto createLotto() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(1,45,6);
        return new Lotto(randomNumbers);
    }

    public static Lotto inputLotto() {
        InputView.printUserInputLotto();
        String[] input = readLine().split(",");
        List<Integer> inputLotto = new ArrayList<Integer>();

        for (String i : input) {
            inputLotto.add(Integer.parseInt(i));
        }
        return new Lotto(inputLotto);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
