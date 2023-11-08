package lotto.domain;

import java.util.List;

public class Lotto {
    private static final Integer LOTTO_SIZE = 6;
    private static final Rank DEFAULT_RANK = Rank.NONE;
    private static final String EXCEED_LOTTO_SIZE = "[ERROR] 6개의 정수를 입력하세요";
    private static final String DUPLICATE_NUMBER_EXISTS = "[ERROR] 숫자들을 중복없이 입력해주세요.";
    private List<Integer> numbers;

    private Rank rank;

    public Lotto(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
        this.rank = DEFAULT_RANK;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public Rank getRank(){
        return rank;
    }

    public void setRank(Rank rank){
        this.rank = rank;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) throw new IllegalArgumentException(EXCEED_LOTTO_SIZE);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != distinctNumbers.size()) throw new IllegalArgumentException(DUPLICATE_NUMBER_EXISTS);
    }
}
