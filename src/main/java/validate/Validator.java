package validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import user.User;

public class Validator {
    private User user;

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] ?? ??? 6??? ???.");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalStateException("[ERROR] ?? ??? ?? ??? ? ????.");
        }

    }

    public void isInvalidPriceUnit() {
        if (user.inputLottoTicketPrice() % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] ??? 1,000? ??? ???? ???.");
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }
}
