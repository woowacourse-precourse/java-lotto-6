package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoWinningManager;
import lotto.domain.Prize;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinningConsoleUI {
    private final LottoWinningManager manager;

    public LottoWinningConsoleUI(LottoWinningManager manager) {
        this.manager = manager;
    }

    public void startDetermineWinningProcess() {
        List<Integer> winningNumbers = receiveWinningNumbers();
        int bonusNumber = receiveBonusNumber(winningNumbers);
        manager.setWinningLotto(new WinningLotto(winningNumbers, bonusNumber));
    }

    private List<Integer> receiveWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                return convertIntegerListFromInput(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자(정수)만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int receiveBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자(정수)만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> convertIntegerListFromInput(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> winningNumbers =  Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 번호는 서로 중첩되지 않아야 합니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자(정수)만 입력 가능합니다.");
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        uniqueNumbers.add(bonusNumber);
        if (uniqueNumbers.size() != winningNumbers.size() + 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 서로 중첩되지 않아야 합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자(정수)만 입력 가능합니다.");
        }
    }

    public void startSettleProcess(List<Lotto> lottos) {
        manager.settlePrizeResults(lottos);
        printStatistics();
    }
    public void printStatistics() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + manager.prizeFrequancyTable.get(Prize.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + manager.prizeFrequancyTable.get(Prize.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + manager.prizeFrequancyTable.get(Prize.THIRD) + "개");
        System.out.println("5개 일치, 보너스 불 일치 (30,000,000원) - " + manager.prizeFrequancyTable.get(Prize.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + manager.prizeFrequancyTable.get(Prize.FIRST) + "개");
    }
}
