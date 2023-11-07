package lotto.view;

import lotto.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    Validator validator = new Validator();
    public String inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public String inputAmount2() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String input = readLine();
                int amount = Integer.parseInt(input);
                validator.validateAmountUnit(amount);
                return input;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] 1000원 단위의 금액을 입력해주세요.");
            }
            catch (IllegalStateException e) {
                System.out.println("[ERROR] 1000원 단위의 금액을 입력해주세요.");
            }
        }
    }

    public String inputWinNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public String inputWinNumber2() {
        while (true) {
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String input = readLine();
                String[] numbers = input.trim().split("\\s*,\\s*");
                validator.validateWinNumberLength(numbers);
                List<Integer> numberList = validator.validateWinNumberInt(numbers);
                validator.validateWinNumberDuplicate(numberList);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            } catch (IllegalStateException e) {
                System.out.println("[ERROR] 1 ~ 45 사이의 숫자 6개를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
            }
        }
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLine();
    }

    public String inputBonusNumber2(List<Integer> numbers) {
        while (true) {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                String input = readLine();
                int number = Integer.parseInt(input);
                validator.validateNumberRange(number);
                validator.validateBonusNumberDuplicate(numbers, number);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요. NUM");
            } catch (IllegalStateException e) {
                System.out.println("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호와 중복되지 않는 숫자를 입력해주세요.");
            }
        }
    }
}