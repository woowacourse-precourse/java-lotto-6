package lotto;

public class LottoCost {
    String cost = "";

    public int getLottoCost() {
        Input input = new Input();
        cost = input.buyLotto();

        if (!isNumber(cost)) {
            getLottoCost();
        }

        int costValue = Integer.parseInt(cost);

        if (!isMultipleOfThousand(costValue)) {
            getLottoCost();
        }

        return Integer.parseInt(cost);
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

    public boolean isMultipleOfThousand(int costValue) {
        boolean isRemainderZero = (costValue % 1000 == 0);

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
