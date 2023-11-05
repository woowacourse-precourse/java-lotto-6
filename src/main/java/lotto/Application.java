package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
      final String INPUT_PURCHASE_AMOUNT_COMMENT = "구입금액을 입력해 주세요.";
      final String COUNT_PURCHASE_LOTTE_COMMENT = "개를 구매했습니다.";
      final String INPUT_WINNING_NUMBERS_COMMENT = "당첨 번호를 입력해 주세요.";
      final String INPUT_BONUS_NUMBER_COMMENT = "보너스 번호를 입력해 주세요.";
      final String PREFIX_ERROR_COMMENT = "[ERROR] ";

      List<Lotto> lottos = new ArrayList<>();
      List<Integer> winningNumbers = new ArrayList<>();
      Set<Integer> winningNumbersSet;
      long purchaseAmount = 0L, canPurchaseCount = 0L;
      int bonusNumber = 0;

      while (true) {
        try {
          System.out.println(INPUT_PURCHASE_AMOUNT_COMMENT);
          purchaseAmount = Long.parseLong(Console.readLine());
          canPurchaseCount = purchaseAmount / 1000;
          if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PREFIX_ERROR_COMMENT + "구입 금액은 1,000원 단위로 입력해 주셔야 합니다.");
          }
          break;
        } catch (NumberFormatException e) {
          System.out.println(PREFIX_ERROR_COMMENT + "구입 금액은 정수로 입력해 주셔야 합니다.");
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      }

      System.out.println(canPurchaseCount + COUNT_PURCHASE_LOTTE_COMMENT);

      for (int i = 0; i < canPurchaseCount; i++) {
        LottoNumberProducer lottoNumbers = new LottoNumberProducer();
        Lotto lotto = new Lotto(lottoNumbers.getNumbers());
        lotto.printNumbers();
        lottos.add(lotto);
      }

      while (true) {
        try {
          System.out.println(INPUT_WINNING_NUMBERS_COMMENT);
          String winningNumbersWithComma = Console.readLine();
          String[] winningNumbersStrings = winningNumbersWithComma.split(",");
          if (winningNumbersStrings.length != 6) {
            throw new IllegalArgumentException(PREFIX_ERROR_COMMENT + "로또 번호의 개수는 6개여야 합니다.");
          }
          for (String winningNumbersString : winningNumbersStrings) {
            winningNumbers.add(Integer.parseInt(winningNumbersString));
            int addValue = winningNumbers.get(winningNumbers.size() - 1);
            if(!(addValue > 0 && addValue < 46)) {
              throw new NumberFormatException();
            }
          }
          winningNumbersSet = new HashSet<>(winningNumbers);
          if (winningNumbersSet.size() != 6) {
            winningNumbersSet.clear();
            throw new IllegalArgumentException(PREFIX_ERROR_COMMENT + "로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
          }
          break;
        } catch (NumberFormatException e) {
          winningNumbers.clear();
          System.out.println(PREFIX_ERROR_COMMENT + "6개의 당첨 번호는 모두 1부터 45 사이의 정수여야 합니다.");
        } catch (IllegalArgumentException e) {
          winningNumbers.clear();
          System.out.println(e.getMessage());
        }
      }

      while (true) {
        try {
          System.out.println(INPUT_BONUS_NUMBER_COMMENT);
          bonusNumber = Integer.parseInt(Console.readLine());
          if(!(bonusNumber > 0 && bonusNumber < 46)) {
            throw new NumberFormatException();
          }
          winningNumbersSet.add(bonusNumber);
          if (winningNumbersSet.size() != 7) {
            throw new IllegalArgumentException(PREFIX_ERROR_COMMENT + "보너스 번호는 6개의 당첨 번호와 중복되지 않아야 합니다.");
          }
          break;
        } catch(NumberFormatException e) {
          System.out.println(PREFIX_ERROR_COMMENT + "보너스 번호는 1부터 45 사이의 정수여야 합니다.");
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      }

      WinningManager winningManager = new WinningManager(winningNumbers, bonusNumber, purchaseAmount);
      for (Lotto lotto : lottos) {
        winningManager.countMatchNumbers(lotto);
      }
      winningManager.printWinningStatistics();
      winningManager.printProfit();
    }
}
