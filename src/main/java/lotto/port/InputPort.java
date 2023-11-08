package lotto.port;

import java.util.List;

public interface InputPort {
     Integer readPurchaseAmount();
    List<Integer> readDrawNumbers();
    Integer readBonusNumber();
}
