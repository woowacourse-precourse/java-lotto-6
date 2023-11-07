package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    static void emptyCheck(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("구입금액은 비어있지 않아야 합니다.");
        }
    }

    static void naturalNumberCheck(String raw) {
        try {
            if (Long.parseLong(raw) <= 0) {
                throw new IllegalArgumentException("구입금액은 자연수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다.");
        }
    }

    static void nanCheck(String raw) {
        try {
            Long.parseLong(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다.");
        }
    }

    static void devide1000Check(String raw) {
        try {
            if (Long.parseLong(raw) % Constants.MONEY_PER_TICKET.toInt() != 0) {
                throw new IllegalArgumentException("구입금액은 " + Constants.MONEY_PER_TICKET.toInt() + " 단위의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다.");
        }
    }

    static void rangeCheck(String raw) {
        try {
            if (Long.parseLong(raw) > Constants.MAX_MONEY.toLong()) {
                throw new IllegalArgumentException(
                        "구입금액은 " + Constants.MAX_MONEY.toLong() + "보다 작아야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다.");
        }
    }

    static void inputMoneyExceptionCheck(String raw) {
        emptyCheck(raw);
        nanCheck(raw);
        naturalNumberCheck(raw);
        devide1000Check(raw);
        rangeCheck(raw);
    }

    static void ticketNumberDuplecationCheck(String raw) {
        List<Integer> numbers = Arrays.stream(raw.split(","))
                .map(Integer::parseInt)
                .toList();
        Set<Integer> set = new HashSet<>(numbers);
        Integer numbersSize = numbers.size();
        Integer setSize = set.size();
        if (numbersSize != setSize) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    static void commaCheck(String raw) {
        if (!raw.contains(",")) {
            throw new IllegalArgumentException("로또 번호는 쉼표(,)로 구분되야 합니다.");
        }
        if (raw.contains(",,")) {
            throw new IllegalArgumentException("로또 번호는 하나의 쉼표(,)로 구분되야 합니다.");
        }
        if (raw.startsWith(",") || raw.endsWith(",")) {
            throw new IllegalArgumentException("로또 번호는 쉼표(,)로 구분되야 합니다.");
        }
    }

    static void split6Check(String raw) {
        if (raw.split(",").length != Constants.LOTTO_NUMBER_COUNT.toInt()) {
            throw new IllegalArgumentException(
                    "로또 번호는 " + Constants.LOTTO_NUMBER_COUNT.toInt() + "개의 숫자여야 합니다.");
        }
    }

    static void range1to45Check(String raw) {
        for (String number : raw.split(",")) {
            if (Long.parseLong(number) < Constants.LOTTO_NUMBER_MIN.toInt()
                    || Long.parseLong(number) > Constants.LOTTO_NUMBER_MAX.toInt()) {
                throw new IllegalArgumentException("로또 번호는 "
                        + Constants.LOTTO_NUMBER_MIN.toInt() + "부터 "
                        + Constants.LOTTO_NUMBER_MAX.toInt() + " 사이의 숫자여야 합니다.");
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
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복 되지 않아야 합니다.");
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
