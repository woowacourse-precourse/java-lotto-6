# 우테코 3주차 - lotto

* Person class - 로또번호를 구매하는 객체 클래스
  * 멤버변수
    1. List<List<Integer>> lottoTicket - 6개의 번호로 이루어진 줄들을 담고있는 리스트
  * 메서드
    1. buyLotto - 6개의 번호(1줄)을 금액만큼 구매
    2. displayTicket - 구매하여 보유중인 로또들의 번호를 출력
    3. compareNum - 로또 당첨번호 결과를 추출하기위한 숫자비교 메서드
    4. checkWinningNumber - 숫자를 비교하여 로또 추첨결과를 리턴하는 메서드
    5. displayResult - 결과를 출력해주는 메서드
    6. calculateProfit - 수익률을 구해주는 메서드
       
* LottoMachine class - 로또를 발급해주는 객체 클래스
  * 멤버변수
    1. List<Integer> lottoNumbers - 6자리의 로또번호를 저장하는 변수
  * 메서드
    1. generateLottoTicket - 랜덤 6개의 번호를 발급하는 메서드

* DrawLotto class - 로또 당첨번호를 뽑는 클래스
  * 메서드
    1. getNumbers - 당첨 번호6자리를 입력받는 클래스
    2. getBonusNumber - 보너스 당첨번호를 입력받는 클래스


