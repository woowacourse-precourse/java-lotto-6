package lotto.validation;

import static lotto.system.ExceptionMessage.COMMON_VALIDATION_ERROR_MESSAGE;

public class StringValidation {
	public static void isStringCorrect(String str) {
		isStringBlank(str);
		isStringNumber(str);
		isMaxInt(str);
	}
	
	public static void isStringArrayCorrect(String[] stringArray) {
		for (String str : stringArray) {
			StringValidation.isStringCorrect(str);
		}
	}
	
	private static void isStringBlank(String str) {
		if (str.isBlank()) {
			throw new IllegalArgumentException(COMMON_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	private static void isStringNumber(String str) {
		int i=0;
		while (i!=str.length()) {
			char c = str.trim().charAt(i);
			isCharacterNumber(c);
			i++;
		}
	}
	
	private static void isCharacterNumber(char c) {
		if (!Character.isDigit(c)) {
			throw new IllegalArgumentException(COMMON_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	private static void isMaxInt(String str) {
		if (str.length()>=10) {
			throw new IllegalArgumentException(COMMON_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
}