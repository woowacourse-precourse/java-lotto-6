package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.Converter;
import lotto.utils.LottoNumbersGenerator;
import lotto.validator.UserValidator;
import lotto.view.InputView;

public class User {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private int count;

    public User() {
        setCount();
        generateTickets();
    }

    private void setCount() {
        String money = InputView.money();
        try {
            UserValidator.validateMoney(money);
            count = Converter.moneyToCount(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCount();
        }
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
        Lotto lotto = lottoTickets.get(index);
        return lotto.getNumbers();
    }
}
