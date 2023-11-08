package lotto.input.provider;

import java.io.IOException;
import java.util.List;

public interface NumberProvider {
    public Integer getSingle() throws IllegalArgumentException, IOException;
    public List<Integer> getMultiple(int number) throws IllegalArgumentException, IOException;
}
