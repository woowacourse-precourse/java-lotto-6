package lotto.service.domain.lotto;

import lotto.io.LottoInputReader;
import lotto.model.dto.BuyInfo;
import lotto.service.convert.ConvertService;
import lotto.service.exceptionhandler.LottoErrorMessage;
import lotto.view.LottoOutputPrint;

import java.util.List;

public class LottoIoService {
    private LottoInputReader input = new LottoInputReader();
    private LottoOutputPrint result = new LottoOutputPrint();
    private ConvertService convert = new ConvertService();

    public BuyInfo inputAndOutputPrice(BuyInfo info) {
        String priceString;
        int buyWon;
        Loop:
        do {
            priceString = input.readerLottoPrice();
            buyWon = convert.ConvertStringToNumber(priceString);
            System.out.println("buyWon의 값 : " + buyWon);
            try {
                if (buyWon == 0) {
                    throw new IllegalArgumentException(
                      LottoErrorMessage.ERROR_LOTTO_NOT_TEN_WON_MESSAGE);
                }
                if (buyWon == -1){
                    throw new IllegalArgumentException(
                      LottoErrorMessage.ERROR_LOTTO_NOT_POSITIVE_NUMBER_MESSAGE);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue Loop;
            }
            info.setBuyWon(buyWon);
            info.setBuyNumber(convert.priceChangeBuyNumber(info.getBuyWon()));
            System.out.println(info.getBuyNumber());
        } while (info.getBuyNumber() == 0);
        result.printLottoPrice(info.getBuyNumber());
        return info;
    }

    public void inputAndOutputChoiceResultNumbers() {
        String choiceString = input.readerLottoNumbers();
        List<Integer> choiceList = convert.ConvertStringToNumbers(choiceString);

    }


}
