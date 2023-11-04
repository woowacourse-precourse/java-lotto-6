package lotto;

public class LottoCost {
    final static int UNIT = 1000;
    final int cost;
    final int ticket;

    public LottoCost(String cost) {
        isNumber(cost);
        isMultipleOf(UNIT, cost);

        this.cost = Integer.parseInt(cost);
        ticket = this.cost / UNIT;
    }

    public int getCost() {
        return cost;
    }

    public int getTicket() {
        return ticket;
    }

    public void isNumber(String cost) {
        boolean hasOnlyNum = !cost.isEmpty() && cost.chars().allMatch(Character::isDigit);

        if (!hasOnlyNum) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
        }
    }

    public void isMultipleOf(int unit, String cost) {
        int costValue = Integer.parseInt(cost);
        boolean isRemainderZero
                = (costValue >= unit && costValue < Integer.MAX_VALUE && costValue % unit == 0);

        if (!isRemainderZero) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_MULTIPLE_OF_UNIT.getMessage());
        }
    }
}
