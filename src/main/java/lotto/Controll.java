package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
}