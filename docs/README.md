# 🔍미션-로또 홍성문 

## 🚀프로그래밍 전 기능목록 작성
1. 로또 구입 금액을 입력 받고 1000으로 나눠서 구매 갯수를 구한다.
2. 로또 구매 갯수 만큼 함수를 통해 로또 번호를 생성해 list에 저장하고 출력한다.
3. 당첨 번호와 보너스 번호를 입력받는다.
4. 구매한 로또 list를 for문을 반복하면서 당첨 여부를 확인하는 함수를 만든다. 
    - 로또 갯수만큼 for문을 돌면서 현재 index의 로또의 당첨 여부를 확인하는 함수를 호출한다.
    - 당첨 여부를 확인하는 함수의 return은 일치하는 숫자의 갯수로 하자.
    - 리턴받은 일치하는 숫자 갯수를 최종 당첨 갯수 리스트를 업데이트 하는데 사용한다.
5. 당첨 내역을 출력하는 함수를 구현한다.
6. 수익률을 구하고 출력한다.
7. Exception 부분을 구현 한다. Exception 종류는 아래와 같다.
    - 로또 구입금액 입력오류. 1000으로 나누어 떨어지지 않는 입력.
    - 당첨번호 입력오류
      - 1~45 사이의 숫자가 아니다.  
      - 문자나 공백이 입력 되었다. 
    - 수익률 계산할 때 0을 나누는 오류
   
## 📮클래스와 Method📮
- Base_Func 이름의 클래스를 만든다. Base_Func 클래스에는 Application.java에서 사용할 기본 입력,출력 함수 들의 모임이다.
  1. Input_Purchase_Price_Return_Number() -> 로또 구입 금액을 입력 받아 1000으로 나눠 떨어지는지 확인하고 구매할 로또 갯수 리턴
  2. Print_Purchased_Lotto_list(ArrayList<Lotto> Buy_lotto) -> 구매한 모든 로또의 번호 6개를 출력
  3. Input_Win_Lotto_List() -> 당첨 로또번호 입력 받아 List<Integer> 타입으로 리턴
  4. Input_Win_Lotto_Bonus_number() 
  5. Print_Jackpot_List() -> 당첨 내역 출력
  6. Print_Earning_Rate() -> 수익률을 계산해서 수익률 출력. 문제를 잘못 읽었다. 문제 제시는 소수점 둘째 자리에서 반올림 하는것.
  

- Application.java 클래스
  1. main()
  2. Make_Buy_Lotto_List() -> 기능 2번 구현
  3. Make_Jackpot_List() -> 구매한 로또를 for문을 돌면서 로또 일치 하는 갯수를 저장하는 List를 생성해 리턴.
  4. enum Jackpot_Money{} -> 당첨 금액 등수 별로 저장.

- Lotto.java 클래스
  1. Get_numbers()
  2. Lotto_Jackpot_Return() -> 구매한 로또 1개에 대해서 당첨 여부를 확인. 최종 리턴 값은 일치 하는 갯수 이며, 5개일치+보너스 일치의 경우 7을 리턴.
  3. Lotto_Bonus_Checkout() 