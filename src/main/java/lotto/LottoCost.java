package lotto;

public class LottoCost {
    String cost = "";

    public int getLottoCost() {
        Input input = new Input();
        cost = input.buyLotto();

        if (!isNumber(cost)) {
            getLottoCost();
        }

        if (!isMultipleOfThousand(cost)) {
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

    public boolean isMultipleOfThousand(String cost) {
        int costValue = Integer.parseInt(cost);
        boolean isRemainderZero = (costValue != 0 && costValue % 1000 == 0);

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
