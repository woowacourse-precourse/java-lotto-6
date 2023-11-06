package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Lotto.lottoRangeFirstNum;
import static lotto.Lotto.lottoRangeLastNum;

public class Draw {

    public Lotto enterWinningLottoNums() {
        Lotto winningLotto;

        while (true) {
            try {
                List<Integer> winningLottoNums = getWinningLottoNumsList();
                winningLotto = new Lotto(winningLottoNums);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    public int enterBonusNum(Lotto winningLotto) {
        int bonusNum;
        while (true) {
            try {
                String input = Console.readLine();
                bonusNum = toInt(input);
                isWithinRange(bonusNum);
                isDuplicate(winningLotto, bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }

    void isWithinRange(int num) {
        if (!(num >= lottoRangeFirstNum && num <= lottoRangeLastNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45입니다.");
        }
    }

    void isDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 입력한 로또 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> getWinningLottoNumsList() {
        printWinningLottoNumsEnterGuideStatement();
        String input = Console.readLine();
        String[] strings = input.split(",");
        return toIntList(strings);
    }

    List<Integer> toIntList(String[] strings) {

        List<Integer> nums = new ArrayList<>();

        for (String str : strings) {
            nums.add(toInt(str));
        }

        return nums;
    }

    int toInt(String str) {
        isInt(str);
        return Integer.parseInt(str);
    }

    void isInt(String str) {
        String regex = "^[0-9]+$";
        if (!str.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private void printWinningLottoNumsEnterGuideStatement() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public List<Lotto> issueLottos(int num) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(pickedNumbers));
        }

        return lottos;
    }
}
