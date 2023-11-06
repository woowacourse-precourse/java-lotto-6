package constant;

public enum ConstantNumber {
    MINIMUM_WINNING_NUMBER(1),
    MAXIMUM_WINNING_NUMBER(45),
    WINNING_NUMBER_COUNT(6),
    COUNT_OF_WINNING_PRIZE(5),
    MATCHING_COUNT_RANK_2(5),
    LOTTO_TICKET_COST(1000),
    ;

    private final int number;

    ConstantNumber(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}
