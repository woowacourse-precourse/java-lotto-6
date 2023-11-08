package lotto.entity;

import lotto.service.HasDuplicateService;

import java.util.List;


public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (HasDuplicateService.hasDuplicates(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 값이 있습니다.");
        }

        this.numbers = numbers;
    }

}
