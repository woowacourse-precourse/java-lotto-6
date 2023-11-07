package lotto;

public class DataValidator {
    private static DataValidator dataValidator;

    private DataValidator() {}

    public static DataValidator getDataValidator() {
        if (dataValidator == null) {
            dataValidator = new DataValidator();
        }
        return dataValidator;
    }

}
