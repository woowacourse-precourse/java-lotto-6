package lotto.output;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class Output {
    private static void print(OutputMessage message) {
        System.out.print(message.getMessage());
    }

    public static void printLottoAmount(int lottoCount) {
        System.out.println();
        System.out.print(lottoCount);
        print(OutputMessage.LOTTO_AMOUNT);
        System.out.println();
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printLottoResult(int[] ranks) {
        System.out.println();
        print(OutputMessage.LOTTO_RESULT);

        for (int i = 4; i >= 0; i--) {
            print(OutputMessage.values()[i]);
            System.out.print(" - ");
            System.out.println(ranks[i] + "개");
        }
    }
}
