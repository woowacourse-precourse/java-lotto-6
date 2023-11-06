package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) { //입력받은 당첨번호 유효성 검사. 6개인지, 1-45사이인지, 숫자인지
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> compare(List<List<Integer>> myLotto, int bonus) { //당첨번호와 발행된 로또 비교하여 당첨내역 반환
    	List<Integer> result = new ArrayList<>(5);
    	return result;
    }
    
    public double rateOfReturn(List<Integer> result, int purchase) { //수익률 계산해서 반환
    	return 0.1;
    }
}
