package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Play {

    public void play() {
        int lottoAmount = inputAmount();
        List<Lotto> lottos = createLotto(lottoAmount);

        for (Lotto list : lottos) {
            System.out.println(list.getNumbers());
        }

        List<Integer> winnerNumbers = new ArrayList<>(inputWinnerNumber());
    }

    // 로또를 구입할 금액을 입력받는다.
    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();

        try {
            handleNonThousandUnit(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
        int amount = Integer.parseInt(price) / 1000;

        System.out.println("\n"+amount+"개를 구매했습니다.");

        return amount;
    }

    // 구입한 개수만큼 로또를 생성한다
    public List<Lotto> createLotto(int lottoAmount) {
        List<Lotto> lottoNumbersList = new ArrayList<>();

        for (int i = 1; i <= lottoAmount; i++) {
            lottoNumbersList.add(new Lotto(createRandomLottoNumbers()));
        }
        return lottoNumbersList;
    }

    // 6개의 랜덤 숫자를 생성하고 오름차순으로 정렬한다
    public List<Integer> createRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>
                (Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);

        return numbers;
    }

    // 당첨 번호와 보너스 번호를 입력받는다.
    public List<Integer> inputWinnerNumber() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winnerNumbers = Console.readLine();      //당첨 번호를 입력받음

        try {
            handleInvalidNumberCount(winnerNumbers);    //당첨 번호 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinnerNumber();
        }

        for (String s : winnerNumbers.split(",")) {
            numbers.add(Integer.parseInt(s));           //int 타입으로 변환 후 리스트에 추가
        }

        try {
            handleDuplicateNumbers(numbers);            //당첨 번호 중복 검사 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinnerNumber();
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        try {
            handleInvalidNumberInput(bonusNumber);          //보너스 번호 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinnerNumber();
        }

        numbers.add(Integer.parseInt(bonusNumber));     //int 타입으로 변환 후 리스트에 추가

        try {
            handleDuplicateNumbers(numbers);            //당첨 번호 중복 검사 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinnerNumber();
        }
        return numbers;
    }

    ////////////////////////////////////예외처리////////////////////////////////////
    // 입력받은 금액이 1000원 단위가 아니면 예외 발생
    public void handleNonThousandUnit(String price) {
        try {
            Double.parseDouble(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (Double.parseDouble(price) % 1000 != 0.0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    // 당첨 번호가 숫자가 아니거나 6개가 아니거나 1~45의 범위가 아니면 예외 발생
    public void handleInvalidNumberCount(String sixNumber) {
        String replaceNumber = sixNumber.replace(",","");
        try {
            Integer.parseInt(replaceNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (replaceNumber.length() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요.");
        }
        for (String number : sixNumber.split(",")) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45의 번호를 입력해주세요.");
            }
        }
    }

    // 보너스 번호가 숫자가 아니거나 1~45의 범위가 아니면 예외 발생
    public void handleInvalidNumberInput(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45의 번호를 입력해주세요.");
        }
    }

    // 당첨 번호 중복이면 예외 발생
    public void handleDuplicateNumbers(List<Integer> winnerNumbers) {
        if (winnerNumbers.size() != winnerNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 번호는 중복되지 않게 입력해주세요.");
        }
    }

}