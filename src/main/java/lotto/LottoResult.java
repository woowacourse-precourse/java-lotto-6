package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final List<Integer> resultNumbers;
    private final int bonusNumber;

    public LottoResult(String resultNumbers, String bonusNumber) {
        this.resultNumbers = convertToIntegerList(resultNumbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private List<Integer> convertToIntegerList(String resultNumbers) {
        String[] numbers = resultNumbers.split(",");
        List<Integer> list = new ArrayList<>();

        for (String number : numbers) {
            list.add(Integer.parseInt(number.trim()));
        }
        return list;
    }

    public int containResultNumbers(int number) {
        if (resultNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean hasBonusNumber(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
