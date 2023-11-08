package lotto.util;

public interface FactoryFunction<R, I> {
    R execute(I input);
}
