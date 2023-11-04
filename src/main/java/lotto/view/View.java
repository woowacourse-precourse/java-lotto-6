package lotto.view;

import static lotto.constant.Message.BOUGHT_QUANTITY_MESSAGE;
import static lotto.constant.Message.BUYING_PRICE_MESSAGE;
import static lotto.constant.Message.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constant.Message.INPUT_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.InputNumbersDTO;

public class View {

    public static void printStartMessage() {
        System.out.println(BUYING_PRICE_MESSAGE.getMessage());
    }

    public static String input() {
        String input =  Console.readLine();
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

    public static void printLottoResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - ");
        System.out.println("4개 일치 (50,000원) - ");
        System.out.println("5개 일치 (1,500,000원) - ");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println("6개 일치 (2,000,000,000원) - ");
    }

}
