package lotto.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public String printLotto(){
        return numbers.toString();
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
    public Integer getMatchLottoNumbers(Lotto winningLotto){
        int cnt=0;
        for(int i=0; i<numbers.size();i++){
            if(winningLotto.getNumbers().contains(numbers.get(i)))
                cnt++;
        }
        return cnt;
    }

    public boolean getMatchNumber(Integer number){
        if(numbers.contains(number))
            return true;
        return false;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(); //입력값이 6개가 아닐 경우
        }

        //중복값 확인
        Set<Integer> checkSet = new HashSet<Integer>(numbers);
        List<Integer> newNumbers = new ArrayList<Integer>(checkSet);
        if(newNumbers.size() != 6)
            throw new IllegalArgumentException(); //중복값 존재할 경우
    }
}