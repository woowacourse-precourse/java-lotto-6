package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 길이가 6이 아닐 때
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개의 값을 입력하세요.");
            throw new IllegalArgumentException();
        }
        // 중복 값이 존재할 때
        Collections.sort(numbers);
        if(validate_dupli(numbers)){
            System.out.println("[ERROR] 중복값이 존재 하지 않도록 입력하세요.");
            throw new IllegalArgumentException();
        }
    }

    // 중복값 확인 함수
    private boolean validate_dupli(List<Integer> numbers){
        boolean res = false;
        int before = numbers.get(0);
        for(int i=1;i<numbers.size();i++){
            if(before == numbers.get(i)){
                res = true;
                break;
            }
            before = numbers.get(i);
        }
        return res;
    }

    //로또 번호 출력
    public void print_numbers(){
        System.out.println(this.numbers);
    }

}
