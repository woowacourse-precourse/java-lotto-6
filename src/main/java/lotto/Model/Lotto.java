package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        this.numbers = numbers;
    }

    private boolean size_check(List<Integer> numbers) {
        try{
            if (numbers.size() == 6) {
                return true;
            }
            throw new IllegalArgumentException();
        }catch (Exception e){
            System.out.println("[ERROR] 로또 번호는 6개의 수를 입력해주세요.");
            return false;
        }

    }

    private boolean number_check(int number){
        try{
            if (number >= 1 && number <= 45){
                return true;
            }
            throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호 1부터 45까지의 수로 입력해주세요.");
            return false;
        }
    }

    private boolean duplication_check(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        try{
            if (set.size() == 6){
                return true;
            }
            throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 수는 중복 없이 입력해주세요.");
            return false;
        }

    }

}
