package view;

import camp.nextstep.edu.missionutils.Console;
import validation.InputValidator;

public class InputView {
    public static final String INPUT_MONEY_PROMPT = "구입금액을 입력해 주세요.";

   public void inputMoney() {
       System.out.println(INPUT_MONEY_PROMPT);
       String lottoMoney = Console.readLine();
       validateinputMoney(lottoMoney);
   }

   private void validateinputMoney(String lottoMoney) {
       try {
           InputValidator.validInputMoney(lottoMoney);
       } catch (IllegalArgumentException e) {
           System.out.println("[ERROR] "+e.getMessage());
           inputMoney();
       }
   }
}
