package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Control {
    Lotto buyLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_NUMBER_MIN.toInt(),
                Constants.LOTTO_NUMBER_MAX.toInt(),
                Constants.LOTTO_NUMBER_COUNT.toInt()));
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    int ticketsForMoney(Long money) {
        return (int) (money / Constants.MONEY_PER_TICKET.toInt());
    }

    long moneyForTickets(Integer ticketCount) {
        return (long) ticketCount * Constants.MONEY_PER_TICKET.toInt();
    }

    SameNumber compareTicket(Lotto winner, Lotto ticket) {
        Integer count = (int) Stream.concat(winner.toList().stream(), ticket.toList().stream())
                .filter(num -> winner.toList().contains(num) && ticket.toList().contains(num))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .count();
        return SameNumber.fromInt(count);
    }

    Integer compareBonus(Lotto ticket, Integer bonus) {
        return (int) Stream.concat(Arrays.asList(bonus).stream(), ticket.toList().stream())
                .filter(num -> Arrays.asList(bonus).contains(num) && ticket.toList().contains(num))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .count();
    }

    Map<SameNumber, Integer> getCompareResult(Lotto winner, Integer bonus, Lotto... tickets) {
        Map<SameNumber, Integer> sameNumberCount = new HashMap<>();
        for (Lotto ticket : tickets) {
            SameNumber sameNumber = compareTicket(winner, ticket);
            Integer bonusNumber = compareBonus(ticket, bonus);
            if (sameNumber == SameNumber.SAME5 && bonusNumber == 1) {
                sameNumber = SameNumber.SAME5BONUS;
            }
            if (sameNumberCount.containsKey(sameNumber)) {
                Integer count = sameNumberCount.get(sameNumber);
                sameNumberCount.replace(sameNumber, count + 1);
                continue;
            }
            sameNumberCount.put(sameNumber, 1);
        }
        return sameNumberCount;
    }

    Integer getTicketCountWithInputMoney() {
        Integer ticketCount = null;
        while (ticketCount == null) {
            try {
                ticketCount = ticketsForMoney(Input.inputMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_MESSAGE_HEADER + e.getMessage());
            }
        }
        return ticketCount;
    }

    Lotto getInputWinnerNumber() {
        Lotto winnerTicket = null;
        while (winnerTicket == null) {
            try {
                winnerTicket = Input.inputWinnerNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_MESSAGE_HEADER + e.getMessage());
            }
        }
        return winnerTicket;
    }

    Integer getInputBonusNumber(Lotto winnerTicket) {
        Integer bunusNumber = null;
        while (bunusNumber == null) {
            try {
                bunusNumber = Input.inputBonusNumber(winnerTicket);
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_MESSAGE_HEADER + e.getMessage());
            }
        }
        return bunusNumber;
    }

    public void start() {
        Output.printInputMoney();
        Integer ticketCount = getTicketCountWithInputMoney();
        Lotto[] tickets = new Lotto[ticketCount];
        for (int i = 0; i < ticketCount; i++) {
            tickets[i] = buyLotto();
        }
        Output.printTicketsBought(tickets);
        Output.printInputWinnerNumber();
        Lotto winnerTicket = getInputWinnerNumber();
        Output.printInputBonusNumber();
        Integer bonusNumber = getInputBonusNumber(winnerTicket);
        Output.printStatistic(winnerTicket, bonusNumber, tickets);
    }
}