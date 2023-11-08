package view;

import Input.InputMessage;
import Input.LottoInput;
import constants.LottoConstant;
import constants.MessageType;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Input.InputMessage.*;
import static constants.LottoConstant.*;
import static constants.MessageType.*;

public class View {
    private final static int HUNDRED = 100;

    public static int getPrice() {
        int price;
        while (true) {
            try {
                printInputMessage(GET_PRICE_MESSAGE);
                price = LottoInput.inputPrice();
                break;
            } catch (IllegalArgumentException e) {
                printInputMessage(PRICE_ERROR_MESSAGE);
            }
        }
        return price;
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer;
        while (true) {
            try {
                printInputMessage(GET_ANSWER_LOTTO);
                answer = LottoInput.makeAnswerNumber();
                break;
            } catch (IllegalArgumentException e) {
                printInputMessage(LOTTO_ERROR_MESSAGE);
            }
        }
        return answer;
    }

    public static int getBonus(Lotto answer) {
        int bonus;
        while (true) {
            try {
                printInputMessage(GET_BONUS_NUMBER);
                bonus = LottoInput.makeBonusNumber(answer);
                break;
            } catch (IllegalArgumentException e) {
                printInputMessage(LOTTO_ERROR_MESSAGE);
            }
        }
        return bonus;
    }

    public static void showTotalLotto(Lotto[] lottos) {
        System.out.println(lottos.length + printMessageType(HOW_MANY_BUY));
        for (int i = 0; i < lottos.length; i++) {
            List<Integer> numbers = new ArrayList<>(lottos[i].getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    public static void showLottoResult(int[] result, int price) {
        System.out.println(printMessageType(SHOW_RESULT));
        System.out.println(printMessageType(SHOW_DASH));
        System.out.println(printMessageType(THREE_EQUAL) + result[getResult(FIFTH_PLACE)] + printMessageType(UNIT));
        System.out.println(printMessageType(FOUR_EQUAL) + result[getResult(FOURTH_PLACE)] + printMessageType(UNIT));
        System.out.println(printMessageType(FIVE_EQUAL_WITH_NO_BOUNS) + result[getResult(THIRD_PLACE)] + printMessageType(UNIT));
        System.out.println(printMessageType(FIVE_EQUAL_WITH_BOUNS) + result[getResult(SECOND_PLACE)] + printMessageType(UNIT));
        System.out.println(printMessageType(SIX_EQUAL) + result[getResult(FIRST_PLACE)] + printMessageType(UNIT));
        float rate = (float) (result[getResult(FIFTH_PLACE)] * getResult(FIFTH_REWARD) + result[getResult(FOURTH_PLACE)] * getResult(FOURTH_REWARD) + result[getResult(THIRD_PLACE)] * getResult(THIRD_REWARD) + result[getResult(SECOND_PLACE)] * getResult(SECOND_REWARD) + result[getResult(FIRST_PLACE)] * getResult(FIRST_REWARD)) * HUNDRED / price;
        System.out.printf(printMessageType(SHOW_RATE_OF_RETURN), rate);
    }

    private static String printMessageType(final MessageType messageType) {
        return messageType.getMessage();
    }

    private static void printInputMessage(final InputMessage inputMessage) {
        System.out.println(inputMessage.getMessage());
    }

    private static int getResult(final LottoConstant lottoConstant) {
        return lottoConstant.getResult();
    }
}
