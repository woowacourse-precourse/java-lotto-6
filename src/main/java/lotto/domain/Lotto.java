package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.Message;
import lotto.utils.Checker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Checker.validateSize(numbers, GameSetting.TICKET_SIZE.getValue());
        Checker.validateRange(numbers, GameSetting.START_NUMBER.getValue(), GameSetting.END_NUMBER.getValue());
        Checker.validateUnique(numbers);
    }

    public void evaluateWinning(List<Integer> winningNumbers,int winningBonus,List<Winning> winnings){
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        copiedNumbers.retainAll(winningNumbers);

        final int ticketMatch = copiedNumbers.size();
        final boolean ticketBonus = numbers.contains(winningBonus);

        for (int i = winnings.size() - 1; i >= 0; i--) {
            final boolean bonus = winnings.get(i).getBonus();
            final int match = winnings.get(i).getMatch();
            if(match == ticketMatch && bonus == ticketBonus || match == ticketMatch && !bonus){
                winnings.get(i).addTicketCount();
                break;
            }
        }
    }
}
