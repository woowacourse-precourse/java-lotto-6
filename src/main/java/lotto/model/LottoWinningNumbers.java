package lotto.model;

import static lotto.util.Division.COMMA;
import static lotto.util.Utils.conversionInt;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {

    private final Lotto lotto;

    public LottoWinningNumbers(String inNumbers) {
        List<Integer> numbers = conversionCommaNumber(inNumbers);

        this.lotto = new Lotto(numbers);
    }

    /**
     * Comma를 기준으로 숫자를 나누어 반환
     *
     * @param input ','를 포함한 숫자
     * @return List<Integer>
     */
    private List<Integer> conversionCommaNumber(String input) {
        String[] splitText = input.split(COMMA);
        List<Integer> numbers = new ArrayList<>();

        for (String number :
                splitText) {
            numbers.add(conversionInt(number));
        }

        return numbers;
    }

}
