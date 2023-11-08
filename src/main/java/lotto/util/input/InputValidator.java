package lotto.util.input;

public interface InputValidator {
    /**
     * 입력으로 받은 데이터를 반환하는 메서드
     */
    Object sendInputData();

    /**
     * 입력 받은 값의 유효성을 검사하는 메서드
     */
    void validate();
}
