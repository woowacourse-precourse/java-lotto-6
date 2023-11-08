package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConsoleInput {

    public static int buy() {
        String unverifiedUserPay = Console.readLine();

        String regex = "^[1-9][0-9]*[0]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(unverifiedUserPay);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위어야 합니다.");
        }

        int verifiedUserPay = Integer.parseInt(unverifiedUserPay);
        return verifiedUserPay / 1000;
    }

    public static boolean hasDuplicate(String unverified) {
        return Arrays.stream(unverified.split(",")).distinct().count() != Lotto.LOTTO_NUMBER;
    }

    public static List<Integer> winningNumbers() throws IllegalArgumentException {
        String unverifiedWinningNumbers = Console.readLine();

        String regex = "^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5])){5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(unverifiedWinningNumbers);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45까지 6개의 수 입니다.");
        }
        if (hasDuplicate(unverifiedWinningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 다른 6개의 수 입니다.");
        }

        return Arrays.stream(unverifiedWinningNumbers.split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int bonusNumber() throws IllegalArgumentException {
        String unverifiedBonusNumbers = Console.readLine();

        String regex = "^([1-9]|[1-3][0-9]|4[0-5])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(unverifiedBonusNumbers);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위의 수 입니다.");
        }
        return Integer.parseInt(unverifiedBonusNumbers);
    }

}
