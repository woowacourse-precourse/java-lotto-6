package lotto;

import java.util.List;

import static model.FixedValues.*;

public class Lotto {
	
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
    	CREATOR.validator_lotto(numbers);
    }

    public List<Integer> getLottoNumbers() {
    	return this.numbers;
    }
}
