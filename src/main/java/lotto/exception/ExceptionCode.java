package lotto.exception;

import java.util.function.Function;
import java.util.function.Supplier;

public enum ExceptionCode {
    NO_EXIST_ENTITY("[ERROR] 엔티티가 존재하지 않습니다.", IllegalStateException::new),
    INVALID_PURCHASE_PRICE("[ERROR] 잘못된 구입금액입니다. 다시 입력해주세요.", IllegalArgumentException::new),
    INVALID_LOTTO_NUMBER("[ERROR] 잘못된 로또 번호입니다. 다시 입력해주세요", IllegalArgumentException::new),
    INVALID_BONUS_NUMBER("[ERROR] 잘못된 보너스 번호입니다. 다시 입력해주세요", IllegalArgumentException::new);


    private final String message;
    private final Function<String, ? extends RuntimeException> constructorOfException;
    
    ExceptionCode(final String message, Function<String, ? extends RuntimeException> constructorOfException) {
        this.message = message;
        this.constructorOfException = constructorOfException;
    }
    
    /**
     * 지정된 예외를 메세지와 함께 발생시킨다.
     */
    public void throwException() {
        throwException(this.constructorOfException);
    }
    
    /**
     * RuntimeException을 상속받는 예외 클래스의 생성자를 인자로 받아서, 예외 메세지를 해당 생성자의 인자로 전달해 예외를 발생시킨다.
     *
     * @param constructorOfException 발생시키고 싶은 예외의 생성자
     */
    public void throwException(Function<String, ? extends RuntimeException> constructorOfException) {
        throw constructorOfException.apply(message);
    }

    /**
     *  Optional.orElseThrow()의 방식으로 예외를 발생시키기 위한 메서드
     * @return 열거형의 메세지를 인자로 받는 예외 클래스 생성자를 Supplier 메서드 타입으로 반환한다..
     */
    public Supplier<? extends RuntimeException> getConstructorWithMessage() {
        return () -> constructorOfException.apply(message);
    }
}