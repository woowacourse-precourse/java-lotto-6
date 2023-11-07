package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.PlayLotto.lottoPrice;

public class UserIO {
    public int getAmount() {
        try {
            String input = iOAmount();
            isNumeric(input);
            int amount = Integer.parseInt(input);
            validAmount(amount);
            amount /= lottoPrice;
            System.out.println("\n" + amount + "개를 구매했습니다.");
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAmount();
        }
    }

    public List<Integer> getNumbers() {
        try {
            String input = iONumbers();
            List<String> numbers = List.of(input.split(","));
            for (String number : numbers) {
                isNumeric(number);
            }
            return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumbers();
        }
    }

    public int getBonusNumber(Lotto lotto) {
        while (true) {
            try {
                String input = iOBonusNumbers();
                isNumeric(input);
                int bonusNumber = Integer.parseInt(input);
                isLottoNumber(bonusNumber);
                isDuplicate(bonusNumber, lotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printLottoResult(double rate) {
        DecimalFormat df = new DecimalFormat("#.#");
        String formattedRate = df.format(rate);
        System.out.println("총 수익률은 " + formattedRate + "%입니다.");
    }

    public void printStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    private void isDuplicate(int number, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존의 로또번호와 달라야 합니다.");
        }
    }

    private String iOAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    private String iOBonusNumbers() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    private void isNumeric(String input) {
        if (!(input.matches("[0-9]+"))) {
            throw new IllegalArgumentException("[ERROR] 숫자가 입력되어야 합니다.");
        }
    }

    private void validAmount(int amount) {
        if (amount % 1000 != 0 || amount == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + lottoPrice + "으로 나누어 떨어져야 하고 0보다 커야합니다.");
        }
    }

    private void isLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 로또번호를 입력해야 합니다.");
        }
    }

    private String iONumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

}
