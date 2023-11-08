package lotto.domain;

import lotto.constants.ResultConfig;

import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.constants.ResultConfig.*;

public class User {
    public int payment;
    public final List<Lotto> lottos;

    public final Map<String, Integer> totalResult;

    public int totalAmount = 0;

    public User(int payment) {
        this.payment = payment;
        this.lottos = Lotto.publish(payment);
        this.totalResult = Arrays.stream(values())
                                 .collect(Collectors.toMap(ResultConfig::getCount, value -> 0));
    }

    public void processCheckResult(String count, boolean getBonus) {
        if (count.equals("5") && getBonus) count += "0";
        saveResult(count);
        calculateTotalAmount(count);
    }

    private void saveResult(String message) {
        totalResult.put(message, totalResult.getOrDefault(message, 0) + 1);
    }

    private void calculateTotalAmount(String message) {
        totalAmount += ResultConfig(message);
    }

    @Override
    public String toString() {
        return "User{" +
                "payment=" + payment +
                ", lottos=" + lottos +
                ", totalResult=" + totalResult +
                '}';
    }

}
