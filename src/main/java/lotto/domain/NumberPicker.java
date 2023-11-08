package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumberPicker {
    List<Integer> pick();
}
