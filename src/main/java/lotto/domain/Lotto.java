package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.LottoGenerator;
import lotto.controller.dto.LottoResponseDto;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoResponseDto toResponseDto(){
        sort();
        return new LottoResponseDto(numbers);
    }

    public int countContainsNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isContain)
                .count();
    }

    public boolean isContain(int lottoNumber){
        return numbers.contains(lottoNumber);
    }

    private void sort(){
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplicated(numbers);
        validateNumbersInRange(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또번호의 값이 6자리가 아닙니다.");
        }
    }

    private void validateNumbersDuplicated(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또번호가 있습니다.");
        }
    }

    private void validateNumbersInRange(List<Integer> numbers){
        for (Integer num : numbers) {
            if (num < LottoGenerator.LOTTO_START_INCLUSIVE || num > LottoGenerator.LOTTO_END_INCLUSIVE) {
                throw new IllegalArgumentException("[ERROR] 로또번호는 1부터 45까지의 값을 가져야 합니다.");
            }
        }
    }
}
