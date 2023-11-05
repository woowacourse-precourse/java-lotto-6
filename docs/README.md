# woowacourse-lotto

## 구현할 기능 목록

- main
    - controller
        - 로또 게임 실행 controller
    - domain
        - 로또 구입 금액 domain(LottoBuy.java)
          - [예외] 구입 금액이 1,000원 단위가 아닐 경우
        - 로또 domain(Lotto.java)
          - 구입한 로또의 각각 로또를 의미하는 domain
        - 구입한 로또 domain(LottoSet.java)
          - [예외] 구입한 로또에 중복된 숫자가 있는 경우
          - [예외] 구입한 로또의 길이가 6이 아닌 경우
          - [예외] 구입한 로또 구분자가 ,가 아닌 경우
          - [예외] 구입한 로또 보너스번호 길이가 1이 아닌 경우
        - 당첨번호 domain(LottoWinning.java)
          - [예외] 당첨번호가 범위에 벗어난 경우
          - [예외] 당첨번호 길이가 6이 아닌 경우
          - [예외] 당첨번호 구분자가 ,가 아닌 경우
          - [예외] 당첨번호가 중복된 숫자가 있는 경우
        - 보너스번호 domain(LottoBonus.java)
          - [예외] 보너스번호가 범위에 벗어난 경우
          - [예외] 보너스번호 길이가 1이 아닌 경우
        - 당첨 내역 domain(LottoResult.java)
        - 수익률 domain(LottoProfit.java)
    - service
        - 로또 게임 service 
    - view
        - 입력 view
          - 구입금액 입력받기
          - 당첨번호 입력받기
          - 보너스 입력받기
        - 출력 view
          - 구매한 로또 출력하기
          - 당첨 통계 출력하기

- test
    - LottoTest
        - 로또 번호의 개수가 6개 넘어가면 예외 발생
        - 로또 번호 중복된 숫자 있으면 예외 발생
    - 이후 추가 작성