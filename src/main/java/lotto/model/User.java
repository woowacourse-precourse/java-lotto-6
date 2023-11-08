package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.Converter;
import lotto.utils.LottoNumbersGenerator;
import lotto.validator.UserValidator;

public class User {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final int count;

    public User(String money) {
        UserValidator.validateMoney(money);
        this.count = Converter.moneyToCount(money);
        generateTickets();
    }

    private void generateTickets() {
        for (int index = 0; index < count; index++) {
            lottoTickets.add(new Lotto(LottoNumbersGenerator.generate()));
        }
    }

    public int getCount() {
        return count;
    }

    public List<Integer> getTicket(int index) {
        Lotto lottoTicket = lottoTickets.get(index);
        return lottoTicket.getNumbers();
    }
}
