package lotto.view;

public abstract class View{
    protected final static String INPUT_ERROR_MSG = "유효하지 않은 입력입니다. 다시 시도하세요.";
    protected final static String ERROR_MSG = "[ERROR] ";

    protected static void printView(String text){
        System.out.println(text);
    }

}
