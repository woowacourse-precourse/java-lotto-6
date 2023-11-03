package lotto;

class ExceptionManager {
    private static final String ERROR_BEGIN = "[ERROR] ";

    public static void throwIllegalArgumentExceptionWithMsg(String mag) {
        throw  new IllegalArgumentException(ERROR_BEGIN + mag);
    }
}
