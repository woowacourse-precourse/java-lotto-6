package lotto.model.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.model.constants.IntegerConstants.*;
import static lotto.model.constants.StringConstants.*;
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
        for(int i=0; i<SIZE_OF_LOTTO.get(); i++){
            if(winningNumber.answer.numbers.contains(numbers.get(i))){
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberDuplicatedWithWinningNumber(int bonusNumber){
        return IntStream.range(ZERO.get(), numbers.size())
                .anyMatch(i -> numbers.get(i) == bonusNumber);
    }

    public boolean isHitBonusNumber(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    public String getTicketContent() {
        StringBuilder ticket = new StringBuilder();
        IntStream.range(ZERO.get(), SIZE_OF_LOTTO.get()).
                forEach(i -> ticket.append(numbers.get(i)).append(COMMA_WITH_BLANK.get()));
        ticket.setLength(ticket.length() - TWO.get());
        return TICKET_CONTENT_START.get() + ticket + TICKET_CONTENT_END.get();
    }

    @Override
    public boolean equals(Object obj){
        Lotto lotto = (Lotto) obj;
        return IntStream.range(ZERO.get(), SIZE_OF_LOTTO.get())
                .allMatch(i-> numbers.get(i).equals(lotto.numbers.get(i)));
    }
}
