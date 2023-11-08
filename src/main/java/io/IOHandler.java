package io;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.constant.LottoRank;

import java.util.*;

import static io.message.InputErrorMessage.NOT_INTEGER;
import static io.message.InputInfoMessage.*;

public class IOHandler {

    private final InputValidator validator = new InputValidator();

    public int inputLottoPurchaseAmount() {
        int lottoPurchaseAmount;
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage());

        try {
            lottoPurchaseAmount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }

        validator.validateLottoPurchaseAmount(lottoPurchaseAmount);

        return lottoPurchaseAmount;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;
        System.out.println(WINNING_NUMBERS_MESSAGE.getMessage());

        try {
            String input = Console.readLine();
            winningNumbers = Arrays.stream(input.split(",")).map(s -> Integer.parseInt(s.trim())).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }

        validator.validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        System.out.println(BONUS_NUMBER_MESSAGE.getMessage());

        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }

        validator.validateBonusNumber(bonusNumber, winningNumbers);

        return bonusNumber;
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        });
    }

    public void printWinningHistory(Map<LottoRank, Integer> winningHistory) {
        System.out.printf("""
                        당첨 통계
                        ---
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        """,
                winningHistory.get(LottoRank.FIFTH),
                winningHistory.get(LottoRank.FOURTH),
                winningHistory.get(LottoRank.THIRD),
                winningHistory.get(LottoRank.SECOND),
                winningHistory.get(LottoRank.FIRST));
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
