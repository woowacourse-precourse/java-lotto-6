package lotto.model;

import java.util.List;

public interface NumbersGenerator <T extends Number> {

    List<T> generate();
}
