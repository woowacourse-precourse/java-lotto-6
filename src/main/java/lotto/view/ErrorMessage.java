package lotto.view;

public interface ErrorMessage {
    String NOT_NUMBER = "[ERROR] 숫자가 아닙니다.";

    String FORMAT_ERROR = "[ERROR] 숫자는 1 ~ 45 이내의 숫자만 가능합니다.";

    String NUMBER_EQUALS = "[ERROR] 숫자가 중복됩니다.";

    String NUMBER_SIZE_ERROR = "[ERROR] 숫자는 6개의 숫자를 작성하셔야합니다.";

    String MONEY_ERROR = "[ERROR] 금액은 1000원 단위로 작성해주세요";
}
