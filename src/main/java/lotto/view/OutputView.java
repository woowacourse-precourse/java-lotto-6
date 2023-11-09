package lotto.view;

import static lotto.service.LottoService.*;

import lotto.domain.Lotto;
import java.util.List;

public class OutputView {
    public static void printResult(List<String> resultList) {
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    public static void printResult(String result) {
        System.out.println("\n" + result);
    }


    public static void printPurchaseResult(List<Lotto> lottoList) {
        String result = makePurchaseResultOutputStatement(lottoList);
        System.out.println("\n" + result);
    }

    private static String makePurchaseResultOutputStatement(List<Lotto> lottoList) {
        StringBuilder result = new StringBuilder();
        result.append(lottoList.size()).append(PURCHASE_X_COUNT + "\n");

        for (Lotto lotto : lottoList) {
            result.append(lotto.toString()).append("\n");
        }

        return result.toString();
    }


}

