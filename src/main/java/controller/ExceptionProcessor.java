package controller;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import lotto.Lotto;
import model.LottoGenerator;

public class ExceptionProcessor {
    public static <T> Integer receiveAndExceptionForMoney(Callable<T> inputMethod) {
        while (true) {
            try {
                return (Integer) inputMethod.call();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                throw e;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static <T> Integer[] receiveAndExceptionForNumbers(Callable<T> inputMethod) {
        while (true) {
            try {
                return (Integer[]) inputMethod.call();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                throw e;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static <T> Lotto proceedtoMakingLotto(Callable<T> inputMethod) {
        Integer[] userNumbers = receiveAndExceptionForNumbers(inputMethod);
        while (true) {
            try {
                return LottoGenerator.generateLotto(userNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                userNumbers = receiveAndExceptionForNumbers(inputMethod);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
