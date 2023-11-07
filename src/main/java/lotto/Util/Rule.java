package lotto.Util;

import java.util.regex.Pattern;

public class Rule {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int MAX_LENGTH = 6;
    public static final int MIN_LENGTH = 1;
    public static final int BONUSNUM_LENGTH = 1;
    public static final int ZERO = 0;
    public static final int THOUSAND = 1000;

    //패턴
    public static final Pattern LottoNumberPattern = Pattern.compile("^[1-9][0-9]*$");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    public static final Pattern WINNUNG_PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");

    //메시지(INPUT)
    public static final String INPUTWINNINGNUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUTBUY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUTBONUSNUM_MESSAGE = "보너스 번호를 입력해 주세요.";
    //메시지(OUTPUT)
    public static final String OUTPUTLOTTOCOUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final String OUTPUTWINNING_MESSAGE = "당첨 통계\" + NEWLINE + \"---\"";
    public static final String OUTPUTLOTTORESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    public static final String OUTPUTBONUSMATCH_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String OUTPUTRATE_MESSAGE = "총 수익률은 %.1f%%입니다.";


    //에러
    public static final String ERROR ="[ERROR]";
    public static final String LOTTO_NUM_DUPLICATE_ERROR = ERROR + "중복된 숫자가 포함되어있습니다";
    public static final String LOTTO_NUM_RANGE = ERROR + MIN_NUMBER + "부터" + MAX_NUMBER + "까지의 숫자만 입력가능합니다.";
    public static final String LOTTO_NUM_SIZE_ERROR = ERROR + "6개의 번호를 입력해야 합니다";
    public static final String NOTNUMBER_PATTERN = ERROR + "당첨번호의 입력 형식이 맞지 않습니다.";
    public static final String LOTTO_BUY_ERROR = ERROR + "1000원 단위의 금액만 입력할 수 있습니다";
    public static final String MONEYZERO_ERROR = ERROR + "0원은 입력할 수 없습니다.";
    public static final String DIVIDEMONEY_ERROR = ERROR + "1000원으로 나눠떨어지지 않습니다.";

 }
