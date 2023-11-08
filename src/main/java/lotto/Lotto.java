package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        // 에러 체크 구현
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto createLotto() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(1,45,6);
        return new Lotto(randomNumbers);
    }

    public Lotto inputLotto() {
        // 당첨 번호 입력을 요구하는 출력문
        String[] input = readLine().split(",");
        List<Integer> inputLotto = new ArrayList<Integer>();

        for (String i : input) {
            inputLotto.add(Integer.parseInt(i));
        }
        // 에러체크기능 -> 테스트를 보니 생성자 내에서 이게 체크되어야 하는 것 같다
        return new Lotto(inputLotto);
    }

}
