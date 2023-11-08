package lotto.common;

public interface LottoFinalConsts {
    String LOTTO_FIRST = "6";
    String LOTTO_SECOND = "5+1";
    String LOTTO_THIRD = "5";
    String LOTTO_FOURTH = "4";
    String LOTTO_FIFTH = "3";
    int LOTTO_FIRST_RETURN = 2000000000;
    int LOTTO_SECOND_RETURN = 50000000;
    int LOTTO_THIRD_RETURN = 1500000;
    int LOTTO_FOURTH_RETURN = 50000;
    int LOTTO_FIFTH_RETURN = 5000;
    int VARIABLE_FORMAT = 0;
    int LOTTO_RANDOM_RANGE_START = 1;
    int LOTTO_RANDOM_RANGE_END = 45;
    int LOTTO_RANDOM_COUNT = 6;
    int LOTTO_PURCHASE_DIVIDABLE = 1000;
    int LOTTO_RETURN_PERCENTAGE_COMPUTE = 100;
    int LOTTO_RANK_IS_SECOND_OR_THIRD = 5;
    int LOTTO_LOSE_LIMIT = 3;
    int ADD_COUNT_ONE = 1;

    String INPUT_LOTTO_PURCHASE = "구입금액을 입력해 주세요.";
    String PRINT_LOTTO_PURCHASE_COUNT = "개를 구매했습니다.";
    String INPUT_WIN_LOTTO = "당첨 번호를 입력해 주세요.";
    String INPUT_BONUS_LOTTO = "보너스 번호를 입력해 주세요.";
    String LOTTO_FIRST_PRINT = "6개 일치 (2,000,000,000원) - %d개 \n";
    String LOTTO_SECOND_PRINT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개 \n";
    String LOTTO_THIRD_PRINT = "5개 일치 (1,500,000원) - %d개 \n";
    String LOTTO_FOURTH_PRINT = "4개 일치 (50,000원) - %d개 \n";
    String LOTTO_FIFTH_PRINT = "3개 일치 (5,000원) - %d개 \n";
    String LOTTO_RETURN_RATE_PRINT = "총 수익률은 %s입니다.";
    String LOTTO_RETURN_RATE_FORMAT = "%.1f";
    String PERCENTAGE = "%";
    String PRINT_LOTTO_PURCHASE = "%d%s";
    String ERROR_MESSAGE_FORMAT = "%s%s \n";
    String LOTTO_WINNING_SPLIT = ",";

    String LOTTO_ERROR_MESSAGE = "[ERROR] ";
    String LOTTO_NOT_VALID_LOTTOPURCHASE = "구입 금액이 1000으로 나눠 떨어지지 않습니다.";
    String LOTTO_HAS_DUPLICATED = "로또 번호에 중복이 존재합니다.";
    String LOTTO_WINNING_HAS_DUPLICATED = "로또 번호에 중복이 존재합니다.";
    String LOTTO_RANGE_OUT_OF_BOUNDS = "로또 번호가 6개가 아닙니다.";
    String LOTTO_CANNOT_SPLIT_WINNING = "당첨번호 쉼표(,)로 구분되어 있지 않습니다.";
    String LOTTO_BONUS_NUMBER_ALREADY_EXIST = "보너스 번호가 이미 당첨번호에 존재합니다.";
    String LOTTO_NUMBER_OUT_OF_RANGE = "로또 번호는 1~45까지의 숫자여야합니다.";
    String LOTTO_ALREADY_EXIST = "랜덤 발행한 로또가 이미 존재합니다. 다시 뽑기를 진행합니다";

}
