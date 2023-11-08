package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private List<Lotto> lottos;
    private int price;
    private List<Integer> answers;

    public User() {
        int count = inputPrice();
        this.lottos = generateLottos(count);
        inquireLotto();
        inputAnswer();
        addBonus();
    }

    private void inputAnswer() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String answer = Console.readLine();
            try {
                validateAnswer(answer);
                answers = Arrays.stream(answer.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void validateAnswer(String answer) {
        String[] parts = answer.split(",");
        if (parts.length != 6) throw new IllegalArgumentException("로또 번호는 6개 입력이 필요합니다.");
        List<Integer> numbers = Arrays.stream(parts)
                .map(Integer::parseInt)
                .distinct()
                .filter(num -> num >= 1 && num <= 45)
                .collect(Collectors.toList());
        if (numbers.size() != 6) throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있거나 1부터 45 사이의 숫자여야 합니다.");
    }

    private void addBonus() {
        while (true) {
            System.out.println("보너스 숫자를 입력해 주세요.");
            String bonus = Console.readLine();
            try {
                validateBonus(bonus);
                int bonusNumber = Integer.parseInt(bonus);
                validateBonusNumber(bonusNumber);
                answers.add(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void validateBonus(String bonus) {
        if (bonus == null || bonus.isEmpty()) {
            throw new IllegalArgumentException("보너스 숫자를 입력하세요.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (answers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 이미 선택한 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 숫자는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private int inputPrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            try {
                price = Integer.parseInt(input);
                if (validatePrice(price)) {
                    break;
                } else {
                    System.out.println("[ERROR] 금액은 1000원 단위의 금액이어야 합니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액이 올바른 숫자가 아닙니다.");
            }
        }
        return price / 1000;
    }

    private boolean validatePrice(int price) {
        return price % 1000 == 0;
    }

    private void inquireLotto() {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private List<Integer> generateUniqueNumbers() {

        return Randoms.pickUniqueNumbersInRange(1, 45,6);
    }

    private List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            generatedLottos.add(new Lotto(generateUniqueNumbers()));
        }
        return generatedLottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public int getPrice() {
        return price;
    }
}
