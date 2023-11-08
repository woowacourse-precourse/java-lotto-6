package view;

public class ExceptionView {
    public ExceptionView() {
    }

    public static void OnlyNumberException() {
        throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
    }

    public static void thousandUnitException() {
        throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
    }

    public static void SeparatorException() {
        throw new IllegalArgumentException("[ERROR] 쉼표(,) 기준으로 구분합니다. 쉼표(,)를 넣어주세요.");
    }

    public static void validateDuplication() {
        throw new IllegalArgumentException("[ERROR] 같은 로또 번호가 있으면 안됩니다.");
    }

    public static void validate() {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    public static void validateRange() {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
    }
}
