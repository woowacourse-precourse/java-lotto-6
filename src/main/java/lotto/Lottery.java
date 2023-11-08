package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottery {
    private static final String EXCEPTION_PREFIX = "[ERROR]";
    private static final int PRICE_OF_LOTTO = 1000;
    private int receivedMoney;
    private int quantityOfLottoPublishable;
    private List<Integer> chosenNumber;
    private List<Lotto> lottos = new ArrayList<>();
    private int bonusNumber ;


    public void receiveMoney () {
        int receivedMoney = 0;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String money = Console.readLine();
            if (!money.matches("^-?\\d+$\n")) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX+"정수만 입력 가능합니다.");
            }
            if (Integer.parseInt(money) % 1000 != 0) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX+"입력은 1000 단위로 해주세요.");
            }
            receivedMoney = Integer.parseInt(money);
        }catch (IllegalArgumentException e){
            System.err.println(EXCEPTION_PREFIX + e.getMessage());
            receiveMoney();
        }finally {
            this.receivedMoney = receivedMoney;
        }
    }

    public void calculateQuantityOfLottoAndNotify () {
        quantityOfLottoPublishable = receivedMoney / PRICE_OF_LOTTO;
        System.out.println(quantityOfLottoPublishable +"개를 구매했습니다.");
    }

    public void publishLotto () {
        for (int i = 0; i < quantityOfLottoPublishable; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber = lottoNumber.stream().sorted().toList();
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);

            System.out.println(lotto);
        }
    }

    public void getChosenLottoNumber () {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String chosenNum = Console.readLine();
            if (chosenNum.split(",").length != 6) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX+" 쉼표로 나눠진 6개의 숫자를 입력해주세요.");
            }

            chosenNumber = Arrays.stream(chosenNum.split(",")).map(Integer::parseInt).toList();

            validateChosenNumber();


        } catch (Exception e) {
            e.printStackTrace();
            getChosenLottoNumber();
        }
    }

    public void validateChosenNumber () {

        int conditionMetValue=chosenNumber.stream().filter(el -> 1<= el && el<= 45).toList().size();

        if (conditionMetValue==chosenNumber.size()) {


        }
        chosenNumber = null;
        throw new IllegalArgumentException(EXCEPTION_PREFIX+" 각 숫자는 1부터 45까지의 범위 내에 있어야 합니다.");
    }

    public void getChosenBonusNumber () {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String chosenNum = Console.readLine();

            if (!chosenNum.matches("^-?\\d+$\n")) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX+"보너스 번호는 정수로 입력해주세요.");
            }

            int bonusNumber = Integer.parseInt(chosenNum);

            if ( 1<= bonusNumber && bonusNumber<= 45) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX+"보너스 번호는 1부터 45 이내의 정수로 입력해주세요.");
            }

            this.bonusNumber = bonusNumber;

        } catch (Exception e) {
            e.printStackTrace();
            getChosenBonusNumber();
        }
    }

}
