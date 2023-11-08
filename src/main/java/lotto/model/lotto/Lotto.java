package lotto.model.lotto;

import static lotto.model.constants.IntegerConstant.*;
import static lotto.model.constants.StringConstant.*;
import static lotto.validator.Validator.*;

import java.util.*;
import java.util.stream.IntStream;

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
        return (int) IntStream.range(ZERO.get(), SIZE_OF_LOTTO.get())
                .filter(index -> winningNumber.isContainNumber(numbers.get(index)))
                .count();
    }

    public boolean isContainNumber(int number){
        return numbers.contains(number);
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
