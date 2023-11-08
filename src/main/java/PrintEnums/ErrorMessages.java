package PrintEnums;

public enum ErrorMessages {
    OUTPUT_ERROR("[ERROR] "),
    OUTPUT_DUPLICATE("입력 값에 중복값이 있습니다."),
    OUTPUT_ERROR_THOUSAND("1000원으로 나누어 떨어지게 자료를 입력하셔야 합니다."),
    // 구입 금액 입력부분 확인
    OUTPUT_ERROR_OUTOFRANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    //필수
    OUTPUT_ERROR_OUTOFLENGTH("입력 값의 길이를 확인해주세요."),
    // 보너스 번호, 당첨번호 공통 확인 OUTPUT_ERROR
    // print 출력값 포장할 것
    OUTPUT_ERROR_OUTOFTYPE("보너스 숫자가 중복된 값인지 확인해주세요."),
    OUTPUT_ERROR_OUTOFNUMBER("숫자만 입력해주세요.");

    final private String PrintInterface;

    public String getErrorMessage() {
        return PrintInterface;
    }

    ErrorMessages(String printInterface) {
        this.PrintInterface = printInterface;
    }
}
