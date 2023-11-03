package lotto;

public class LottoCost {
    String cost = "";

    public int getLottoCost() {
        Input input = new Input();
        cost = input.buyLotto();

        if (!isNumber(cost)) {
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
}
