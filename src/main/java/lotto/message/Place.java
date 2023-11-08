package lotto.message;

public enum Place {

    NO_PLACE(0,"Unknown"),
    FIRST_PLACE(5,"6개 일치 (2,000,000,000원) - "),
    SECOND_PLACE(4,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PLACE(3,"5개 일치 (1,500,000원) - "),
    FOURTH_PLACE(2,"4개 일치 (50,000원) - "),
    FIFTH_PLACE(1,"3개 일치 (5,000원) - ");

    private final int value;
    private final String stringValue;
    Place(int value, String stringValue) {
        this.value=value;
        this.stringValue=stringValue;
    }

    public int getValue(){
        return value;
    }

    public String getStringValue(){
        return stringValue;
    }

    public static String getStringFromValue(int value) {
        for (Place number : Place.values()) {
            if (number.getValue() == value) {
                return number.getStringValue();
            }
        }
        return "Unknown";
    }
}
