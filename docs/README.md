# LottoView
### 1. 구매 금액
    - 구매 금액 안내 문구
    - 구매 금액 입력 받기

### 2. 구매 개수 및 로또 번호
    - 구매 개수 안내 문구
    - 구매 로또 번호 출력

### 3. 당첨 번호
    - 당첨 번호 안내 문구
    - 당첨 번호 입력 받기

### 4. 보너스 번호
    - 보너스 번호 안내 문구
    - 보너스 번호 입력 받기

### 5. 당첨 통계
    - 당첨 통계 문구
    - 당첨 결과 출력
    - 수익률 출력
    - 수익률 구분자 삽입

---

# WinningPrice
### Enum 구분
    -  1등  : TWO_BILLION
    -  2등  : THREE_MILLION
    -  3등  : ONE_POINT_FIVE_MILLION
    -  4등  : FIFTY_THOUSAND
    -  5등  : FIFTY_HUNDRED
    - 미당첨 : NONE

### WinningPrice 찾기
    - 당첨 번호와 로또의 번호가 맞는 개수와 보너스 번호가 맞는지의 유무에 따라 WinningPrice 반환
    - WinningPrice의 toString 구현

# Purchaser
    - 초기 로또 상태 NONE으로 세팅
    - 로또 구매
    - 당첨 결과 계산

# Lotto
    - 로또 번호 발행

# LottoController
    - 로또 구매 금액 입력
    - 로또 구매
    - 당첨 번호 입력
    - 보너스 번호 입력
    - 당첨결과 출력

# InputJudgement
    - 입력 금액 유효성 판단
    - 입력 당첨 금액 번호 유효성 판단
    - 입력 보너스 번호 유효성 판단