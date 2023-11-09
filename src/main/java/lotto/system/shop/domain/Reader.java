package lotto.system.shop.domain;

import java.util.List;

public interface Reader {

    List<Integer> readNumbers();

    Integer readNumber();
}
