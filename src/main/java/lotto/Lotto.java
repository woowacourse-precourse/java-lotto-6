package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        redundancyCheck(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 정확하게 6개의 숫자가 입력되어야 합니다.");
        }
    }

    private void redundancyCheck(List<Integer> numbers){
        List<Integer> check = numbers.stream().distinct().collect(Collectors.toList());
        try {
            validate(check);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자는 모두 달라야 합니다.");
        }
    }

    public boolean numberCheck(int target){
        if (numbers.contains(target)){
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}

enum LottoRank{
    FIRST("2,000,000,000"), SECOND("30,000,000"), 
    THIRD("1,500,000"), FOURTH("50,000"), FIFTH("5,000")
    
    final private String prize;
    LottoRank(String prize) {
		this.prize = prize;
	}
	
	String getPrize() {
		return prize;
	}
}
