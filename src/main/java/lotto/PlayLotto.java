package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class PlayLotto {
    public void Play() {
        int purchase_money = Input_Lotto();

        int purchase_number = Purchase_Lotto_Count(purchase_money);

        List<Lotto> random_lotto = Random_Lotto(purchase_number);

        Lotto winningLotto = Input_Winning_Lotto();

        int bonusNumber = Input_BonusNumber(winningLotto);

        matchWinning(winningLotto, random_lotto, bonusNumber, purchase_money);
    }
    private int Input_Lotto() {
        while(true) {
            System.out.println("구입금액을 입력해 주세요");
            int purchase_money;
            try {
                purchase_money = Integer.parseInt(Console.readLine());
                validate_Money(purchase_money);
                return purchase_money;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    protected void validate_Money(int purchase_money) {
        if(purchase_money %1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위여야 합니다.");
        }
    }

    private int Purchase_Lotto_Count(int purchase_money) {
        int purchase_number = (purchase_money / 1000);
        System.out.println(purchase_number + "개를 구매했습니다.");
        return purchase_number;
    }

    public List<Lotto> Random_Lotto(int lotto_count) {
        List<Lotto> random_lotto = new ArrayList<>();
        for(int i = 0; i < lotto_count; i++) {
            List<Integer> lotto_number = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList();
            random_lotto.add(new Lotto(lotto_number));
        }
        for (Lotto lotto : random_lotto) {
            lotto.Output_Number();
        }
        return random_lotto;
    }
    protected Lotto Input_Winning_Lotto() {
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try{
                String[] inputArr = Console.readLine().split(",");
                List<Integer> winning_number = Arrays.stream(inputArr).mapToInt(value -> Integer.parseInt(value))
                        .sorted().boxed().collect(Collectors.toList());
                return new Lotto(winning_number);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected int Input_BonusNumber(Lotto winning_lotto) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int bonus_number = Integer.parseInt(Console.readLine());
                validate_BonusNumber(bonus_number, winning_lotto);
                return bonus_number;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    protected void validate_BonusNumber(int bonus_number, Lotto winning_lotto) {
        if (bonus_number < 1 || bonus_number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winning_lotto.contain_Bouns_Number(bonus_number) == true) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }
    }

    private void Output_Winning_Result(HashMap<LottoStatics, Integer> winningResultMap, int purchaseMoney) {
        int winningReward = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoStatics winningLottoType : LottoStatics.values()) {
            int winningCount = winningResultMap.get(winningLottoType);
            System.out.println(winningLottoType.getComment() + " - " + winningCount + "개");
            winningReward += winningLottoType.getReward() * winningCount;
        }

        Output_Reward_Rate(purchaseMoney, winningReward);
    }
    private void matchWinning(Lotto winningLotto, List<Lotto> purchaseLottos, int bonus_number, int purchase_money) {
        HashMap<LottoStatics, Integer> winningResultMap = matchWinningResult(winningLotto, purchaseLottos,
                bonus_number);
        Output_Winning_Result(winningResultMap, purchase_money);
    }

    protected HashMap<LottoStatics, Integer> makeWinningResultMap() {
        HashMap<LottoStatics, Integer> winningResultMap = new HashMap<>();
        for (LottoStatics winningLottoType : LottoStatics.values()) {
            winningResultMap.put(winningLottoType, 0);
        }
        return winningResultMap;
    }

    protected HashMap<LottoStatics, Integer> matchWinningResult(Lotto winning_lotto, List<Lotto> purchaseLottos,
                                                                    int bonus_number) {
        HashMap<LottoStatics, Integer> winningResultMap = makeWinningResultMap();
        for (Lotto purchaseLotto : purchaseLottos) {
            int matchCount = winning_lotto.matchCount(purchaseLotto);
            boolean matchBonus = purchaseLotto.contain_Bouns_Number(bonus_number);

            LottoStatics winningLottoType = LottoStatics.getWinningLottoTypeByMatch(matchCount, matchBonus);
            if (winningLottoType != null) {
                int winningTypeCount = winningResultMap.get(winningLottoType);
                winningResultMap.put(winningLottoType, winningTypeCount + 1);
            }
        }
        return winningResultMap;
    }
    private void Output_Reward_Rate(int purchaseMoney, int reward) {
        System.out.println("총 수익률은 " + getRewardRate((double) purchaseMoney, (double) reward) + "%입니다.");
    }
    protected String getRewardRate(double purchaseMoney, double reward) {
        return new DecimalFormat("0.0").format(reward * 100.0 / purchaseMoney);
    }

}
