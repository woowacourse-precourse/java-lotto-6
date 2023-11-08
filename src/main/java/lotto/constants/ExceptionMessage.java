package lotto.constants;

public class ExceptionMessage {
    public static final String DUPPLICATE_BONUS_AND_WINNER = "보너스 번호는 당첨 번호와 같을 수 없습니다.";
    public static final String BONUS_OUT_RANGE = "보너스 번호는 %d 부터 %d 이내입니다.";
    public static final String LOTTO_LENGTH_OUT_RANGE = "[ERROR] %d개로 로또를 생성하려 했습니다. 로또의 번호는 6개 입니다";
    public static final String LOTTO_DUPPLICATE_NUMBER = "[ERROR] 로또의 번호는 중복될 수 없습니다.";
    public static final String LOTTO_OUT_RANGE = "로또 번호는 %d 부터 %d 이내입니다.";
    public static final String MONEY_NOT_DIVIDED = "로또 구입 금액은 %d원 단위입니다.";
    public static final String MONEY_OUT_RANGE = "로또 최소 구입 금액은 %d원 입니다.";
    public static final String NULL_INPUT_EXCEPTION = "사용자의 입력이 null 입니다.";
    public static final String EMPTY_INPUT_EXCEPTION = "사용자의 입력이 비어있습니다.";
    public static final String NUMBER_NOT_INTGER = "양의 정수만 입력해주세요, 번호는 '%s'로 구분";
    public static final String NUMBER_OUT_BOUNDARY = "최소 1원 이상, 1억원 미만으로 입력해주세요";
    public static final String INTEGER_OUT_BOUNDARY = "int의 범위를 벗어났습니다.";

}
