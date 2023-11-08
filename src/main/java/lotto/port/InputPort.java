package lotto.port;

import java.util.List;

public interface InputPort {
     Integer readBudget();
    List<Integer> readDrawNumbers();
    Integer readBonusNumber();
}
