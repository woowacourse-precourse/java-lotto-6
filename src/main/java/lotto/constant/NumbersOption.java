package lotto.constant;

import java.util.regex.Pattern;

public class NumbersOption {
	public static final int SIZE = 6;
	public static final int MAX = 45;
	public static final int MIN = 1;
	public static final String SEPARATOR = ",";

	//숫자만 허용
	public static final Pattern ONLY_NUMBER = Pattern.compile("^[\\d]*$");
	// 1~45 사이의 숫자만 허용
	public static final Pattern NUMBER_RANGE = Pattern.compile("^[1-9]$|^[0-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$");
}
