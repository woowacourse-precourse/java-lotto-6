package lotto;

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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public void checkInputCarNameDuplication(List<Integer> numbers){
        Set<String> set = new HashSet<>(); //HashSet은 중복을 허용하지 않는 것을 이용
        for (int item : numbers){
            if (!set.add(Integer.toString(item))){ //HashSet에 add하려는 값이 이미 있으면 false 반환
                System.out.println("[ERROR] 숫자가 중복됩니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void printNumbers(){
        System.out.println(numbers.toString());
    }


    public void inputNumberDuplicate(int input){ //입력받은 보너스 번호가 중복되는지
        if(numbers.contains(input)){
            System.out.println("[ERROR] 보너스 번호가 중복 됩니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> returnNumbers(){
        return numbers;
    }



}
