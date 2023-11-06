package lotto.domain;

import java.util.List;

public class Judge {
    //상수(static final) 또는 클래스 변수

    //인스턴스 변수

    //생성자

    //메서드
    public void compareLottery(List<Lotto> Lottos, List<Integer> winningNumbers) {
        //Lotto객체를 담고있는 List배열과 winningNumbers의 list를 비교함
        //5개가 일치한다면, 보너스 번호와 비교
    }

    public int compareWinningNumber() {
        int countMatchingNumber = 0;
        // 몇개의 번호가 일치하는지 비교하는 코드 구현
        return countMatchingNumber;
    }

    public void compareBonusNumber() {
        // 보너스 번호와 일치하는지 비교하는 코드 구현
    }

}
