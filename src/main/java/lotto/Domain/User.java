package lotto.Domain;


import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Validator.UserValidator;


public class User {
    private final int money;
    private final List<Lotto> lottos;

    public User(int money, List<Lotto> lottos) {
        validate(money, lottos);
        this.money = money;
        this.lottos = lottos;

    }
    private void validate(int money, List<Lotto> lottos) {
        UserValidator.doValidate(money, lottos);
    }

}
