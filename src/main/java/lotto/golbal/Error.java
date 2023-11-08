package lotto.golbal;

public enum Error {
    MONEY_INPUT_REQUEST_ERROR_MESSAGE("[ERROR] 1000으로 나누어 떨어지는 정수로 재입력 해주세요\""),
    WINNING_NUMBERS_INPUT_REQUEST_ERROR_MESSAGE("[ERROR] 6가지 로또 번호를 똑바로 입력해 주세요") ,
    BONUS_NUMBERS_INPUT_REQUEST_ERROR_MESSAGE("[ERROR] 중복되지 않는 정확한 숫자를 입력해 주세요");

    private String type;
    Error(String type){ this.type = type; }
    public String getType(){ return type ;}

}
