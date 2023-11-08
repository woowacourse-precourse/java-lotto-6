package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.UserException;
import lotto.util.InputParser;

//public class InputView {

//   private InputView(){
//
//   }
//
//   public static String inputPurchase(){
//       System.out.println("구입금액을 입력해 주세요. ");
//       return Console.readLine();
//   }
//
//   public static String inputWinningNumber(){
//       System.out.println("당첨 번호를 입력해 주세요. ");
//       return Console.readLine();
//   }
//
//   public static String inputBonusNumber(){
//       System.out.println("보너스 번호를 입력해 주세요. ");
//       return Console.readLine();
//   }

    public class InputView {
        private final OutputView outputView = new OutputView();
        private final InputParser inputParser = new InputParser();
        private final UserException userException = new UserException();
        private final LottoException lottoException = new LottoException();

        public int askBuyingPrice() {
            try {
                String input = Console.readLine();
                userException.validetePurchasePrice(input);
                return inputParser.numberParser(input);
            } catch (IllegalArgumentException exception) {
                outputView.printException(exception.getMessage());
                return askBuyingPrice();
            }
        }

        public List<Integer> askCorrectNumbers() {
            try {
                String input = Console.readLine();
                lottoException.validateCorrectNumbers(input);
                return inputParser.correctNumbersParser(input);
            } catch (IllegalArgumentException exception) {
                outputView.printException(exception.getMessage());
                return askCorrectNumbers();
            }
        }

        public int askBonusNumber(List<Integer> numbers) {
            try {
                String input = Console.readLine();
                lottoException.validateBonusNumber(input, numbers);
                return inputParser.numberParser(input);
            } catch (IllegalArgumentException exception) {
                outputView.printException(exception.getMessage());
                return askBonusNumber(numbers);
            }
        }

}
