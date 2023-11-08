package lotto.model.lotto.publish;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;

//요구사항에서 Random 라이브러리 사용을 하라는 내용을 보지못해서 직접 만든 클래스
public class CustomRadomNumbersGeneratePolicy {
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != LottoConstant.SIZE) {
            final Integer newNumber = pickRandomNumber();
            updateNumbers(numbers, newNumber);
        }
        return numbers;
    }

    private void updateNumbers(List<Integer> numbers, final Integer newNumber) {
        if (!numbers.contains(newNumber)) {
            numbers.add(newNumber);
        }
    }

    private Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(
                LottoConstant.MIN_NUMBER,
                LottoConstant.MAX_NUMBER
        );
    }
}
