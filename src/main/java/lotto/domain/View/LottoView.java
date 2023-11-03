package lotto.domain.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Model.Lotto;
import lotto.domain.Model.LottoContainer;
import lotto.domain.Model.Prize;
import lotto.domain.Utility.Constant;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.PatternSyntaxException;

public class LottoView {

    public int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String inputValue = Console.readLine();
            int cash = Integer.parseInt(inputValue);
            validateInputCash(cash);
            return cash;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            return inputCash();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCash();
        }
    }

    private void validateInputCash(int cash) {
        if (cash <= 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 작은 값을 입력했습니다.");
        } else if (cash % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해 주세요.");
        }
    }

    public void printPickedLotto(LottoContainer lottoContainer) {
        System.out.println();
        System.out.println(lottoContainer.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto :
                lottoContainer.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        try {
            String inputValue = Console.readLine();

            List<Integer> winningNumbers = new ArrayList<>(Arrays.stream(inputValue.split(","))
                    .mapToInt(Integer::parseInt).boxed().toList());

            winningNumbers.sort(Integer::compareTo);

            validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (PatternSyntaxException e) {
            System.out.println("[ERROR] 각 숫자의 구별은 쉼표(,)로 해주세요.");
            return inputWinningNumbers();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            return inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Constant.LOTTO_PICK_NUMBER) {
            throw new IllegalArgumentException("[ERROR] " + Constant.LOTTO_PICK_NUMBER + "자리를 입력해 주세요.");
        }

        Map<Integer, Integer> sameNumberCheck = new HashMap<>();

        for (int num :
                winningNumbers) {
            if (num < Constant.LOTTO_START_NUMBER || num > Constant.LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(
                        "[ERROR] 당첨 숫자를 "
                        + Constant.LOTTO_START_NUMBER
                        + " ~ "
                        + Constant.LOTTO_END_NUMBER
                        + "중에서 선택해야 합니다."
                );
            } else if (sameNumberCheck.containsKey(num)) {
                throw new IllegalArgumentException("[ERROR] 동일한 숫자를 입력했습니다.");
            }
            sameNumberCheck.put(num, sameNumberCheck.getOrDefault(num, 0) + 1);
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            String inputValue = Console.readLine();
            int bonusNumber = Integer.parseInt(inputValue);
            validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            return inputBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < Constant.LOTTO_START_NUMBER || bonusNumber > Constant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 보너스 숫자를 "
                            + Constant.LOTTO_START_NUMBER
                            + " ~ "
                            + Constant.LOTTO_END_NUMBER
                            + "중에서 선택해야 합니다."
            );
        } else if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 당첨 숫자와 겹칩니다.");
        }
    }

    public void printWinnings(Map<String, Integer> winnings, int cash) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalPrize = 0;
        for (Prize prize : Prize.values()) {
            Integer count = winnings.getOrDefault(prize.getRank(), 0);
            totalPrize += prize.getPrize() * count;
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            String formattedNumber = numberFormat.format(prize.getPrize());
            System.out.println(prize.getRank() + " (" + formattedNumber + "원) - " + count + "개");
        }

        double revenueRate = ((double) totalPrize / cash) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", revenueRate);
    }
}
