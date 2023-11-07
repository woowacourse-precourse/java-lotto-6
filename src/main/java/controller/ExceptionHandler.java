package controller;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

class ExceptionHandler {
    static <T> T handleException(Callable<T> method) {
        while (true) {
            try {
                return method.call();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                throw e;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
