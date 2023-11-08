package lotto;

import java.util.List;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class Bonus {
    private int number;
    Bonus(List<Integer> number, List<Integer> numbers){
        checkOnlyOne(number);
        checkOverlap(numbers, number.get(0));
        lottoInRange(number.get(0));
        this.number = number.get(0);
    }

    private void checkOnlyOne(List<Integer> number){
        if(number.size() > 1) throw new IllegalArgumentException("보너스 번호를 1개만 입력해주세요.");
    }
    private void checkOverlap(List<Integer> numbers, int num){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == num) throw new IllegalArgumentException("보너스 번호는 중복될 수 없습니다.");
        }
    }

    private void lottoInRange(int num){
        if(num < 1 || num > 45) throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
