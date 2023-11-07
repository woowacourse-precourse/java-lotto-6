package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final StringBuilder outputBuilder = new StringBuilder();

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        int ticket = purchaseTicket();
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < ticket; i++) {
            List<Integer> lottoNumbers = Lotto.makeLotto();
            outputBuilder.append(lottoNumbers).append("\n");
            lottoList.add(new Lotto(lottoNumbers));
        }

        System.out.println(outputBuilder);

        List<Integer> winNumbers = inputWinningNumbers(); // 당첨 번호는 6개
        int bonusNumber = inputBonusNumber(winNumbers); // 보너스 볼은 1개
        winStatistics(lottoList, winNumbers, bonusNumber, ticket);

    }

    public static int makeTicket(int totalPrice) {
        if (totalPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        return totalPrice / 1000;
    }

    private static int purchaseTicket() {
        int totalPrice;
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                totalPrice = Integer.parseInt(readLine());
                int ticket = makeTicket(totalPrice);
                outputBuilder.append(ticket).append("개를 구매했습니다.\n");
                return ticket;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 금액은 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> inputWinningNumbers() {
        List<Integer> winNumbers = new ArrayList<>();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분)");
                String[] winNumberStrings = readLine().split(",");
                if (winNumberStrings.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
                }
                for (String winNumberString : winNumberStrings) {
                    int winNumber = Integer.parseInt(winNumberString.trim());
                    if (winNumber < 1 || winNumber > 45) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 값이어야 합니다.");
                    }
                    winNumbers.add(winNumber);
                }
                return winNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBonusNumber(List<Integer> winNumbers) {
        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 볼을 입력해 주세요.");
                bonusNumber = Integer.parseInt(readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 볼은 1부터 45 사이의 값이어야 합니다.");
                }
                if (winNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호와 중복될 수 없습니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static void winStatistics(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber,
                                      int totalPrice) {
        int[] matchCounts = new int[7]; // Index 0 is unused, indices 1-6 are for matching numbers
        long totalPrize = 0;

        for (Lotto lotto : lottoList) {
            int matchCount = lotto.countMatchingNumbers(winNumbers);
            if (matchCount == 5 && lotto.containsBonusNumber(bonusNumber)) {
                matchCounts[6]++; // This is for 5+bonus
                totalPrize += 30000000; // The prize for 5+bonus
            } else {
                matchCounts[matchCount]++;
                switch (matchCount) {
                    case 3:
                        totalPrize += 5000;
                        break;
                    case 4:
                        totalPrize += 50000;
                        break;
                    case 5:
                        totalPrize += 1500000;
                        break;
                    case 6:
                        totalPrize += 2000000000;
                        break;
                }
            }
        }

        System.out.println("3개 일치 (5,000원) - " + matchCounts[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[6] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[6] + "개");

        double earningRate = ((double) totalPrize / totalPrice) /10;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }
}

