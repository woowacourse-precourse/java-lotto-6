package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    static void emptyCheck(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 비어있지 않아야 합니다.");
        }
    }

    static void naturalNumberCheck(String raw) {
        try {
            if (Integer.parseInt(raw) <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 자연수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    static void nanCheck(String raw) {
        try {
            Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    static void devide1000Check(String raw) {
        try {
            if (Integer.parseInt(raw) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000 단위의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    static void inputMoneyExceptionCheck(String raw) {
        emptyCheck(raw);
        nanCheck(raw);
        naturalNumberCheck(raw);
        devide1000Check(raw);
    }

    static void ticketNumberDuplecationCheck(String raw) {
        List<Integer> numbers = Arrays.stream(raw.split(","))
                .map(Integer::parseInt)
                .toList();
        Set<Integer> set = new HashSet<>(numbers);
        Integer numbersSize = numbers.size();
        Integer setSize = set.size();
        if (numbersSize != setSize) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    static void commaCheck(String raw) {
        if (!raw.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)로 구분되야 합니다.");
        }
        if (raw.contains(",,")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 하나의 쉼표(,)로 구분되야 합니다.");
        }
        if (raw.startsWith(",") || raw.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)로 구분되야 합니다.");
        }
    }

    static void split6Check(String raw) {
        if (raw.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    static void range1to45Check(String raw) {
        for (String number : raw.split(",")) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void inputWinnerNumberExceptionCheck(String raw) {
        emptyCheck(raw);
        commaCheck(raw);
        split6Check(raw);
        range1to45Check(raw);
        ticketNumberDuplecationCheck(raw);
    }

    private static void bonusNumberDuplicationCheck(String raw, Lotto winnerTicket) {
        Integer bonusNumber = Integer.parseInt(raw);
        List<Integer> winnerTicketNumbers = winnerTicket.toList();
        if (winnerTicketNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 되지 않아야 합니다.");
        }
    }

    public static void inputBonusNumberExceptionCheck(String raw, Lotto winnerTicket) {
        emptyCheck(raw);
        nanCheck(raw);
        naturalNumberCheck(raw);
        range1to45Check(raw);
        bonusNumberDuplicationCheck(raw, winnerTicket);
    }
}
