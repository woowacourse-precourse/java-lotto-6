package lotto.utils;

import java.util.function.Supplier;

public class RetryExecutor {
    private RetryExecutor() {
    }

    /**
     * 지정된 작업(action)을 실행하고, 작업 실행 중 지정된 예외(exceptionClasses)가 발생하면 해당 예외가 발생하지 않을 때까지 반복 실행합니다.
     *
     * @param action           실행할 작업을 나타내는 Supplier<T> 객체
     * @param exceptionClasses 작업을 반복 실행할 때 잡을 예외 클래스의 가변 매개변수
     * @param <T>              작업 결과의 타입
     * @return 작업이 성공적으로 완료된 경우 해당 작업의 결과
     * @throws Exception 작업 실행 중 발생한 예외가 exceptionClasses에 속하지 않는 경우, 해당 예외를 다시 던집니다.
     */
    @SafeVarargs
    public static <T> T execute(Supplier<T> action, Class<? extends Exception>... exceptionClasses) {
        try {
            return action.get();

        } catch (Exception e) {
            if (isExpectedException(e, exceptionClasses)) {
                System.out.println(e.getMessage());
                return execute(action, exceptionClasses);
            }

            throw e;
        }
    }

    private static boolean isExpectedException(Exception e, Class<? extends Exception>[] exceptionClasses) {
        for (Class<? extends Exception> exceptionClass : exceptionClasses) {
            if (exceptionClass.isInstance(e)) {
                return true;
            }
        }

        return false;
    }
}