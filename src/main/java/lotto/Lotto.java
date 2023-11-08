package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != Application.minLOTTOCOUNT) { //로또 입력 유효성확인..+근데 여기서 에러가 나는것같다..
            throw new IllegalArgumentException("[ERROR]로또번호는 6개 여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR]로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
        // 중복 번호가 있는지 검사
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR]로또 번호는 중복될 수 없습니다.");
        }
    }
    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }

    public int countMatch(List<Integer> winnigNumbers) { //정답입력받는 함수
        Set<Integer>matchNumbers = new HashSet<>(numbers);
        matchNumbers.retainAll(winnigNumbers);
        return matchNumbers.size();
    }
    public boolean bonusMatch(int bonusNumber){ //보너스 여부 확인
        return numbers.contains(bonusNumber);
    }
}
