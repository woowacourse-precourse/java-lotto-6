package lotto.service.domain.lotto;

import lotto.io.LottoInputReader;
import lotto.model.dto.BuyInfo;
import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import lotto.service.convert.ConvertService;
import lotto.service.exceptionhandler.LottoErrorMessage;
import lotto.view.LottoOutputPrint;

import java.util.Arrays;
import java.util.List;

public class LottoIoService {
    private final LottoInputReader input = new LottoInputReader();
    private final LottoOutputPrint result = new LottoOutputPrint();
    private final ConvertService convert = new ConvertService();

    public BuyInfo inputPriceGetBuyInfo(BuyInfo info) {
        String priceString;
        int buyWon;
        Loop:
        do {
            priceString = input.readerLottoPrice();
            buyWon = convert.ConvertStringToNumber(priceString);
            try {
                if (buyWon == 0) {
                    throw new IllegalArgumentException(
                      LottoErrorMessage.ERROR_LOTTO_NOT_TEN_WON_MESSAGE);
                }
                if (buyWon == -1) {
                    throw new IllegalArgumentException(
                      LottoErrorMessage.ERROR_LOTTO_NOT_POSITIVE_NUMBER_MESSAGE);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue Loop;
            }
            info.setBuyWon(buyWon);
            info.setBuyNumber(convert.priceChangeBuyNumber(info.getBuyWon()));
        } while (info.getBuyNumber() == 0);
        result.printLottoPrice(info.getBuyNumber());
        return info;
    }

    public Lotto userPickMasterLottoNumbers() {
        String masterNumberString;
        List<Integer> masterNumbers;
        int LottoValueSize = 6;
        Lotto userLottoNumber;
        Loop:
        while (true) {
            try {
                masterNumberString
                  = input.readerLottoMasterNumbers();
                if (masterNumberString == null) {
                    throw new IllegalArgumentException
                      (LottoErrorMessage.ERROR_LOTTO_NULL_POINT_MESSAGE);
                }
                masterNumbers
                  = convert.ConvertStringToNumbers(masterNumberString, LottoValueSize);
                if (masterNumbers.equals(Arrays.asList(-2))) {
                    throw new IllegalArgumentException
                      (LottoErrorMessage.ERROR_LOTTO_NOT_CHOICE_SIX_NUMBER_MESSAGE);
                }
                if (masterNumbers.equals(Arrays.asList(-1))) {
                    throw new IllegalArgumentException
                      (LottoErrorMessage.ERROR_LOTTO_NOT_POSITIVE_NUMBER_MESSAGE);
                }
                // 로또에 심어둔 Exception도 활용
                userLottoNumber = new Lotto(masterNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue Loop;
            }
        }
        return userLottoNumber;
    }

    public LottoBonus userPickMasterBonusNumberOne(Lotto lotto) {
        String bonusString;
        List<Integer> bonusList;
        LottoBonus lottoBonus;
        int LottoBonusValueSize = 1;
        Loop:
        while (true) {
            try {
                bonusString = input.readerChoiceLottoBonusNumber();
                if (bonusString == null) {
                    throw new IllegalArgumentException
                      (LottoErrorMessage.ERROR_LOTTO_NULL_POINT_MESSAGE);
                }
                bonusList = convert.ConvertStringToNumbers(bonusString, LottoBonusValueSize);
                lottoBonus = new LottoBonus(bonusList);
                int checkPoint = 0;
                for (int i = 0; i < lotto.getNumbers().size(); i++) {
                    if (lotto.getNumbers().get(i).equals(lottoBonus.getNumber().get(0))) {
                        checkPoint++;
                    }
                }
                if (checkPoint == 1) {
                    throw new IllegalArgumentException
                      (LottoErrorMessage.ERROR_LOTTO_OVERLAP_NUMBER_MESSAGE);
                }
                return lottoBonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue Loop;
            }
        }
    }
}
