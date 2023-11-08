package lotto.Exception;

public class ShouldNotCreatedClassException extends IllegalStateException{
    public ShouldNotCreatedClassException() {
        super("[ERROR] 객체 생성이 되어선 안되는 정적 클래스 입니다.");
    }
}
