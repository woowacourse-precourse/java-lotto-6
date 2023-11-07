package lotto;

import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    //numbers 수정X
    //필드추가 ㅇㅋ

    private int bonusNumber;


    //생성자로 초기화 List 넣자마자 작동 로또넘버를 입력받음.
    public Lotto(List<Integer> numbers) {
        validateDuplicate(numbers);
        validate(numbers);
        this.numbers = numbers;
    }
    //numbers의 리스트 검증부
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // 중복값 검증부 제작 필요
    //https://doing7.tistory.com/145 참고 set 혹은 stream.distinct()이용
    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> checkDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() != checkDuplicateNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }
    public void buyLottoes(int moneys){

    }

    private void pickRandomNumbers(int moneys){
//        numbers = Randoms.pickUniqueNumbersInRange(1,45,6);

    }


}
