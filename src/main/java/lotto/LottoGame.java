package lotto;

import java.text.DecimalFormat;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private List<Lotto> lottos;

    private HashMap<LottoRank.Rank, Integer> ranks;
    private IOGetter ioGetter;
    private int n_lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        this.ranks = new HashMap<>();
        initRankCounter();
        this.ioGetter = new IOGetter();
        this.n_lottos = 0;
        this.winningLotto = null;
        this.bonusNumber = 0;
    }

    public void playGame() {
        validateMoneyToLotto();
        validateMakingWinningLotto();
        validateBonusNumber();
        checkLotteryResult(n_lottos);
        makeResultView();
    }


    public void validateMoneyToLotto() {
        boolean validInput = false;
        do {
            try {
                n_lottos = moneyToLottos(ioGetter.getMoney());
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                continue;
            }
            generateLottos(lottos, n_lottos);
            ioGetter.printNLottos(n_lottos);
            printAllLottos(lottos);
        } while (!validInput);
    }

    public void validateMakingWinningLotto() {
        boolean validInput = false;
        do {
            try {
                String[] rawWinningNums = ioGetter.getWinningLotterNumbers().split(",");
                winningLotto = new Lotto(parseLotteryNumbers(rawWinningNums));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        } while (!validInput);
    }

    public void validateBonusNumber() {
        boolean validInput = false;
        do {
            try {
                bonusNumber = varifyDigit(ioGetter.getBonusNumber());
                varifyRange(bonusNumber);
                isDuplicatesLottoDigit(winningLotto.getNumbers(), bonusNumber);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        } while (!validInput);
    }

    public int moneyToLottos(String paid) {
        int money = varifyDigit(paid);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1,000원 단위 숫자를 입력해주세요");
        }
        if (money < 1000) {
            throw new IllegalArgumentException("로또 한장 최소 가격 1,000 이상의 값을 입력해주세요");
        }
        return money / 1000;
    }

    public int varifyDigit(String var) {
        try {
            return Integer.parseInt(var);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수만 입력해주세요");
        }
    }

    public void varifyRange(int number) {
        if (0 > number || number > 45) {
            throw new IllegalArgumentException("로또 최소-최대 크기를 벗어난 숫자 입력입니다");
        }
    }

    public void generateLottos(List<Lotto> lottos, int n_lottos) {
        for (int i = 0; i < n_lottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void printAllLottos(List<Lotto> lottos) {
        String[] message = new String[lottos.size()];
        for (int i = 0; i < lottos.size(); i++) {
            message[i] = lottos.get(i).toString();
        }
        ioGetter.printLottos(message);
    }

    public List<Integer> parseLotteryNumbers(String[] data) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            winningNumbers.add(varifyDigit(data[i]));
        }
        return winningNumbers;
    }

    public void isDuplicatesLottoDigit(List<Integer> list, int digit) {
        if (list.contains(digit)) {
            throw new IllegalArgumentException("보너스 번호가 로또 당첨 번호와 중복됩니다");
        }
    }

    public void checkLotteryResult(int n_lottos) {
        for (int i = 0; i < n_lottos; i++) {
            int correct = lottos.get(i).gradingLotto(winningLotto);
            boolean hasBonus = lottos.get(i).checkBonusNumber(bonusNumber);
            LottoRank.Rank r = LottoRank.Rank.getLottoResult(correct, hasBonus);
            if (r.getPrice() != 0) {
                ranks.put(r, ranks.get(r) + 1);
            }
        }
    }

    public void initRankCounter() {
        for (LottoRank.Rank rank : LottoRank.Rank.values()) {
            if (rank.price != 0) {
                ranks.put(rank, 0);
            }
        }
    }

    public void makeResultView() {
        double incomeRate = 0;
        List<String> info = new LinkedList<>();
        for (LottoRank.Rank rank : LottoRank.Rank.values()) {
            if (rank.price != 0) {
                info.add(new String(rank.message + ranks.get(rank) + "개"));
                incomeRate += rank.price * ranks.get(rank);
            }
        }
        info.add(floatValueFormatter(incomeRate / (n_lottos * 1000) * 100));
        ioGetter.printResult(info);
    }

    public String floatValueFormatter(double val) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(val);
    }

}
