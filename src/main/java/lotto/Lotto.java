package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요");
        }
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if(uniqueNumber.size() != numbers.size()){
            throw new IllegalArgumentException("중복된 로또번호가 있습니다.");
        }
        for(Integer number : numbers){
            isNumberOverBoundary(number);
        }
    }
    private void isNumberOverBoundary(Integer number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public void contains(int number){
        List<Integer> list = getNumbers();
        for(int listNum : list){
            if(listNum == number){
                throw new IllegalArgumentException("중복된 숫자입니다.");
            }
        }
    }
    public boolean contain(int number){
        List<Integer> list = getNumbers();
        for(int listNum : list){
            if(listNum == number){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return numbers.toString();
    }
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers); // 불변성을 유지하기 위해 새 리스트를 반환
    }
    // TODO: 추가 기능 구현
}
