package view;

public class ExceptionMessage {
	 private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개 입력 가능합니다.";
	 private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 금액은 0 초과이어야 합니다.";
	 private static final int LOTTO_MIN_AMOUNT = 1000;
	 private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + LOTTO_MIN_AMOUNT + "단위여야 합니다.";
	 
	 
	 
	  public static void sizeException() {
	        System.out.println(NOT_NUMBER_SIZE);
	    }
	  public static void naturalException() {
	        System.out.println(NOT_NATURAL_NUMBER_ERROR);
	    }
	  
	  public static void divisibleException() {
	        System.out.println(NOT_DIVISIBLE_NUMBER_ERROR);
	    }

}
