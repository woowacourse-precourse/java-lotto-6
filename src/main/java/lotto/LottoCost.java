package lotto;

public class LottoCost {
    private final int cost;
    private final int ticket;

    public LottoCost(int cost) {
        isMultipleOfUnit(cost);

        this.cost = cost;
        ticket = this.cost / Config.UNIT;
    }

    public int getCost() {
        return cost;
    }

    public int getTicket() {
        return ticket;
    }

    private void isMultipleOfUnit(int cost) {
        boolean isRemainderZero = (cost >= Config.UNIT && cost < Integer.MAX_VALUE && cost % Config.UNIT == 0);

        if (!isRemainderZero) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_MULTIPLE_OF_UNIT.getMessage());
        }
    }
}
