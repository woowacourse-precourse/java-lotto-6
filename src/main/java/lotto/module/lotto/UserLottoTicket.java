package lotto.module.lotto;

import java.util.List;

public class UserLottoTicket extends Lotto {

    public UserLottoTicket(List<Integer> numbers) {
        super(numbers);
    }

    public static UserLottoTicket newInstance(List<Integer> numbers) {
        return new UserLottoTicket(numbers);
    }

    public List<Integer> getNumbers() {
        return super.getNumbers();
    }

}
