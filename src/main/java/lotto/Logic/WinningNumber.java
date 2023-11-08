package lotto.Logic;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private Lotto lotto;
    private int bonus;


    public WinningNumber(){
    }

    public Lotto getLotto(){
        return this.lotto;
    }

    public int getBonus(){
        return this.bonus;
    }

    public void splitValid(String number) throws IllegalArgumentException{
        String[] checkNumber=number.split(",",-1);

        digitValid(checkNumber);
    }

    public void digitValid(String[] checkNumber) throws IllegalArgumentException{
        List<String> validNumber=new ArrayList<>();

        for (int i=0;i<checkNumber.length;i++){

            if (isParsable(checkNumber[i]))
                validNumber.add(checkNumber[i]);
            else if (!isParsable(checkNumber[i]))
                throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 숫자로 입력해야 한다");

        }
        setNumbers(validNumber);
    }

    public static boolean isParsable(String str) {

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (!Character.isDigit(currentChar))
                return false;
        }

        return true;
    }

    public void setNumbers(List<String> validNumber) throws IllegalArgumentException{
        List<Integer> checkNumbers=new ArrayList<>();

        for (int i=0;i<validNumber.size();i++){
            int number=Integer.parseInt(validNumber.get(i));

            checkNumbers.add(number);
        }

        this.lotto=new Lotto(checkNumbers);
    }

    public void setBonusValid(String bonus) throws IllegalArgumentException{
        try{
            this.bonus=Integer.parseInt(bonus);

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 표현해야 한다");
        }
        bonusValid(this.getBonus());
    }

    public void bonusValid(int bonusNumber) throws IllegalArgumentException{

        if (this.lotto.getNumbers().contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨번호와 중복되면 안된다");
        else if (bonusNumber<=0)
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 0 이하로 표현하면 안된다");
        else if(bonusNumber>=46)
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 46 이상으로 표현하면 안된다");

    }

    public void calculate(List<Lotto> memberLotto,Member member){

        for (int i=0;i<memberLotto.size();i++){
            List<Integer> winNumbers=new ArrayList<>();
            winNumbers.addAll(this.lotto.getNumbers());

            List<Integer> correct=correctBonus(memberLotto.get(i),winNumbers,this.bonus);

            member.setPrize(Prize.sixth.prizeDetermine(correct));
        }
    }

    public List<Integer> correctBonus(Lotto lotto, List<Integer> winNumbers, int bonusNumber){
        List<Integer> correct=new ArrayList<>(); // <몇 개 일치, 보너스 일치 여부>

        winNumbers.removeAll(lotto.getNumbers());
        correct.add(6-winNumbers.size());

        if(correct.get(0)==5 && lotto.getNumbers().contains(bonusNumber))
            correct.add(1);

        if(correct.size()!=2)
            correct.add(0);

        return correct;
    }

}
