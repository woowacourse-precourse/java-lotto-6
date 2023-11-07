package lotto.controller;

import lotto.model.EarnMoney;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.parser.Parser;
import lotto.validate.InputValidate;
import lotto.view.View;
import java.util.List;
import java.util.Map;
import static lotto.exception.ErrorMessage.*;

public class LottoController {

    public static void run() {

        int money = proceedInputMoney();

        int buyLottoCount = Lotto.buyLottoTicket(money);

        View.printLottoTicketCount(buyLottoCount);

        List<Lotto> lotties = Lotto.collectLotto(buyLottoCount);

        View.printLotto(lotties);

        List<Integer> winNumbers = proceedWinNumbers();

        int bonusNumber = proceedBonusNumber(winNumbers);

        Map<String, Integer> result = Result.getResultWinCount(lotties, winNumbers, bonusNumber, money);
        int earnMoney = EarnMoney.getEarnMoney(result);
        double rateOfReturn = Parser.getRateOfReturn(earnMoney, money);
        View.printResult(result, rateOfReturn);
    }

    public static int proceedInputMoney() {
        int parseMoney = 0;
        while (true) {
            try {
                String money = View.inputBuyMoney();

                System.out.println();

                InputValidate.validateEmpty(money);

                InputValidate.validateStartNumber(money);

                parseMoney = InputValidate.validateNumberFormat(money);

                InputValidate.validateUnit(parseMoney);
                return parseMoney;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(INCORRECT_NUMBER_FORMAT.getErrorMessage());
                continue;
            } catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }
        }
    }

    public static List<Integer> proceedWinNumbers() {
        List<Integer> parseWinNumbers;

        System.out.println();

        while (true) {
            try {
                String winNumber = View.inputWinNumber();

                System.out.println();

                InputValidate.validateEmpty(winNumber);

                InputValidate.validateWinNumberFormat(winNumber);

                int[] winNumbers = Parser.parseIntArray(winNumber);

                parseWinNumbers = Parser.parseIntList(winNumbers);

                InputValidate.validateSixNumber(parseWinNumbers);
                return parseWinNumbers;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(INCORRECT_NUMBER_FORMAT.getErrorMessage());
                continue;
            } catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }

        }
    }

    public static int proceedBonusNumber(List<Integer> winNumbers) {
        int parseBonusNumber = 0;

        while (true) {
            String bonusNumber = View.inputBonusNumber();

            InputValidate.validateEmpty(bonusNumber);

            parseBonusNumber = InputValidate.validateNumberFormat(bonusNumber);

            InputValidate.validateNumberRange(parseBonusNumber);

            InputValidate.validateDuplicateNumber(winNumbers, parseBonusNumber);
            return parseBonusNumber;
        }
    }
}
