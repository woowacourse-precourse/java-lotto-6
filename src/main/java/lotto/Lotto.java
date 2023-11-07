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

    //https://doing7.tistory.com/145 참고 set 혹은 stream.distinct()이용
    // 중복값 검증부 제작
    private void validateDuplicate(List<Integer> numbers) {
        //형변환
        Set<Integer> checkDuplicateNumbers = new HashSet<>(numbers);
        // != 연산부분 포장해서 true값으로 작업할것?
        if (numbers.size() != checkDuplicateNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void setBonusNumber(int bonusNumber) {
        validateInRangebBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateInRangebBonusNumber(int bonusNumber) {
        // 포장필요 magicnumbers
        if (bonusNumber < MagicNumbers.CHECK_NUMBER_ONE.getMagicNumbers()) {
            throw new IllegalArgumentException();
        }
        if (MagicNumbers.CHECK_NUMBER_FOURTYFIVE.getMagicNumbers() < bonusNumber) {
            throw new IllegalArgumentException();
        }
    }

    public int buyLottoTickets(int moneys) {
        // != 연산부분 포장해서 true값으로 작업할것?
        if (moneys % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        int tickets;
        return tickets = moneys/1000;
    }

    //리팩토링 필요
    public Set<Integer> pickRandoms() {
        Set<Integer> pickRandomnumbers = new HashSet<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return pickRandomnumbers;

    }


}
