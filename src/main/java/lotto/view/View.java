package lotto.view;

import static lotto.constant.LottoResult.FIFTH_PLACE;
import static lotto.constant.LottoResult.FIRST_PLACE;
import static lotto.constant.LottoResult.FOURTH_PLACE;
import static lotto.constant.LottoResult.SECOND_PLACE;
import static lotto.constant.LottoResult.THIRD_PLACE;
import static lotto.constant.Message.BOUGHT_QUANTITY_MESSAGE;
import static lotto.constant.Message.BUYING_PRICE_MESSAGE;
import static lotto.constant.Message.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constant.Message.INPUT_NUMBER_MESSAGE;
import static lotto.constant.Message.LOTTO_RESULT_MESSAGE;
import static lotto.constant.Message.getRateOfReturnMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MatchedLottoCount;
import lotto.dto.InputNumbersDTO;

public class View {

    public static void printStartMessage() {
        System.out.println(BUYING_PRICE_MESSAGE.getMessage());
    }

    public static String input() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static void printPurchaseMessage(int quantity) {
        System.out.println(quantity + BOUGHT_QUANTITY_MESSAGE.getMessage());
    }

    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static InputNumbersDTO printInputNumbersMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE.getMessage());
        String inputNumbers = input();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        String inputBonusNumber = input();

        return new InputNumbersDTO(inputNumbers, inputBonusNumber);
    }

    public static void printLottoResult(MatchedLottoCount matchedLottoCount) {
        System.out.println(LOTTO_RESULT_MESSAGE.getMessage());
        System.out.println(FIFTH_PLACE.printMessage(matchedLottoCount.getPlaceCount(4)));
        System.out.println(FOURTH_PLACE.printMessage(matchedLottoCount.getPlaceCount(3)));
        System.out.println(THIRD_PLACE.printMessage(matchedLottoCount.getPlaceCount(2)));
        System.out.println(SECOND_PLACE.printMessage(matchedLottoCount.getPlaceCount(0)));
        System.out.println(FIRST_PLACE.printMessage(matchedLottoCount.getPlaceCount(1)));
    }

    public static void printRateOfReturn(String rateOfReturn) {
        System.out.println(getRateOfReturnMessage(rateOfReturn));
    }

}
