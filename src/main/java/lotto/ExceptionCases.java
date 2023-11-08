package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionCases {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public boolean LottoPriceCheck(String s) {
        int i;
        if (CheckBlank(s)) {
            return true;
        }
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return CheckFormat();
        }
        if (CheckZeroMinus(i)) {
            return true;
        }
        return CheckPrice(i);
    }

    public boolean CheckBlank(String s) {
        if (s.isBlank()) {
            try {
                throw new IllegalArgumentException(ERROR_MESSAGE + "공백은 입력할 수 없습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }

    public boolean CheckFormat() {
        try {
            throw new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 형식의 입력입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public void CheckFormat2() {
        try {
            throw new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 형식의 입력입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean CheckPrice(int i) {
        if (i % 1000 != 0) {
            try {
                throw new IllegalArgumentException(ERROR_MESSAGE + "구입금액은 1000원 단위입니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }

        return false;
    }

    public boolean CheckZeroMinus(int i) {
        if (i <= 0) {
            try {
                throw new IllegalArgumentException(ERROR_MESSAGE + "구입금액이 옳지 않습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }

    public void CheckDuplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "당첨 번호는 중복될 수 없습니다.");
        }
    }

    public void CheckNum(List<Integer> numbers) {
        for (int temp : numbers) {
            if (temp <= 0 || temp >= 46) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void CheckNum(int temp) {
        if (temp <= 0 || temp >= 46) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void CheckSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "당첨 번호는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    public void CheckLastComma(String s) {
        if (s.charAt(s.length() - 1) == ',') {
            throw new IllegalArgumentException(ERROR_MESSAGE + "당첨 번호 입력 형식이 잘못되었습니다");
        }
    }

    public void CheckSameWinAndBonus(List<Integer> Win, int Bonus) {
        if (Win.contains(Bonus)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "보너스 번호와 당첨 번호가 중복됩니다.");
        }
    }
}


