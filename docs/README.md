## MVC 패턴을 사용하여 구현
> lotto 클래스(구현전에 명시되어있음)
> >- 이 로또 클래스를 사용하여 로또 번호가 정확히 6개 입력 받았는지 확인한다

>MODEL:
>> EnumRanking
>> - 결과 값을 등수로 나눠서 outputview를 사용해 결과를 출력한다

>CONTROLLER:
> >ControlMain:
> > > buyLotto
> > >-  lotto 클래스를 선언하여 로또 구입금액을 받은 결과를 반환해 로또를 산다
> > >-  여기서 로또를 산값을 outputView로 가서 출력한다
> > >
> > > equalsLottoNum
> > >- 당첨 번호랑 보너스 번호를 받은 결과를 토대로 같은 값이 몇개 있는지 반환한다 (여기서 ENUM을 활용)

>VIEW:
> > InputView
> >- 로또 구입 금액을 입력받는다 (수가 1000 단위로 딱 나누어지지 않으면 ERROR 발생)
> >- 당첨 번호를 입력받는다(수가 중복일경우 ERROR 발생)
> >- 보너스 번호를 입력받는다(수가 중복일 경우 ERROR 발생)
>
> > OutputView
> >- 로또 구입 금액이 1000단위로 나눠 떨어질 경우 그 값으로 controller로 가서 로또를 산뒤 그 값을 출력한다
> >- 당첨번호 보너스 번호를 받은뒤 controller로 가서 당첨번호 통계를 한뒤 금액을 정산한다

> > ErrorMessage
> >- [ERROR]문을 출력해준다
