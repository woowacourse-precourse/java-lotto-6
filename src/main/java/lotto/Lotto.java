package lotto;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateCheck(List<Integer> numbers){        
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if(lottoNumbers.size() != numbers.size()){
            System.out.println("[ERROR] 당첨 번호에 중복된 숫자는 허용하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public int LottoCheck(List<Integer> mylotto, int bonusNumber){
        int count = 0;

        for(int mynumber : mylotto){
            if (numbers.contains(mynumber))
                count++;
        }

        if (mylotto.contains(bonusNumber))
            count += 10;
            
        return count;
    }
}
