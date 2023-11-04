package lotto;

public class LottoCost {
    final static int UNIT = 1000;

    public int getNumberOfPurchase() {
        Input input = new Input();
        String cost = input.buyLotto();
        boolean isValidated = isNumber(cost) && isMultipleOf(UNIT, cost);

        while (!isValidated) {
            cost = input.buyLotto();
            if (isNumber(cost) && isMultipleOf(UNIT, cost)) {
                isValidated = true;
            }
        }

        return Integer.parseInt(cost) / UNIT;
    }

    public boolean isNumber(String cost) {
        boolean hasOnlyNum = !cost.isEmpty() && cost.chars().allMatch(Character::isDigit);

        if (!hasOnlyNum) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
            }
        }

        return hasOnlyNum;
    }

    public boolean isMultipleOf(int unit, String cost) {
        int costValue = Integer.parseInt(cost);
        boolean isRemainderZero
                = (costValue >= unit && costValue < Integer.MAX_VALUE && costValue % unit == 0);

        if (!isRemainderZero) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessages.ERROR_NOT_MULTIPLE_OF_THOUSAND.getMessage());
            }
        }

        return isRemainderZero;
    }
}
