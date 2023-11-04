package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCompany;
import lotto.domain.User;
import lotto.util.NumberValidator;
import lotto.util.StringUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoCompany lottoCompany = LottoCompany.INSTANCE;
    private final User user = User.INSTANCE;

    public static void run() {
        boolean success;
        String input;
        success = false;
        while (!success) {
            try {
                input = InputView.inputMoney();
                NumberValidator.validateChangeNumber(input);
                User.purchaseLottos(StringUtil.convertStringToInt(input));
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        List<Lotto> lottos = User.getLottos();
        OutputView.printPurchase(lottos.size());
        OutputView.printLottos(lottos);


        success = false;
        while (!success) {
            try {
                input = InputView.inputPrizeNumber();
                List<String> splitString = StringUtil.splitWithComma(input);
                for(String string : splitString) {
                    NumberValidator.validateChangeNumber(string);
                }

                List<Integer> prizeNumbers = new ArrayList<Integer>();
                for(String string : splitString) {
                    prizeNumbers.add(StringUtil.convertStringToInt(string));
                }
                LottoCompany.setPrizeNumbers(prizeNumbers);
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        success = false;
        while (!success) {
            try {
                input = InputView.inputBonusNumber();
                NumberValidator.validateChangeNumber(input);
                LottoCompany.setBonusNumber(StringUtil.convertStringToInt(input));
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        for(Lotto lotto : lottos) {
            int tmp = LottoCompany.matchPrize(lotto.getNumbers());
            if(tmp != -1){
                User.plusPrizeCount(tmp);
            }
        }

        User.calcRateOfReturn();
        OutputView.printPrizeStatistics(User.getPrizeCounts());
        OutputView.printRateOfReturn(User.getRateOfReturn());
    }
}
