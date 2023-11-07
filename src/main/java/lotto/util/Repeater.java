package lotto.util;

import java.util.function.Supplier;

public class Repeater {
    public static <T> T untilNotException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*
    public static <T> T repeatMethod(Method method) {
        while (true) {
            try {
                Object obj = method.invoke(new Input());
                return (T) obj;
            } catch (Exception e) {
                System.out.println(e.getCause().getMessage());
            }
        }
    }
    public static <T> T repeatUntilValid(Class<?> cls, String methodName) {
        try{
            Method method = cls.getMethod(methodName);
            return repeatMethod(method);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <R, P> R useCallable(Function<P, R> func) {
        while (true) {
            try {
                return func.apply(null);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    */
}
