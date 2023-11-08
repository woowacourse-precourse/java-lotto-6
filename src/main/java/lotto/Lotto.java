package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Lotto {
    private List<Integer> numbers;
    private Integer winCount = 0;
    private Integer winBonusCount = 0;

    private String lottoId;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개 숫자를 입력해주세요");
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            System.out.println("[ERROR] 로또번호 중복!!");
            throw new IllegalArgumentException();
        }

    }

    // TODO: 추가 기능 구현
    public int compareWinNumbers(List<Integer> winNumbers) {
        for (Integer winNumber: winNumbers) {
            if(this.numbers.contains(winNumber)) this.winCount++;
        }
        return this.winCount;
    }

    public int compareWinBonusNumber(Integer winBonusNumber){
        if(this.numbers.contains(winBonusNumber)) {
            this.winBonusCount++;
        }
        return this.winBonusCount;
    }

    public String getLottoId() {
        if(this.winCount == 5 && this.winBonusCount == 1){
            return this.winCount+"bonus"+this.winBonusCount.toString();
        }else{
            return this.winCount.toString();
        }
    }

    @Override
    public String toString() {
        return this.numbers.toString() ;
    }
}
