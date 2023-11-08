package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputLotto {
    private List<Integer> winningNumber = new ArrayList<>();
    private List<Integer> bonusNumber = new ArrayList<>();

    public String winningNumber(){
        String input = Console.readLine();
        return input;
    }

    public String inputBonus() {
        String input = Console.readLine();
        return input;
    }

    public String[] splitLotto(String str){
        return str.split(",");
    }

    public void inputWinningNumber(String str){
        String[] strings = splitLotto(str);
        winningNumber.clear();
        for(int i = 0; i < strings.length; i++){
            strings[i] = strings[i].trim();
            int num = alterNum(strings[i]);
            winningNumber.add(num);
        }
    }

    public int alterNum(String str){
        int num = 0;
        try{
            num = Integer.parseInt(str);
        }catch(NumberFormatException e){
            System.out.println("[Error] 올바른 정보를 입력해주세요");
        }
        return num;
    }

    public void inputBonus(String str){
        String[] strings = splitLotto(str);
        bonusNumber.clear();
        for(int i = 0; i < strings.length; i++){
            strings[i] = strings[i].trim();
            int num = alterNum(strings[i]);
            bonusNumber.add(num);
        }
    }
    public List<Integer> getWinningNumber(){
        return this.winningNumber;
    }

    public List<Integer> getBonusNumber(){
        return this.bonusNumber;
    }


}
