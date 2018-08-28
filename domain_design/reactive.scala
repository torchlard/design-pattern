type Response[A] = String \/ Option[A]

// lifts an Option into a \/ and you get a Response
val count: Response[Int] = some(10).right
for {
  maybeCount <- count
} yield {
  for {
    c <- maybeCount
  } yield c
}


/** improved */
import scalaz.{ \/, OptionT }
type Error[A] = String \/ A
type Response[A] = OptionT[Error, A]

import scalaz.syntax.monad._
val count: Response[Int] = 10.point[Response]
for {
  c <- count
} yield (())




type AccountOperation[A] = Kleisli[Valid, AccountRepository, A]
->
type Valid[A] = NonEmptyList[String] \/ A
->
// Future monad on top of disjunction
type Valid[A] = EitherT[Future, NonEmptyList[String], A]
















