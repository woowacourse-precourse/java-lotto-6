package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
      List<Lotto> lottos = new ArrayList<>();
      List<Integer> winningNumbers = new ArrayList<>();
      Set<Integer> winningNumbersSet;
      long purchaseAmount = 0L, canPurchaseCount = 0L;
      int bonusNumber = 0;

      while (true) {
        try {
          System.out.println(Comment.INPUT_PURCHASE_AMOUNT_COMMENT.getComment());
          purchaseAmount = Long.parseLong(Console.readLine());
          canPurchaseCount = purchaseAmount / 1000;
          if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorComment.INPUT_1000_UNIT.getComment());
          }
          break;
        } catch (NumberFormatException e) {
          System.out.println(ErrorComment.INPUT_INTEGER.getComment());
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      }

      System.out.println(canPurchaseCount + Comment.COUNT_PURCHASE_LOTTE_COMMENT.getComment());

      for (int i = 0; i < canPurchaseCount; i++) {
        LottoNumberProducer lottoNumbers = new LottoNumberProducer();
        Lotto lotto = new Lotto(lottoNumbers.getNumbers());
        lotto.printNumbers();
        lottos.add(lotto);
      }

      while (true) {
        try {
          System.out.println(Comment.INPUT_WINNING_NUMBERS_COMMENT.getComment());
          String winningNumbersWithComma = Console.readLine();
          String[] winningNumbersStrings = winningNumbersWithComma.split(",");
          if (winningNumbersStrings.length != 6) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException(ErrorComment.NOT_DUPLICATED_NUMBER.getComment());
          }
          break;
        } catch (NumberFormatException e) {
          winningNumbers.clear();
          System.out.println(ErrorComment.ALL_LOTTO_NUMBERS_1_45.getComment());
        } catch (IllegalArgumentException e) {
          winningNumbers.clear();
          System.out.println(e.getMessage());
        }
      }

      while (true) {
        try {
          System.out.println(Comment.INPUT_BONUS_NUMBER_COMMENT.getComment());
          bonusNumber = Integer.parseInt(Console.readLine());
          if(!(bonusNumber > 0 && bonusNumber < 46)) {
            throw new NumberFormatException();
          }
          winningNumbersSet.add(bonusNumber);
          if (winningNumbersSet.size() != 7) {
            throw new IllegalArgumentException(ErrorComment.BONUS_NUMBER_NOT_DUPLICATED_NUMBER.getComment());
          }
          break;
        } catch(NumberFormatException e) {
          System.out.println(ErrorComment.BONUS_NUMBER_1_45.getComment());
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
