package lotto.service;

import lotto.constant.Message.InputMessage;
import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Sign;
import lotto.domain.Buyer;
import lotto.util.StringUtil;
import lotto.validator.MainValidator;

public class InputService {
    MainValidator mainValidator = new MainValidator();
    StringUtil stringUtil = new StringUtil();
    private Buyer buyer;

    public Buyer inputPurchaseAmount() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(InputMessage.REQUEST_PURCHASE_AMOUNT_MESSAGE.getInputMessage());
                buyer = new Buyer(Console.readLine().trim());
                validInput = true;
                return buyer;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public int[] inputLottoNumber() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(InputMessage.REQUEST_LOTTO_NUMBER_MESSAGE.getInputMessage());
                String buyerLotto = Console.readLine().trim();
                String[] buyerLottoNumbers = mainValidator.validateBuyerLotto(buyerLotto);
                validInput = true;
                System.out.println(Sign.LINE_BREAKER.getSign());

                return stringUtil.ConvertStringArrayToIntArray(buyerLottoNumbers);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public int inputBounusNumber(int[] buyerLottoNumbers) {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(InputMessage.REQUEST_BONUS_NUMBER_MESSAGE.getInputMessage());
                String buyerBonusNumber = Console.readLine().trim();
                mainValidator.validateBuyerBonusNumber(buyerBonusNumber, buyerLottoNumbers);
                validInput = true;
                System.out.println(Sign.LINE_BREAKER.getSign());

                return Integer.parseInt(buyerBonusNumber);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}
