package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto makeLottoWithRandomNumbers(){
        Set<Integer> lottoes = new HashSet<>();
        while(lottoes.size() != 6){
            lottoes.add(Randoms.pickNumberInRange(1, 45));
        }
        return new Lotto(lottoes.stream().sorted().collect(Collectors.toList()));
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public RESULT countResult(List<Integer> selectedNumbers, int bonusNumber){
        boolean hitBonus = false;
        int matchedCount = (int) this.numbers.stream()
                .filter(number -> selectedNumbers.contains(number)).count();
        if(matchedCount != 5){
            return findResult(matchedCount);
        }
        hitBonus = this.numbers.stream().anyMatch(number -> number.equals(bonusNumber));
        if(hitBonus) return RESULT.FIVE_STRIKE_AND_BONUS;
        return RESULT.FIVE_STRIKE;
    }

    private RESULT findResult(int number){
        if(number < 3) return RESULT.NONE;
        if(number == 3) return RESULT.THREE_STRIKE;
        if(number == 4) return RESULT.FOUR_STRIKE;
        if(number == 6) return RESULT.SIX_STRIKE;
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 정답 개수입니다.");
    }
}
