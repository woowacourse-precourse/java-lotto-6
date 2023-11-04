package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public Validator(){}

    public void validateNumbersDuplicate(List<Integer> numbers){
        Set<Integer> numbersDuplicateCheck = new HashSet<>(numbers);
        if (numbersDuplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다. 다시 입력해주세요.");
        }
    }
}
