package model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        sortLotto(numbers);
        this.numbers = numbers;
    }

    public int checkMatch(List<Integer> prizeNumber){
        int count = 0;
        for(int number : prizeNumber){
           if(numbers.contains(number)){ //이 로또가 정답을 갖고있다면
                count++;
           }
       }
        return count;
    }
    public boolean checkBonus(int bounsNumber){
        return numbers.contains(bounsNumber);
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입력해야 합니다.");
        }
    }

    public static void duplicateCheck(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    @Override
    public String toString(){
        return String.format(numbers.toString());
    }
    void sortLotto(List<Integer> numbers){
        numbers.sort(Comparator.naturalOrder());
    }
}
