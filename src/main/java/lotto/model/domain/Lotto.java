package lotto.model.domain;

import static lotto.constant.StateType.UNDEFINED;

import java.util.List;
import lotto.constant.StateType;

public class Lotto {
    private final List<Integer> numbers;
    private StateType stateType;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.stateType = UNDEFINED;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }
}
