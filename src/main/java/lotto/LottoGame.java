package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    ////// 당첨 번호 중복 입력시 예외 처리
    public void execute() {
        int purchaseMoney = purchase();

        int purchaseLottoCount = getPurchaseLottoCount(purchaseMoney);

        List<Lotto> purchaseLottos = getPurchaseLotto(purchaseLottoCount);

        Lotto winningLotto = getWinningLotto();

        int bonusNumber = getBonusNumber(winningLotto);

        matchWinning(winningLotto, purchaseLottos, bonusNumber, purchaseMoney);
    }

    private int purchase() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseMoney;
            try {
                purchaseMoney = Integer.parseInt(Console.readLine());
                validatePurchaseMoney(purchaseMoney);
                return purchaseMoney;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getPurchaseLottoCount(int purchaseMoney) {
        int purchaseLottoCount = (purchaseMoney / 1000);
        System.out.println(purchaseLottoCount + "개를 구매했습니다.");
        return purchaseLottoCount;
    }

    protected int getBonusNumber(Lotto winningLotto) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(bonusNumber, winningLotto);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> getPurchaseLotto(int lottoCount) {
        List<Lotto> purchaseLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList();
            purchaseLottos.add(new Lotto(lottoNumbers));
        }

        for (Lotto lotto : purchaseLottos) {
            lotto.printNumber();
        }

        return purchaseLottos;
    }

    protected Lotto getWinningLotto() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String[] inputArr = Console.readLine().split(",");
                List<Integer> winningNumbers = Arrays.stream(inputArr).mapToInt(value -> Integer.parseInt(value))
                        .sorted().boxed().collect(Collectors.toList());
                return new Lotto(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void matchWinning(Lotto winningLotto, List<Lotto> purchaseLottos, int bonusNumber, int purchaseMoney) {
        HashMap<WinningLottoType, Integer> winningResultMap = matchWinningResult(winningLotto, purchaseLottos,
                bonusNumber);
        printWinningResult(winningResultMap, purchaseMoney);
    }

    protected HashMap<WinningLottoType, Integer> makeWinningResultMap() {
        HashMap<WinningLottoType, Integer> winningResultMap = new HashMap<>();
        for (WinningLottoType winningLottoType : WinningLottoType.values()) {
            winningResultMap.put(winningLottoType, 0);
        }
        return winningResultMap;
    }

    protected HashMap<WinningLottoType, Integer> matchWinningResult(Lotto winningLotto, List<Lotto> purchaseLottos,
                                                                    int bonusNumber) {
        HashMap<WinningLottoType, Integer> winningResultMap = makeWinningResultMap();
        for (Lotto purchaseLotto : purchaseLottos) {
            int matchCount = winningLotto.matchCount(purchaseLotto);
            boolean matchBonus = purchaseLotto.containBounsNumber(bonusNumber);

            WinningLottoType winningLottoType = WinningLottoType.getWinningLottoTypeByMatch(matchCount, matchBonus);
            if (winningLottoType != null) {
                int winningTypeCount = winningResultMap.get(winningLottoType);
                winningResultMap.put(winningLottoType, winningTypeCount + 1);
            }
        }
        return winningResultMap;
    }

    private void printWinningResult(HashMap<WinningLottoType, Integer> winningResultMap, int purchaseMoney) {
        int winningReward = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningLottoType winningLottoType : WinningLottoType.values()) {
            int winningCount = winningResultMap.get(winningLottoType);
            System.out.println(winningLottoType.getComment() + " - " + winningCount + "개");
            winningReward += winningLottoType.getReward() * winningCount;
        }

        printRewardRate(purchaseMoney, winningReward);
    }

    private void printRewardRate(int purchaseMoney, int reward) {
        System.out.println("총 수익률은 "
                + getRewardRate((double) purchaseMoney, (double) reward)
                + "%입니다.");
    }

    protected String getRewardRate(double purchaseMoney, double reward) {
        return new DecimalFormat("0.0").format(reward * 100.0 / purchaseMoney);
    }

    protected void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000단위 숫자여야 합니다.");
        }
    }

    protected void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningLotto.containBounsNumber(bonusNumber) == true) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자와 중복된 숫자입니다.");
        }
    }
}