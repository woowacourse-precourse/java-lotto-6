package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
            final int LOTTO_PRICE = LottoConstants.PRICE.getValue();

            // 기능1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 1장 당 1000원의 로또를 발행해야 한다.
            // 1000원으로 나눠 떨어지지 않는 경우 예외처리를 한다.
            System.out.println("구입금액을 입력해 주세요.");


            List<Lotto> lottos = null;
            try {
                    int amount = Integer.parseInt(Console.readLine());
                    // buyLottos 메서드를 구현하여 1000원으로 나눠떨어지지 않는 경우 IllegalArgumentException을 발생시키도록 함.
                    lottos = Lotto.buyLottos(amount);
                    System.out.println(amount / LOTTO_PRICE + "개를 구매했습니다.");

                    lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
                    // 기능2. 당첨 번호와 보너스 번호를 입력받는다.
                    System.out.print("\n당첨 번호를 입력해 주세요.\n");
                    String line = Console.readLine();
                    String[] numberStrings = line.split(",");
                    Set<Integer> winningNumbers = new HashSet<>();
                    for (String number : numberStrings) {
                            // 기능4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
                            // "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
                            if (!winningNumbers.add(Integer.parseInt(number.trim()))) {
                                throw new IllegalArgumentException("당첨 번호에 중복된 번호는 입력하면 안됩니다.");
                            }
                            if (!(Integer.parseInt(number.trim()) >= 1 && Integer.parseInt(number.trim()) <= 45)) {
                                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 수여야 합니다.");
                            }
                    }
                    // 기능2. 당첨 번호와 보너스 번호를 입력받는다.
                    System.out.print("보너스 번호를 입력해 주세요.\n");
                    int bonusNumber = Integer.parseInt(Console.readLine());
                    // 기능4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
                    // "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
                    if (winningNumbers.contains(bonusNumber)) {
                            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되어서는 안됩니다.");
                    }
                    if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
                            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 수여야 합니다.");
                    }

                    // 기능3. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
                    System.out.println("\n당첨 통계");
                    System.out.println("---");
                    Map<WinningStatus, Integer> results = new TreeMap<>();
                    // 3개 일치 (5,000원), 4개 일치 (50,000원), 5개 일치 (1,500,000원), 5개 일치, 보너스 볼 일치 (30,000,000원), 6개 일치 (2,000,000,000원)
                    int[] prizes = {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000};

                    lottos.forEach(lotto -> {
                            int matchCount = lotto.numOfMatches(winningNumbers);
                            boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);
                            WinningStatus status = WinningStatus.valueOf(matchCount, bonusMatch);

                            results.put(status, results.getOrDefault(status, 0) + 1);
                    });

                    int total = 0;
                    // 기능3. 당첨 내역 출력
                    for (WinningStatus status : WinningStatus.values()) {
                            if (status != WinningStatus.NONE) { // 'NONE' 상태는 제외
                                int count = results.getOrDefault(status, 0);
                                total += status.getPrizeMoney() * count;
                                if (status == WinningStatus.FIVE_PLUS_BONUS) {
                                        // 5개 일치 + 보너스 볼의 경우는 특별하게 처리
                                        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", status.getMatchCount(),
                                                            String.format("%,d", status.getPrizeMoney()), count);
                                }

                                if (status == WinningStatus.THREE_MATCHES || status == WinningStatus.FOUR_MATCHES || status == WinningStatus.FIVE_MATCHES) {
                                    System.out.printf("%d개 일치 (%s원) - %d개\n", status.getMatchCount(),
                                                        String.format("%,d", status.getPrizeMoney()), count);
                                }
                            }
                    }
            // 기능3. 수익률 출력
            double profitRate = ((double) total / amount) * 100;
            System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
            // 기능3. 로또 게임 종료 - main  메서드의 마지막 부분이므로 프로그램 종료됨
            } catch(IllegalArgumentException e){
                    System.out.println("[ERROR]" + e.getMessage());
            }
    }
}

