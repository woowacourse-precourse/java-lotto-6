package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            addNumbers(numbers);
        }
        return numbers;
    }

    private static void addNumbers(List<Integer> numbers) {
        int lottoNumber = Randoms.pickNumberInRange(1, 45);
        if(!numbers.contains(lottoNumber)) {
            numbers.add(lottoNumber);
        }
    }
}
