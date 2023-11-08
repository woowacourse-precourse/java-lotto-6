package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {

    public List<Integer> numbers;

    public UserLotto(List<Integer> numbers) {
        sortNumber(numbers);
        this.numbers = numbers;
    }

    public void sortNumber(List<Integer> numbers){
        for (int i=0; i<numbers.size(); i++){
            for (int j=0; j<numbers.size()-1-i; j++){
                check(numbers, j);
            }
        }
    }

    public void check(List<Integer> numbers, int j){
        int left = numbers.get(j);
        int right = numbers.get(j+1);

        if (left > right){
            int tmp = left;
            numbers.add(j, right);
            numbers.remove(j+1);
            numbers.add(j+1, left);
            numbers.remove(j+2);
        }
    }
}
