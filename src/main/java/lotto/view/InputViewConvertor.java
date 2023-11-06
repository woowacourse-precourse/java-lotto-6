package lotto.view;

class InputViewConvertor {

    public static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionMessages.NOT_A_NUMBER.getMessage());
        }
    }

}
