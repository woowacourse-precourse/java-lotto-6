package lotto;

enum Constants {
    SAFE_ARRAY_SIZE(Integer.MAX_VALUE - 8),
    MAX_MONEY((long) (Integer.MAX_VALUE - 8) * 1000),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_COUNT(6),
    MONEY_PER_TICKET(1000),
    ERROR_MESSAGE_HEADER("[ERROR] ");

    private Long number;
    private String message;

    Constants(Integer number) {
        this.number = number.longValue();
    }

    Constants(Long number) {
        this.number = number;
    }

    Constants(String message) {
        this.message = message;
    }

    Long toLong() {
        return this.number;
    }

    Integer toInt() {
        return this.number.intValue();
    }

    public String toString() {
        if (this.message != null) {
            return this.message;

        }
        return this.number.toString();
    }
}

enum SameNumber {
    SAME0(0),
    SAME3(3),
    SAME4(4),
    SAME5(5),
    SAME5BONUS(5),
    SAME6(6);

    private Integer sameNumber;

    SameNumber(Integer sameNumber) {
        if (sameNumber >= 0 && sameNumber < 3) {
            this.sameNumber = 0;
        }
        this.sameNumber = sameNumber;
    }

    static SameNumber fromInt(int value) {
        for (SameNumber number : SameNumber.values()) {
            if (number.sameNumber == value) {
                return number;
            }
        }
        return SAME0;
    }

    static Integer toInteger(SameNumber sameNumber) {
        return sameNumber.sameNumber;
    }
}

enum Reward {
    REWARD0(0),
    REWARD3(5000),
    REWARD4(50000),
    REWARD5(1500000),
    REWARD5BONUS(30000000),
    REWARD6(2000000000);

    private Integer reward;

    Reward(Integer reward) {
        this.reward = reward;
    }

    Integer toInteger() {
        return this.reward;
    }

    static Integer fromSameNumber(SameNumber sameNumber) {
        if (sameNumber == SameNumber.SAME6) {
            return REWARD6.toInteger();
        }
        if (sameNumber == SameNumber.SAME5BONUS) {
            return REWARD5BONUS.toInteger();
        }
        if (sameNumber == SameNumber.SAME5) {
            return REWARD5.toInteger();
        }
        if (sameNumber == SameNumber.SAME4) {
            return REWARD4.toInteger();
        }
        if (sameNumber == SameNumber.SAME3) {
            return REWARD3.toInteger();
        }
        return REWARD0.toInteger();
    }
}