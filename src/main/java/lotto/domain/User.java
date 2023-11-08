package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Converter;
import lotto.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int amount;
    private final List<Lotto> lottos = new ArrayList<>();

    public void readBuyAmount() {
        try {
            OutputUtils.printReadBuyAmount();
            String input = Console.readLine();
            this.amount = Converter.convertValidUserBuyAmount(input);
        } catch (IllegalArgumentException e) {
            readBuyAmount();
        }
    }

    public int getAmount() {
        return this.amount;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
