package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Service.ValidateService;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateAndSortNumbers(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private List<Integer> validateAndSortNumbers(List<Integer> numbers){
        ValidateService validateService = ValidateService.getInstance();

        validateService.checkSixLength(numbers);
        validateService.checkDuplicateNumber(numbers);

        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

}
