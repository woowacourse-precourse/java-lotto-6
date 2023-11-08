package lotto;

import lotto.result.Result;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkNumber(){
        try{
            validate(numbers);
            return true;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자는 6개를 입력해주세요.");
        }
    }

    public boolean checkOverlap(){
        Set<Integer> check = new HashSet<>();
        for(int num : numbers){
            if(check.contains(num)) throw new IllegalArgumentException("[ERROR] 중복된 숫자는 허용되지 않습니다!");
            check.add(num);
        }
        return true;
    }

    public boolean isContains(int num){
        return numbers.contains(num);
    }

    public Result checkPrize(Lotto prize, int bonus){
        int numChk = 0;
        for(int num : numbers){
            if(prize.isContains(num)) numChk ++;
        }
        return new Result(numChk,numbers.contains(bonus));
    }

    private List<Integer> getNumbers(){
        return numbers;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Iterator<Integer> iterator =  numbers.iterator();

        while(iterator.hasNext()){
            sb.append(iterator.next());
            if(iterator.hasNext()) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
    // TODO: 추가 기능 구현
}
