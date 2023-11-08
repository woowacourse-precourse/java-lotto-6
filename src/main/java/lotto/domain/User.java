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

    public final Map<ResultConfig, Integer> totalResult;

    public int totalAmount = 0;

    public User(int payment) {
        this.payment = payment;
        this.lottos = Lotto.publish(payment);
        this.totalResult = Arrays.stream(values())
                                 .collect(Collectors.toMap(e -> e, value -> 0));
    }

    public boolean processCheckResult(long count, boolean getBonus) {
        if (count == 3) return process(THREE_COINCIDE);
        if (count == 4) return process(FOUR_COINCIDE);
        if (count == 6) return process(SIX_COINCIDE);
        if (count == 5) {
            if (getBonus) return process(FIVE_BONUS_COINCIDE);
            return process(FIVE_COINCIDE);
        }
        return false;
    }

    private boolean process(ResultConfig name) {
        saveResult(name);
        addTotalAmount(name);
        return true;
    }

    private void saveResult(ResultConfig name) {
        totalResult.put(name, totalResult.getOrDefault(name, 0) + 1);
//        totalResult.put(message, totalResult.getOrDefault(message, 0) + 1);
    }

    private void addTotalAmount(ResultConfig name) {
        totalAmount += name.getAmount();
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
