package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
public class PickLotto {
    private List<Integer> numbers;

    public PickLotto() {
        this.numbers = pickNum();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> pickNum(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
