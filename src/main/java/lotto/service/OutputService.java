package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.constant.PrintMessage;
import lotto.model.Lotto;

public class OutputService {
    public List<String> boughtResult(List<Lotto> lottos) {
        List<String> list = new ArrayList<>();
        for (Lotto lotto : lottos) {
            list.add(lotto.getNumbers().toString());
        }
        return list;
    }

    public List<String> winResult(Map<LottoPrize, Integer> result) {
        List<String> list = new ArrayList<>();
        for (LottoPrize lottoPrize : result.keySet()) {
            list.add(winResultReturnFormat(lottoPrize.getMessage(), result.get(lottoPrize)));
        }
        return list;
    }

    private String winResultReturnFormat(String message, int number) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(number);
        sb.append(PrintMessage.NUMBER_UNIT.getMessage());
        return sb.toString();
    }

    public String earningRateFormat(float earningRate) {
        return String.format("%.1f", earningRate);
    }
}
