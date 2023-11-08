package lotto.domain;

import lotto.userinterface.UserView;
import lotto.data.Lotto;
import lotto.data.Rewards;

import java.util.*;

public class ViewProcessor {

    private static final LottoModel lottomodel = new LottoModel();
    private static final UserView userView = new UserView();
    private static List<Integer> winningNums = new ArrayList<>();

    private int bonusNum;
    private int cost;
    private HashMap<Rewards, Integer> winningTable;

    enum MagicNums {

        INIT_NUM(0),
        LOTTONUM_MIN_RANGE(1),
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

    public boolean bonusBall(String tempBonus) {
        try {
            checkValidBonusNum(tempBonus);
            lottomodel.computeLotto(winningNums,bonusNum);
            return States.STATE_SUCESS.getState();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return States.STATE_FALSE.getState();
        }
    }


    public void totalResult() {
        HashMap<Rewards,Integer> winningTable = lottomodel.getWinningTable();
        String computedRate = lottomodel.computeRate(lottomodel.getTotalEarnedMoney(),cost);
        List<String> resultWinningTable = makeResult(winningTable);
        userView.totalResult(resultWinningTable, computedRate);
    }

    public List<String> makeResult(HashMap<Rewards, Integer> resultAll) {
        Rewards[] rewards = Rewards.values();
        List<String> result = new ArrayList<>();
        Arrays.sort(rewards, Collections.reverseOrder());

        for (Rewards reward : rewards) {
            String message = String.format("%s %s - %d개", reward.getNotifyMessege(),
                    moneyEdit(reward), resultAll.get(reward));
            result.add(message);
        }
        return result;
    }


    public void checkRange(int num) {
        if (num < MagicNums.LOTTONUM_MIN_RANGE.getValue()
                || num > MagicNums.LOTTONUM_MAX_RANGE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean checkIsNull(String inputStr) {
        if (inputStr == null || inputStr.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 사용자 입력 값이 null");
        }
        return true;
    }

    public void checkExist(List<Integer> winningNums, int num) {
        if (winningNums.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 입력 값과 중복되는 숫자가 이미 존재합니다.");
        }
    }

    public void checkLengthWinning(List<String> parsedWinnings) {
        if (parsedWinnings.size() != MagicNums.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
        }
    }

    public void checkValidBonusNum(String tempBonus) {
        try {
            int bonusNum = Integer.parseInt(tempBonus);
            checkRange(bonusNum);
            checkExist(winningNums,bonusNum);
            this.bonusNum = bonusNum;
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
                    "[ERROR] 구입 금액은 " + MagicNums.PURCHASE_MIN.getValue() + "원 초과해야 합니다."
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

    public List<String> parsingWinnings(String inputWinnings) {
        try {
            checkIsNull(inputWinnings);
            List<String> parsedWinnings = Arrays.asList(inputWinnings.split(","));
            checkLengthWinning(parsedWinnings);
            return parsedWinnings;

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void makeWinningNums(List<String> parsedWinnings) {
        try {
            for (String element : parsedWinnings) {
                int winning = Integer.parseInt(element);
                checkRange(winning);
                checkExist(winningNums, winning);
                winningNums.add(winning);
            }
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

    public boolean winnings(String inputWinnings) {
        try {
            List<String> parsedWinnings = parsingWinnings(inputWinnings);
            makeWinningNums(parsedWinnings);
            return States.STATE_SUCESS.getState();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return States.STATE_FALSE.getState();
        }
    }


}
