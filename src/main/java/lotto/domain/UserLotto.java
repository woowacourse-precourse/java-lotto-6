package lotto.domain;

import java.util.List;

// 유저가 구입한 로또 번호가 담긴 클래스
public class UserLotto {
    private List<Integer> numbers;

    public UserLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
}
