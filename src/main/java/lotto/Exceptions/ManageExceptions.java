package lotto.Exceptions;

import java.util.ArrayList;
import java.util.List;

public class ManageExceptions {
    public void cashCheck(int cash){
        if (cash % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천 원 단위여야 합니다.");
        }
    }

    public void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void rangeCheck(int num){
        if (num < 1 || 45 < num) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void duplicationCheck(List<Integer> numbers){
        if (numbers.stream().distinct().count() < numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 선택할 수 없습니다.");
        }
    }
}
