package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int money = inputMoney();
        List<Integer> lotto = inputLotto();
        int bonus_lotto = inputBonusLotto(lotto);
    }

    public static Integer inputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요");
            String input = Console.readLine();
            try {
                int money = Integer.parseInt(input);
                try {
                    checkMoneyUnit(money);
                    return money;
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 구입 금액은 1000원 단위로 이루어져야 합니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 정수로만 이루어져야 합니다.");
            }
        }
    }

    public static void checkMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> inputLotto() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                List<String> lotto = List.of(input.split(","));
                List<Integer> winning_lotto = lotto.stream().map(x -> Integer.parseInt(x))
                        .collect(Collectors.toList());
                try {
                    checkLottoSize(winning_lotto);
                    try {
                        checkWinningLottoRange(winning_lotto);
                        try {
                            checkWinningLottoDuplicate(winning_lotto);
                            return winning_lotto;
                        } catch (IllegalArgumentException e) {
                            System.out.println("[ERROR] 당첨 로또는 중복되지 않은 수여야 합니다.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("[ERROR] 당첨 로또는 1에서 45 사이 정수여야 합니다.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 당첨 로또는 6개의 정수여야 합니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 로또는 정수여야 합니다.");
            }
        }
    }

    public static void checkLottoSize(List<Integer> lotto) {
        if (lotto.size() < 1 || lotto.size() > 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoRange(int lotto_number) {
        if (lotto_number < 0 || lotto_number > 45) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkWinningLottoRange(List<Integer> lotto) {
        for (int i : lotto) {
            checkLottoRange(i);
        }
    }

    public static Integer removeLottoDuplicateSize(List<Integer> lotto) {
        return lotto.stream().distinct().collect(Collectors.toList()).size();
    }

    public static void checkWinningLottoDuplicate(List<Integer> lotto) {
        if (lotto.size() != removeLottoDuplicateSize(lotto)) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer inputBonusLotto(List<Integer> lotto) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                Integer bonus_lotto = Integer.parseInt(input);
                try {
                    checkLottoRange(bonus_lotto);
                    try {
                        checkBonusLottoDuplicate(lotto, bonus_lotto);
                        return bonus_lotto;
                    } catch (IllegalArgumentException e) {
                        System.out.println("[ERROR] 보너스 로또는 중복되지 않은 수여야 합니다.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 보너스 로또는 1에서 45 사이 정수여야 합니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 로또는 정수여야 합니다.");
            }
        }
    }

    public static void checkBonusLottoDuplicate(List<Integer> lotto, int bonus_lotto) {
        if (lotto.contains(bonus_lotto)) {
            throw new IllegalArgumentException();
        }
    }
}
