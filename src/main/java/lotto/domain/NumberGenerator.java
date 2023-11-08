package lotto.domain;

import java.util.List;

public interface NumberGenerator {

    List<Integer> generate(final int start, final int end, final int count);
}
