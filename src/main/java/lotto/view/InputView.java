package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.exception.InputLottoException;
import lotto.exception.InputNumberException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public static LottoMoney showMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String read = Console.readLine();
            try {
                int num = Integer.parseInt(read);
                validateNum(num);
                int count = num / 1000;
                LottoMoney lottoMoney = new LottoMoney(num, count);
                return lottoMoney;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 금액을 입력하셨습니다.");
                continue;
            }
        }
    }

    public static void validateNum(int num) {
        if (num % 1000 != 0) {
            throw new InputNumberException();
        }
    }

    public static void viewNumber(LottoMoney lottoMoney) {
        System.out.println();
        for (List<Integer> number : lottoMoney.getNumbers()) {
            System.out.println(number);
        }
        System.out.println();
    }

    public static Lotto insertLottoNum() {
        while (true) {
            System.out.println("당첨번호를 입력해 주세요.");
            String readLine = Console.readLine();
            try {
                validateLottoNum(readLine);
                List<Integer> list = numToList(readLine);
                return new Lotto(list);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    public static void insertBonusNum(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String readLine = Console.readLine();
            try {
                validateBonusNum(readLine, lotto);
                int num = Integer.parseInt(readLine);
                numbers.add(num);
                return;
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    public static void validateBonusNum(String s, Lotto lotto) {
        if (Integer.parseInt(s) < 1 || Integer.parseInt(s) > 45) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new InputLottoException();
        }
        if (lotto.getNumbers().contains(Integer.parseInt(s))) {
            System.out.println("[ERROR] 로또 번호는 중복 되면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> numToList(String readLine) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        String[] split = readLine.split(",");
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    public static void validateLottoNum(String readLine) {
        String[] split = readLine.split(",");
        oneToFourFive(split);
    }

    public static void oneToFourFive(String[] split) {
        for (String s : split) {
            if (Integer.parseInt(s) < 1 || Integer.parseInt(s) > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new InputLottoException();
            }
        }
    }
}
