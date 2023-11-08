# 🪄 기능 구현 목록

**로또 구매하기**  

1. 사용자가 예산을 입력한다.  
2. 사용자가 로또를 구매한다.  

**당첨 번호 입력하기**  

3. 당첨 번호를 입력한다.  
4. 보너스 번호를 입력한다.  

**당첨 결과 확인하기**  

5. 당첨 통계를 출력한다.  
6. 수익률을 출력한다.  

<br>

# 🪄 요구사항별 기능

### ∨ 로또 구매하기
- User는 LottoSeller에게서 로또를 구매할 수 있다.
- 단, User가 예산을 입력 받는 때, 로또 구매에 전부 사용할 금액을 입력받는다.

1. 사용자가 예산을 입력한다.
    ```
    - 입력받기
    - User의 예산으로 등록
    ```
   - 다음 예외 발생시 재입력한다.
     - NOT_NUMBER
     - NOT_POSITIVE 
     - NOT_THOUSAND_UNIT


3. 사용자가 로또를 구매한다.
    ```
    - User가 돈을 지불
    - Seller가 로또를 판매
    ```

### ∨ 당첨 번호 입력하기
- 당첨 번호와 보너스 번호를 입력받는다.
- 입력받은 번호들은 MatchCounter에 등록한다.
- MatchCounter는 당첨 번호와 로또 번호를 비교하여 매칭된 숫자 개수를 센다.

3. 당첨 번호를 입력한다.
    ```
    - 당첨 번호를 입력한다.
    - 당첨 번호를 등록한다.
    ```
    - 다음 예외 발생시 재입력한다. 
      - NOT_NUMBER
      - DELIMITER_COUNT
      - NUMBER_COUNT_OF_LOTTO
      - LOTTO_RANGE
      - NUMBER_DUPLICATED


5. 보너스 번호를 입력한다.
    ```
    - 보너스 번호를 입력한다.
    - 보너스 번호를 등록한다.
    ```
    - 다음 예외 발생시 재입력한다.
      - NOT_NUMBER
      - LOTTO_RANGE
      - NUMBER_DUPLICATED  


### ∨ 당첨 결과 확인하기
- WinCounter가 당첨 정책을 가지고 있으므로 당첨 상태를 확정할 수 있다.  
- MatchCounter는 단순히 "숫자 매치 정보"를 계산해서 알려줄 뿐이다.

5. 당첨 통계를 출력한다.
    ```
    - WinCounter는 당첨 정책을 가진다. 
    - MatchCounter가 User의 LottoPaper에서 Lotto별로 MatchCountDto 리스트를 얻는다.
    - 각 Lotto의 MatchCountDto 정보를 기반으로 WinCounter가 당첨을 확정한다.
    - 당첨 결과를 출력한다. (WinCounter.toString())
    ```

7. 수익률을 출력한다.
    ```
    - WinCounter는 당첨 정책을 가지므로 수익률을 계산 가능하다.
    - WinCounter에 수익률을 계산할 로또를 전달하면, 수익률을 얻을 수 있다.
    ```

