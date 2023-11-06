package lotto.global;

import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {
    public static <T> T input(Supplier<T> supplier){
        try {
            return supplier.get();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return input(supplier);
        }
    }
    public static <T,R> R process(Function<T, R> function, T t){
        try {
            return function.apply(t);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return process(function, t);
        }
    }
}
