package lotto.domain;
//lottoNumberList 받아와 관리
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ExceptionMessage;

public class Lotto {

    private  final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRange(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getLottoNumbers() {
        return numbers;
    }


    public int countMatch(Lotto  winningLotto) {
        return (int) numbers.stream().filter(LottoWinner::containNumber).
                count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }




    //validate:유효성 검사 컨벤션->예외처리 진행
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    private void validateOverlap(List<Integer> numbers){
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            overlapCheck.add(numbers.get(i));
        }
        if (overlapCheck.size() != 6){
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }



    public void validateRange(List<Integer> numbers) {
        for (int winningNumber = 0;winningNumber < numbers.size(); winningNumber++) {
            if (numbers.get(winningNumber) < 1 || numbers.get(winningNumber)>45){
                ExceptionMessage.naturalException();
                throw new IllegalArgumentException();
            }
        }
    }



    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }
}
