package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    private static DecimalFormat formatter = new DecimalFormat("#,###");
    private static final int NUMBER_OF_NUMEBERS = 6;
    private static final int[][] WINNING = new int[][]{
            new int[] {0, 0},
            new int[] {1, 0},
            new int[] {2, 0},
            new int[] {3, 5_000},
            new int[] {4, 50_000},
            new int[] {5, 1_500_000},
            new int[] {5, 30_000_000},
            new int[] {6, 2_000_000_000}
    };

    public static void main(String[] args) {

        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String money = Console.readLine();

                List<Lotto> lottos = LottoMachine.issueLotto(money);
                showIssuedLottos(lottos);

                System.out.println("당첨 번호를 입력해 주세요.");
                Set<Integer> winningNumbers = getWinningNumbers();

                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = getBonusNumber(winningNumbers);


                showResult(winningNumbers, lottos, bonusNumber);

                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private static void showIssuedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
        System.out.println();
    }

    private static Set<Integer> getWinningNumbers() {
        Set<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = new HashSet<>();
                String winningNumber = Console.readLine();
                validateWinningNumber(winningNumber);

                winningNumbers = Arrays.stream(winningNumber.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());

                if(winningNumbers.size() != NUMBER_OF_NUMEBERS)
                    throw new IllegalArgumentException("[ERROR] 중복없이 6개의 숫자를 쉼표로 구분해서 입력해주세요.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    private static int getBonusNumber(Set<Integer> winningNumbers) {
        while (true) {
            String bonusNumber = Console.readLine();
            if (!isNumeric(bonusNumber)) throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            try {
                validateNumberRange(bonusNumber);
                int bonus = Integer.parseInt(bonusNumber);
                if (winningNumbers.contains(bonus)) {
                    throw new IllegalArgumentException("[ERROR] 이전에 입력하지 않은 숫자를 입력해주세요.");
                }

                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private static void validateWinningNumber(String input) {
        if (input.length() != NUMBER_OF_NUMEBERS * 2 - 1)  throw new IllegalArgumentException("[ERROR] 숫자 6개를 쉼표로 구분해서 입력해주세요.");
        String[] numbers = input.split(",");
        for (String number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(String number) {
        int N = Integer.parseInt(number);
        if(!(1 <= N && N <= 45)) throw new IllegalArgumentException("[ERROR] 1 ~ 45의 숫자만 입력해주세요.");
    }

    private static void showResult(Set<Integer> winningNumbers, List<Lotto> lottos, int bonus) {
        int[] result = new int[NUMBER_OF_NUMEBERS + 2];
        int earnMoney = calculateWinningMoney(winningNumbers, lottos, result, bonus);


        StringBuilder sb = new StringBuilder();
        for (int i = 3; i <= 7; i++) {
            if(i == 6) sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(result[6]).append("개\n");
            else {
                sb
                        .append(WINNING[i][0])
                        .append("개 일치 ")
                        .append("(")
                        .append(formatter.format(WINNING[i][1]))
                        .append("원) - ")
                        .append(result[i])
                        .append("개\n");
            }
        }

        double profit = (double) earnMoney / (1000 * lottos.size()) * 100;
        sb.append("총 수익률은 ").append(String.format("%.1f", profit)).append("%입니다.");
        System.out.println(sb);
    }

    private static int calculateWinningMoney(Set<Integer> winningNumbers, List<Lotto> lottos, int[] result, int bonus) {
        for (Lotto lotto : lottos) {
            int count = 0;
            boolean bonusFlag = false;
            for (Integer number : lotto.getNumbers()) {
                if(winningNumbers.contains(number)) count++;
                if(number == bonus) bonusFlag = true;
            }

            if(count == 5 && bonusFlag) result[6]++;
            else result[count]++;
        }

        int earnMoney = 0;
        for (int i = 3; i <= NUMBER_OF_NUMEBERS; i++) {
            earnMoney += result[i] * WINNING[i][1];
        }

        return earnMoney;
    }


}
