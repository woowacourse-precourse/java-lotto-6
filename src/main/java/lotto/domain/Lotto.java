package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (!numbers.equals(numbers.stream().distinct().collect(Collectors.toList()))) {
            throw new IllegalArgumentException();
        }
    }

    public String decideResult(List<Integer> answer,int bonusNumber){
        long count = numbers.stream()
                .filter(num->answer.contains(num))
                .count();

        boolean includeBonus = numbers.contains(bonusNumber);

        if(count == 6){return "1등";}
        if(count == 5 & includeBonus){return "2등";}
        if(count == 5){return "3등";}
        if(count == 4){return "4등";}
        if(count == 3){return "5등";}
        return "꽝";
    }


}
