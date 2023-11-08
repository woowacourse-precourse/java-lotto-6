# 🎱 로또

## Domain
- [X] Lotto 
  - 예외처리
  - [X] 중복
  - [X] 범위를 벗어난 수
  - [X] 사이즈가 6이 아닐 경우
- [X] LottoCost : 돈을 입력 받는 함수
    - 예외처리
    - [X] 나머지가 0이 아닌 경우
    - [X] 입력값이 0인 경우
- [X] LottoGenerator : 로또 생성
- [X] LottoPrize : Enum 
- [X] LottoPrizeCount : 당첨 번호와 로또 번호 계산
- [X] Lottos : 로또 배열 여러개 집합
- [X] WinningNumber : 당첨 번호와 보너스 번호 입력
 
## View
- inputView
- [X] 몇 장 구매할 지 입력
- [X] 로또 번호 입력 6개
- [X] 보너스 번호 입력
  - 예외처리
  - [X] 공백이나 빈칸
  - [X] String
  - [X] ,, or ' ' 같은 쉼표 오류
  - [X] ,로 시작하거나 끝나면 예외
- outputView
- [X] 발행한 로또 수량 출력
- [X] 발행한 로또 번호 출력 
  - [X] 정렬기능 포함
- [X] 당첨 내역, 수익률 출력
- [X] 예외메세지 출력

## Controller
- [X] Domain과 View를 이어주는 기능
- [X] run 함수