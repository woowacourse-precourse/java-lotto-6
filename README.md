# 미션 - 로또

# ⚙️ 기능 목록
### 1️⃣ 구입 금액 입력받기
  - 구입 금액 validation 처리 (1000으로 나누어 떨어지는가)
### 2️⃣ 구입 금액만큼 로또 생성
  - createLotto() 메서드로 number 리스트 생성하고
    - 1부터 45 사이의 random 숫자
    - 중복되지 않는 6개의 숫자
  - Lotto 객체 생성해서 -> 객체를 lottos 리스트에 저장
### 3️⃣ 모든 로또 오름차순으로 출력
### 4️⃣ 당첨번호 입력 받기
  - validation 처리
    - 중복 없어야함
    - 6개의 숫자
    - 쉼표(,)로 구분
    - 1~45 범위의 수
### 5️⃣ 보너스 번호 입력 받기
  - validation 처리
    - 당첨번호와 중복되면 안된다.
### 6️⃣ 당첨 통계 내기 (lottos를 받아서 로또 수 count)
### 7️⃣ 당첨 통계 출력
### 8️⃣ 수익률 구하고 출력하기
  - 소수점 둘째자리에서 반올림하기

# 🚨 예외 상황 목록
## 💠 구입 금액 예외처리
1. 구입 금액이 숫자가 아닐 경우 : `PURCHASE_AMOUNT_IS_STRING`
2. 구입 금액이 1000으로 나누어 떨어지지 않을 경우 : `PURCHASE_AMOUNT_REMAIN`
3. 구입 금액이 int범위를 벗어날 경우 : `PURCHASE_AMOUNT_OVERFLOW`
4. 구입 금액이 음수일 경우 : `PURCHASE_AMOUNT_NEGATIVE_NUMBER`

## 💠 당첨 번호 예외처리
1. 당첨 번호가 입력되지 않은 경우 : `WINNING_NUMBERS_IS_NULL`
2. 당첨 번호가 숫자가 아닐 경우 : `WINNING_NUMBERS_IS_STRING`
3. 당첨 번호가 6개가 아닐경우 : `WINNING_NUMBERS_SIZE`
4. 당첨 번호가 범위를 벗어난 경우 : `WINNING_NUMBERS_RANGE`
5. 당첨 번호에 중복되는 숫자가 있는 경우 : `WINNIG_NUMBERS_DUPLICATE`

## 💠 보너스 번호 예외처리
1. 보너스 번호가 당첨 숫자와 중복될 경우
