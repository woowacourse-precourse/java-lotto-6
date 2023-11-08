package lotto.input;

import java.util.List;
import lotto.exception.BaseException;

public interface NumberProvider {
    public Integer getSingle() throws BaseException;
    public List<Integer> getMultiple() throws BaseException;
}
