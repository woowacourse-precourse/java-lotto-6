package lotto;

public class LottoCost {
    final static int UNIT = 1000;
    final int cost;
    final int ticket;

    public LottoCost(String cost) {
        isNumber(cost);
        isMultipleOfUnit(cost);

        this.cost = Integer.parseInt(cost);
        ticket = this.cost / UNIT;
    }

    public int getCost() {
        return cost;
    }

    public int getTicket() {
        return ticket;
    }

    private void isNumber(String cost) {
        boolean hasOnlyNum = !cost.isEmpty() && cost.chars().allMatch(Character::isDigit);

        if (!hasOnlyNum) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
        }
    }

    private void isMultipleOfUnit(String cost) {
        int costValue = Integer.parseInt(cost);
        boolean isRemainderZero
                = (costValue >= LottoCost.UNIT && costValue < Integer.MAX_VALUE && costValue % LottoCost.UNIT == 0);

        if (!isRemainderZero) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_MULTIPLE_OF_UNIT.getMessage());
        }
    }
}
