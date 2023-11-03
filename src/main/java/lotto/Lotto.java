package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static void sortLottos(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    public static void printLottos(Lotto[] lottos) {
        for (Lotto lotto : lottos) {
            sortLottos(lotto.numbers);
            System.out.println(lotto.numbers);
        }
    }

    public static List<Integer> readNumbers(String input, List<Integer> inputNumbers) {
        while (true) {
            while (true) {
                try {
                    inputNumbers = askNumbers(inputNumbers);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 숫자를 입력해 주세요.");
                }
            }
            if (checkCondition(inputNumbers))
                return inputNumbers;
        }
    }

    public static boolean checkCondition(List<Integer> inputNumbers) {
        Set<Integer> set = new HashSet<>(inputNumbers);
        if (inputNumbers.size() == 6 && Collections.max(inputNumbers) <= 45 && Collections.min(inputNumbers) >= 1 && set.size() == inputNumbers.size())
            return true;
        if (inputNumbers.size() != 6)
            System.out.println("[ERROR] 숫자 6개를 입력해 주세요.");
        else if (Collections.max(inputNumbers) > 45 || Collections.min(inputNumbers) < 1)
            System.out.println("[ERROR] 1과 45사이의 숫자만 입력해 주세요.");
        else if (set.size() != inputNumbers.size())
            System.out.println("[ERROR] 중복 되지 않도록 입력해 주세요.");
        return false;
    }

    public static List<Integer> askNumbers(List<Integer> inputNumbers) {
        String input = Console.readLine();
        inputNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            inputNumbers.add(Integer.parseInt(number));
        }
        return inputNumbers;
    }

    //각 로또별 맞은 개수 계산
    public static int countMatched(Lotto lotto, List<Integer> inputNumbers) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (inputNumbers.contains(lotto.numbers.get(i))) {
                count++;
            }
        }
        return count;
    }




}