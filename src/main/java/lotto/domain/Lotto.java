package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }
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

    public RankingStatus decideResult(List<Integer> answer,int bonusNumber){
        long count = numbers.stream()
                .filter(num->answer.contains(num))
                .count();

        boolean includeBonus = numbers.contains(bonusNumber);

        if(count == 6){return RankingStatus.FIRST_RANK;}
        if(count == 5 & includeBonus){return RankingStatus.SECOND_RANK;}
        if(count == 5){return RankingStatus.THIRD_RANK;}
        if(count == 4){return RankingStatus.FORTH_RANK;}
        if(count == 3){return RankingStatus.FIFTH_RANK;}
        return RankingStatus.BOOM;
    }


}
