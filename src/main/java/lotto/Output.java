package lotto;

import java.util.List;
import java.util.Map;

class Output {
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTOS = "%d개를 구매했습니다.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private Output() {
    }

    static void printGameStartMessage() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
    }

    static void printUserMoney(int userMoney) {
        System.out.println(userMoney + "\n");
    }

    static void printNumberOfLottos(int numberOfLottoes) {
        System.out.println(String.format(NUMBER_OF_LOTTOS, numberOfLottoes));
    }

    static void printLottoSixNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    private static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    static void printLottoNumbersMessage() {
        System.out.println("\n" + PROMPT_WINNING_NUMBERS);
    }

    static void printLottoNumbers(List<Integer> LottoNumbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LottoNumbers.size(); i++) {
            sb.append(LottoNumbers.get(i));
            if (i != LottoNumbers.size() - 1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString() + "\n");
    }

    static void printBonusNumberMessage() {
        System.out.println(PROMPT_BONUS_NUMBER);
    }

    static void printBonusNumber(int bonusNumber) {
        System.out.println(bonusNumber + "\n");
    }

    static void printLottoResult(Map<LottoMessage, Integer> lottoResult, int userMoney) {
        printWinningStatistics();

        int totalWinningAmount = 0;
        for (Map.Entry<LottoMessage, Integer> entry : lottoResult.entrySet()) {
            if (entry.getValue() > 0) {
                totalWinningAmount += entry.getKey().winningAmount * entry.getValue();
            }
            System.out.println(entry.getKey().message + " - " + entry.getValue() + "개");
        }
        printReturn(totalWinningAmount, userMoney);
    }

    private static void printWinningStatistics() {
        System.out.println("당첨 통계\n---");
    }

    private static void printReturn(int totalWinningAmount, int userMoney) {
        float profitRate = ((float) totalWinningAmount / userMoney) * PERCENTAGE_MULTIPLIER;
        System.out.printf(TOTAL_PROFIT_RATE_MESSAGE, profitRate);
    }
}
