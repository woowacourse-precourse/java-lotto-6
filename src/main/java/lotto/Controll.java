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

public class Controll {
    enum SameNumber {
        SAME0(0),
        SAME3(3),
        SAME4(4),
        SAME5(5),
        SAME5BONUS(5),
        SAME6(6);

        private Integer sameNumber;

        SameNumber(Integer sameNumber) {
            if (sameNumber >= 0 && sameNumber < 3) {
                this.sameNumber = 0;
            }
            this.sameNumber = sameNumber;
        }

        static SameNumber fromInt(int value) {
            for (SameNumber number : SameNumber.values()) {
                if (number.sameNumber == value) {
                    return number;
                }
            }
            return SAME0;
        }

        static Integer toInteger(SameNumber sameNumber) {
            return sameNumber.sameNumber;
        }
    }

    enum Reward {
        REWARD0(0),
        REWARD3(5000),
        REWARD4(50000),
        REWARD5(1500000),
        REWARD5BONUS(30000000),
        REWARD6(2000000000);

        private Integer reward;

        Reward(Integer reward) {
            this.reward = reward;
        }

        Integer toInteger() {
            return this.reward;
        }

        static Integer fromSameNumber(SameNumber sameNumber) {
            if (sameNumber == SameNumber.SAME6) {
                return REWARD6.toInteger();
            }
            if (sameNumber == SameNumber.SAME5BONUS) {
                return REWARD5BONUS.toInteger();
            }
            if (sameNumber == SameNumber.SAME5) {
                return REWARD5.toInteger();
            }
            if (sameNumber == SameNumber.SAME4) {
                return REWARD4.toInteger();
            }
            if (sameNumber == SameNumber.SAME3) {
                return REWARD3.toInteger();
            }
            return REWARD0.toInteger();
        }
    }

    Lotto buyLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    Integer ticketsForMoney(Integer money) {
        return money / 1000;
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

    Map<SameNumber, Integer> countSameNumber(Lotto winner, Integer bonus, Lotto... tickets) {
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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