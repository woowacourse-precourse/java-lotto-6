# 로또 게임

## 로또 게임 규칙
1. 로또 번호의 숫자 범위는 1 ~ 45
2. 로또 1장의 가격은 1,000원
3. 1개의 로또의 숫자는 중복되지 않는 6개의 숫자로 이루어짐
4. 당첨 번호는 중복되지 않는 숫자 6개와 보너스 번호 1개로 이루어짐
5. 당첨은 1등부터 5등까지 존재
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

## 기능 구현 목록
- [v] 로또 구입 금액 유효성 체크(1,000원 단위)
- [v] 로또 구입 금액 만큼의 게임 횟수 셋팅
- [v] 로또 구입 금액만큼 로또 생성
- [v] 로또 번호 입력 -> 쉼표(,)를 기준으로 구분, 숫자범위 중 중복되지 않는 숫자 6개
- [v] 보너스 번호 입력 -> 로또 번호와 중복되지 않아야함
- [v] 발행된 로또 출력 -> 로또 수량 및 번호 출력, 로또 번호는 오름차순으로 정렬
- [v] 당첨 내역 출력 -> 실행결과와 같이 출력
- [v] 수익률 출력 -> 소수점 둘째 자리에서 반올림
- [v] Lotto 클래스 상속 받아 로또 번호 생성하도록 수정
- [ ] 로또 번호 에러 출력 -> 에러 문구는 "[ERROR]"로 시작할 것 (ex. "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
- [ ] 수익률 계산에 대한 테스트 케이스 작성

# 클래스 별 변수와 메소드
1. **LottoWin 클래스:**
   - **인스턴스 변수:**
     - `winNumbers`: 당첨 번호를 담는 Lotto 객체
     - `bonusNumber`: 보너스 번호를 저장하는 변수
   - **메소드:**
     - `public void setLottoWinNumbers()`: 콘솔에서 입력받은 6개의 숫자를 당첨 번호로 설정
     - `public void setWinBonusNumber()`: 콘솔에서 입력받은 보너스 번호를 설정

2. **Lotto 클래스:**
   - **인스턴스 변수:**
     - `numbers`: 1부터 45까지의 6개의 숫자를 저장하는 리스트
   - **메소드:**
     - `public Lotto(List<Integer> numbers)`: 주어진 숫자 리스트로 Lotto 객체를 생성하고 유효성을 검사
     - `public Lotto()`: 빈 리스트로 Lotto 객체를 생성
     - `private void validate(List<Integer> numbers)`: 숫자 리스트의 유효성을 검사
     - `public List<Integer> getNumbers()`: 숫자 리스트를 반환
     - `public boolean containsNumber(int number)`: 특정 숫자가 리스트에 포함되어 있는지 확인
     - `public void add(Integer number)`: 숫자를 리스트에 추가
     - `public static Lotto createLottoFromUserInput()`: 콘솔에서 사용자 입력을 받아 Lotto 객체를 생성

3. **LottoGame 클래스:**
   - **상수:**
     - `LOTTO_PRICE`: 로또 한 장의 가격 (1,000원)
     - `MIN_NUMBER`: 로또 번호의 최소값 (1)
     - `MAX_NUMBER`: 로또 번호의 최대값 (45)
     - `LOTTO_NUMBERS_COUNT`: 한 게임당 로또 번호의 개수 (6)
   - **인스턴스 변수:**
     - `gameCount`: 구매한 로또 게임의 수
     - `lottogame`: 로또 게임들을 저장하는 리스트
   - **메소드:**
     - `public void setLottoGame(int number)`: 구매한 로또 게임의 수를 설정
     - `public void validatePurchaseAmount(String input)`: 구매 금액의 유효성을 검사
     - `public void generateLottoNumbers()`: 구매한 게임 수에 따라 로또 번호를 생성하고 출력
     - `public void printLotto()`: 생성된 로또 번호들을 정렬하여 출력
     - `public void printLottoWin(LottoWin lottoWin)`: 당첨 번호와 비교하여 각 등수의 당첨 횟수를 출력하고 수익률을 계산하여 출력
     - `private int countMatchingNumbers(Lotto userNumbers, Lotto winNumbers)`: 사용자 번호와 당첨 번호를 비교하여 일치하는 숫자 개수를 반환
     - `public void getEarningRate(int match3, int match4, int match5, int match5WithBonus, int match6)`: 당첨 횟수를 이용하여 총 수익 및 수익률을 계산하여 출력

### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---
