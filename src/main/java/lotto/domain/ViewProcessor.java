package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.UserView;
import lotto.data.Lotto;
import lotto.data.Rewards;

import java.util.ArrayList;
import java.util.List;

public class ViewProcessor {

    private static final LottoModel lottomodel = new LottoModel();
    private static final UserView userView = new UserView();

    private int bonusNum;
    private int cost;
    private List<Integer> winningNums;

    enum MagicNums {

        INIT_NUM(0),
        LOTTONUM_MIN_RANGE(0),
        LOTTONUM_MAX_RANGE(45),
        LOTTO_LENGTH(6),
        PURCHASE_MIN(0),
        PURCHASE_UNIT(1000);

        private final int value;

        MagicNums(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    enum States {
        STATE_SUCESS(false),
        STATE_FALSE(true);

        private final boolean state;

        States(boolean state) {
            this.state = state;
        }

        public boolean getState() {
            return state;
        }
    }

    public ViewProcessor() {
        this.bonusNum = MagicNums.INIT_NUM.getValue();
        this.cost = MagicNums.INIT_NUM.getValue();
    }

    public void bonusBall() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String tempBonus = Console.readLine().trim();
                this.bonusNum = checkValidBonusNum(tempBonus);
                break;
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public void checkExceptionWinning(int winning) {
        if (winning < MagicNums.LOTTONUM_MIN_RANGE.getValue()
                || winning > MagicNums.LOTTONUM_MAX_RANGE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void checkLengthWinning(String[] parsedWinnings) {
        if (parsedWinnings.length != MagicNums.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
        }
    }

    public int checkValidBonusNum(String tempBonus) {
        try {
            int bonusNum = Integer.parseInt(tempBonus);
            if (bonusNum >= MagicNums.LOTTONUM_MIN_RANGE.getValue()
                    && bonusNum <= MagicNums.LOTTONUM_MAX_RANGE.getValue()) {
                return bonusNum;
            }
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
    }

    public void checkValidPurchase(String tempCost) {
        try {
            int invalidCost = Integer.parseInt(tempCost);
            checkRangePurchase(invalidCost);
            checkUnitPurchase(invalidCost);
            cost = invalidCost;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
    }

    public void checkRangePurchase(int invalidCost) {
        if (invalidCost <= MagicNums.PURCHASE_MIN.getValue()) {
            throw new IllegalArgumentException(
                    "[ERROR] 구입 금액은 " + MagicNums.PURCHASE_MIN.getValue() + "원 이상이여야 합니다."
            );
        }
    }

    public void checkUnitPurchase(int invalidCost) {
        if (invalidCost % MagicNums.PURCHASE_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 구입 금액은 " + MagicNums.PURCHASE_UNIT.getValue() + "원 단위여야 합니다."
            );
        }
    }

    public List<Integer> checkValidWinnings(String[] parsedWinnings) {
        try {
            List<Integer> winningNum = new ArrayList<>();
            checkLengthWinning(parsedWinnings);
            for (String element : parsedWinnings) {
                int winning = Integer.parseInt(element);
                checkExceptionWinning(winning);
                winningNum.add(winning);
            }
            return winningNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수여야 합니다.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public String moneyEdit(Rewards reward) {
        int money = reward.money();
        String beforeEdit = Integer.toString(money);
        String reversedEdit = new StringBuilder(beforeEdit).reverse().toString();
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < reversedEdit.length(); i++) {
            if (i > 0 && i % 3 == 0) {
                formatted.append(",");
            }
            formatted.append(reversedEdit.charAt(i));
        }
        String result = "(" + formatted.reverse().toString() + "원)";
        return result;
    }

    public int getCost() {
        return cost;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public List<Integer> getWinningNums() {
        List<Integer> copiedWinningNums = new ArrayList<>();
        copiedWinningNums.addAll(winningNums);
        return copiedWinningNums;
    }

    public boolean purchase(String tempCost) {
        try {
            checkValidPurchase(tempCost);
            int numOfLotto = cost / MagicNums.PURCHASE_UNIT.getValue();
            List<Lotto> publishedLottos = lottomodel.publishLotto(numOfLotto);
            userView.purchaseLog(numOfLotto, publishedLottos);
            return States.STATE_SUCESS.getState();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return States.STATE_FALSE.getState();
        }
    }

    public void winnings() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputWinnings = Console.readLine();
                String[] parsedWinnings = inputWinnings.split(",");
                winningNums = checkValidWinnings(parsedWinnings);
                break;
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }


}
