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

    private static void validateWinningNumbers(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
        for (int winNumber : winNumbers) {
            if (winNumber < 1 || winNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 값이어야 합니다.");
            }
        }
    }

    private static List<Integer> inputWinningNumbers() {
        List<Integer> winNumbers = new ArrayList<>();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분)");
                String[] winNumberStrings = readLine().split(",");
                for (String winNumberString : winNumberStrings) {
                    winNumbers.add(Integer.parseInt(winNumberString.trim()));
                }
                validateWinningNumbers(winNumbers);
                return winNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
                winNumbers.clear(); // 잘못된 입력을 지우고 다시 시작합니다.
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winNumbers.clear(); // 잘못된 입력을 지우고 다시 시작합니다.
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


    private static void winStatistics(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber, int totalPrice) {
        int[] matchCounts = new int[LottoRank.values().length];
        long totalPrize = calculatePrize(lottoList, winNumbers, bonusNumber, matchCounts);
        printResult(matchCounts, totalPrize, totalPrice);
    }

    private static long calculatePrize(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber, int[] matchCounts) {
        long totalPrize = 0;
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.countMatchingNumbers(winNumbers);
            boolean isBonusMatch = lotto.containsBonusNumber(bonusNumber);

            LottoRank rank = LottoRank.valueOf(matchCount, isBonusMatch);
            matchCounts[rank.ordinal()]++;
            totalPrize += rank.getReward();
        }
        return totalPrize;
    }

    public static void printResult(int[] matchCounts, long totalPrize, int totalPrice) {
        // LottoRank.values()를 순회하는 대신 명시적으로 순서를 지정합니다.
        LottoRank[] ranks = {LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST};

        for (LottoRank rank : ranks) {
            if (rank.getMatchCount() >= 3) {
                String bonusText;
                if (rank.isBonusMatch()) {
                    bonusText = ", 보너스 볼 일치";
                } else {
                    bonusText = "";
                }
                System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                        rank.getMatchCount(), bonusText, rank.getReward(),
                        matchCounts[rank.ordinal()]);
            }
        }

        double earningRate = ((double) totalPrize / (totalPrice * 1000)) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }


}

