package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.util.LottoValidator;

public class SelectedLotto {
    private String InputNumbers = "";
    private String InputBonus = "";
    private List<String> numbers;
    private LottoValidator validator = new LottoValidator();

    public SelectedLotto(String nums, String bonus) {
        makeNumbers(nums);
        validator.lottoNumbers(numbers);
        validator.bonusNumber(bonus, numbers);
        InputNumbers = nums;
        InputBonus = bonus;
    }

    private void makeNumbers(String InputNumbers) {
        numbers = Arrays.asList(InputNumbers.split(",", -1));
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, numbers.get(i).trim());
        }

    }

}
