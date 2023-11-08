package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    private List<Lotto> lottos;
    public static void main(String[] args) {
        new Application().start();
    }

    public void start() {
        int purchaseAmount = inputPurchaseAmount();
        lottos = purchaseLottos(purchaseAmount);

        printPurchasedLottos(lottos);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        System.out.println();
        LottoResult result = checkResults(winningNumbers, bonusNumber);
        printResults(result);
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.: ");
                int purchaseAmount = Integer.parseInt(Console.readLine().trim());
                if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요. (번호는 쉼표를 기준으로 구분): ");
                String[] tokens = Console.readLine().trim().split(",");
                if (tokens.length != 6) {
                    throw new IllegalArgumentException("[Error] 정확히 6개의 당첨 번호가 필요합니다.");
                }
                List<Integer> winningNumbers = new ArrayList<>();
                for (String token : tokens) {
                    int number = Integer.parseInt(token.trim());
                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException("[Error] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    winningNumbers.add(number);
                }
                if (new HashSet<>(winningNumbers).size() != 6) {
                    throw new IllegalArgumentException("[Error] 당첨 번호는 중복될 수 없습니다.");
                }
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.: ");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private LottoResult checkResults(List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNumbers);
            boolean hasBonus = lotto.hasBonusNumber(bonusNumber);
            result.addResult(matchCount, hasBonus);
        }
        return result;
    }

    private void printResults(LottoResult result) {
        System.out.println("--- 당첨 결과 ---");
        System.out.println("3개 일치 (5,000원) - " + result.getMatchCount(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getMatchCount(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getMatchCount(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getMatchCountWithBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getMatchCount(6) + "개");

        // 수익률 계산 및 출력
        long totalEarnings = result.getMatchCount(3) * 5000L +
                result.getMatchCount(4) * 50000L +
                result.getMatchCount(5) * 1500000L +
                result.getMatchCountWithBonus() * 30000000L +
                result.getMatchCount(6) * 2000000000L;
        int totalSpent = lottos.size() * 1000;
        double earningsRate = ((double) totalEarnings / totalSpent) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningsRate);
    }



}
