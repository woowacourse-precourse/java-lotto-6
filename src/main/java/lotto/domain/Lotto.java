package lotto.domain;

import lotto.dto.AnswerLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE){
            throw new IllegalArgumentException("로또 번호들은 중복 될 수 없습니다.");
        }

    }

    public Rank calculateLottoWinnings(AnswerLotto answerLotto){
        List<Integer> answerNumbers = answerLotto.getAnswerNumbers();
        int bonusNumber = answerLotto.getBonusNumber();
        int matchedNumber = 0;
        boolean hasBonusNumber = false;

        for(int i=0; i<LOTTO_NUMBERS_SIZE; i++){
            for(int j=0; j<LOTTO_NUMBERS_SIZE; j++){
                if(numbers.get(i) == answerNumbers.get(j)){
                    matchedNumber++;
                }
            }
        }

        if(matchedNumber == 5){
            hasBonusNumber = numbers.stream()
                    .anyMatch(number -> number == bonusNumber);
        }
        return Rank.findRankByMatchedNBonusNumber(matchedNumber, hasBonusNumber);
    }

    public List<Integer> getNumbers() { //메소드 확인용 지워야됨
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
