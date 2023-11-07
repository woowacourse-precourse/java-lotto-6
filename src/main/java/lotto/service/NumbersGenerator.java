package lotto.service;

import java.util.List;

public interface NumbersGenerator {

    List<Integer> generate(int startNumber, int endNumber, int count);
}
