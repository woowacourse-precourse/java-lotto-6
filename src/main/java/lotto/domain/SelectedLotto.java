package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.util.LottoValidator;

public class SelectedLotto {
    //private String InputNumbers = "";
    // private String InputBonus = "";
    private List<String> numbers;
    private final List<Integer> selectedNumbers;
    private final Integer selectedBonus;
    private final LottoValidator validator = new LottoValidator();

    public SelectedLotto(String nums, String bonus) {
        makeSplittedNumbers(nums);
        validator.lottoNumbers(numbers);
        validator.bonusNumber(bonus, numbers);
        //InputNumbers = nums;
        //InputBonus = bonus;
        selectedNumbers = convertNums();
        selectedBonus = Integer.valueOf(bonus);
    }

    private void makeSplittedNumbers(String InputNumbers) {
        numbers = Arrays.asList(InputNumbers.split(",", -1));
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, numbers.get(i).trim());
        }

    }

    private List<Integer> convertNums() {
        List<Integer> converting = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            Integer converted = Integer.valueOf(numbers.get(i));
            converting.add(converted);
        }
        return List.copyOf(converting);

    }

    public List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }

    public Integer getBonus() {
        return selectedBonus;
    }


}
