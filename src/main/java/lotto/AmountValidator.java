package lotto;

/**
 * 금액을 검증하는 인터페이스
 */
public interface AmountValidator {

    boolean isValid(String input) throws IllegalArgumentException;

}
