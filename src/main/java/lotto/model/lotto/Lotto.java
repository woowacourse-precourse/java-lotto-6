package lotto.model.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.model.validator.InputValidator.lottoMakesSixNumbers;
import static lotto.model.validator.InputValidator.lottoMustBeUniqueNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoMakesSixNumbers(numbers);
        lottoMustBeUniqueNumber(numbers);
        List<Integer> ticket = new ArrayList<>(numbers);
        ticket.sort(Comparator.naturalOrder());
        this.numbers = ticket;
    }

    public int countSameNumber(WinningNumber winningNumber){
        int count = 0;
        for(int i=0; i<6; i++){
            if(winningNumber.answer.numbers.contains(numbers.get(i))){
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberDuplicatedWithWinningNumber(int bonusNumber){
        return IntStream.range(0, numbers.size())
                .anyMatch(i -> numbers.get(i) == bonusNumber);
    }

    @Override
    public boolean equals(Object obj){
        Lotto lotto = (Lotto) obj;
        return IntStream.range(0, 6).allMatch(i-> numbers.get(i).equals(lotto.numbers.get(i)));
    }

    public boolean isHitBonusNumber(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

    public String getTicketContent() {
        return String.format("[%d, %d, %d, %d, %d, %d]",
                numbers.get(0), numbers.get(1), numbers.get(2),
                numbers.get(3), numbers.get(4), numbers.get(5));
    }
}
