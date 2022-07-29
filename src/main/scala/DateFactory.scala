import java.time.Instant
import java.time.Clock
object DateFactory extends FactoryBase[Instant] {
  def create(): Instant = {
    DateFactory.create(Clock.systemUTC())
  }
  def create(clock: Clock) = {
    Instant.now(clock)
  }
}
