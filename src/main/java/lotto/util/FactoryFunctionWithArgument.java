package lotto.util;

public interface FactoryFunctionWithArgument<R, T, A> {
    R execute(T input, A argument);
}
