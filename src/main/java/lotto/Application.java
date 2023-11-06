package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) throws IOException{
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int amountOfLotto = Integer.parseInt(br.readLine());
        String[] winningNumber = br.readLine().split(",");
        String bonusNumber = br.readLine();


        System.out.println("amountOfLotto " + amountOfLotto);
        System.out.println("winningNumber " + winningNumber);
        System.out.println("bonusNumber " + bonusNumber);
    }
}
