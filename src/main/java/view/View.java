package view;

import Input.InputMessage;
import Input.LottoInput;
import constants.MessageType;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Input.InputMessage.*;
import static constants.MessageType.*;

public class View {
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

    public static int getBonus() {
        int bonus;
        while (true) {
            try {
                printInputMessage(GET_BOUNS_NUMBER);
                bonus = LottoInput.makeBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                printInputMessage(LOTTO_ERROR_MESSAGE);
            }
        }
        return bonus;
    }

    public static void showTotalLotto(Lotto[] lottos){
        System.out.println(lottos.length+printMessageType(HOW_MANY_BUY));
        for(int i=0;i<lottos.length;i++){
            List<Integer> numbers=new ArrayList<>(lottos[i].getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    public static void showLottoResult(int[] result,int price){
        System.out.println(printMessageType(SHOW_RESULT));
        System.out.println(printMessageType(SHOW_DASH));
        System.out.println(printMessageType(THREE_EQUAL)+result[0]+printMessageType(UNIT));
        System.out.println(printMessageType(FOUR_EQUAL)+result[1]+printMessageType(UNIT));
        System.out.println(printMessageType(FIVE_EQUAL_WITH_NO_BOUNS)+result[2]+printMessageType(UNIT));
        System.out.println(printMessageType(FIVE_EQUAL_WITH_BOUNS)+result[3]+printMessageType(UNIT));
        System.out.println(printMessageType(SIX_EQUAL)+result[4]+printMessageType(UNIT));
        float rate= (float) (result[0] * 5000 + result[1] * 50000 + result[2] * 1500000 + result[3] * 30000000 + result[4] * 2000000000)*100/price;
        System.out.printf(printMessageType(SHOW_RATE_OF_RETURN),rate);
    }

    public static String printMessageType(final MessageType messageType){
        return messageType.getMessage();
    }
    public static void printInputMessage(final InputMessage inputMessage){
        System.out.println(inputMessage.getMessage());
    }
}
