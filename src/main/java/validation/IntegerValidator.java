package validation;

public class IntegerValidator {

    private IntegerValidator() {
    }

   // 정수의 범위를 validate
    public static void checkRange(final int num, final int begin, final int end) {
        if (num < begin || num > end) {
            throw new IllegalArgumentException("[ERROR] : 입력 범위는 " + begin + " 에서 " + end + "사이의 값이어야합니다." );
        }
    }

    public static void checkRemainderZero(final int num, final int divisor) {
      if(num % divisor != 0) {
        throw new IllegalArgumentException("[ERROR] : " + divisor + "단위로 입력해 주세요.");
      }
    }
}
