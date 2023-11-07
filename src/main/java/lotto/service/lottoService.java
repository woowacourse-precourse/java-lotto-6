package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.view.LottoView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    public static Integer inputNumberOfLotto(String price) {
        return validatePrice(price) / 1000;
    }

    private static Integer validatePrice(String price) {
        try {
            int tempPrice = Integer.parseInt(price);
            if (tempPrice % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
            return tempPrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public static List<Lotto> generateLottoList(Integer numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(new Lotto(generateLotto()));
        }
        return lottoList;
    }

    private static List<Integer> generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    public static Lotto inputWinningNumbers() {
        Lotto winningLotto = null;

        while (winningLotto == null) {
            try {
                String input = LottoView.inputWinningNumbers();
                List<Integer> winningNumbers = parseWinningNumbers(input);
                winningLotto = new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    private static List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(s -> {
                        try {
                            return Integer.parseInt(s);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
                        }
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static Integer inputBonusNumber(Lotto winningNumbers) {
        Integer bonusNumber = null;
        while (bonusNumber == null) {
            try {
                String input = LottoView.inputBonusNumber();
                validateBonusNumber(input, winningNumbers);
                bonusNumber = Integer.valueOf(input);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private static void validateBonusNumber(String input, Lotto winningNumbers) {
        try {
            Integer bonusNumber = Integer.parseInt(input);
            isDuplicateNumber(bonusNumber, winningNumbers);
            bonusNumberIsInRange(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void isDuplicateNumber(Integer bonusNumber, Lotto winningNumbers) {
        List<Integer> numbers = winningNumbers.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복된 숫자입니다.");
        }
    }

    private static void bonusNumberIsInRange(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이에 숫자를 입력해주세요.");
        }
    }

    public static Map<Integer, Integer> checkWinning(List<Lotto> lottoList, Lotto winningNumbers, Integer bonusNumber) {
        Map<Integer, Integer> rankCount = new HashMap<>();

        for (Lotto lotto : lottoList) {
            int rank = getRank(lotto, winningNumbers, bonusNumber);

            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    private static int getRank(Lotto lotto, Lotto winningNumbers, Integer bonusNumber) {
        int numberOfHits = checkLottoNumber(lotto, winningNumbers);
        return getRankByNumberOfHits(numberOfHits, winningNumbers, bonusNumber);
    }

    private static int getRankByNumberOfHits(int numberOfHits, Lotto winningNumbers, Integer bonusNumber) {
        if (numberOfHits == 6) {
            return 1;
        } else if (numberOfHits == 5 && bonusNumberInwinningNumbers(winningNumbers, bonusNumber)) {
            return 2;
        } else if (numberOfHits == 5) {
            return 3;
        } else if (numberOfHits == 4) {
            return 4;
        } else if (numberOfHits == 3) {
            return 5;
        }
        return 6;
    }

    private static boolean bonusNumberInwinningNumbers(Lotto winningNumbers, Integer bonusNumber) {
        List<Integer> numbers = winningNumbers.getNumbers();
        return numbers.contains(bonusNumber);
    }

    private static int checkLottoNumber(Lotto lotto, Lotto winningNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winning = winningNumbers.getNumbers();
        int numberOfHits = 0;

        for (Integer lottoNumber : lottoNumbers) {
            if (winning.contains(lottoNumber)) {
                numberOfHits += 1;
            }
        }
        return numberOfHits;
    }


    public static Double calculateReturnRate(Integer numberOfLotto, Map<Integer, Integer> rank) {
        Double investmentAmount = Double.valueOf(numberOfLotto * 1000);
        Double earnedAmount = Double.valueOf(calculateLotto(rank));

        Double returnRate = earnedAmount / investmentAmount * 100;

        return (double) Math.round(returnRate * 100) / 100;
    }

    private static Integer calculateLotto(Map<Integer, Integer> rank) {
        Integer amount = 0;
        amount += rank.getOrDefault(5, 0) * 5000;
        amount += rank.getOrDefault(4, 0) * 50000;
        amount += rank.getOrDefault(3, 0) * 1500000;
        amount += rank.getOrDefault(2, 0) * 30000000;
        amount += rank.getOrDefault(1, 0) * 200000000;

        return amount;
    }
}
