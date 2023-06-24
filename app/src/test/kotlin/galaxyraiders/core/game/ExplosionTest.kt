package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@DisplayName("Given an explosion")
class ExplosionTest {
  private val explosion = Explosion(
    initialPosition = Point2D(1.0, 1.0),
    radius = 1.0,
    timeLive = 2000.0
  )

  @Test
  fun `it has its parameters initialized correctly`() {
    assertAll(
      "Explosion should initialize all its parameters correctly",
      { assertNotNull(explosion) },
      { assertEquals(Point2D(1.0, 1.0), explosion.center) },
    )
  }

  @Test
  fun `it is triggered upon creation`() {
    assertTrue(explosion.isTriggered)
  }

  @Test
  fun `its radius is set correctly`() {
    assertEquals(1.0, explosion.radius)
  }

  @Test
  fun `its radius can be updated to a new value`() {
    val newRadius = 2.5
    explosion.radius = newRadius
    assertEquals(newRadius, explosion.radius)
  }

  @Test
  fun `updating the radius does not modify the original value`() {
    val originalRadius = explosion.radius
    val newRadius = 2.5
    explosion.radius = newRadius
    assertEquals(originalRadius, explosion.radius)
  }



  @Test
  fun `ensuring the explosion is symmetrical`() {
    val x1 = explosion.center.x + explosion.radius
    val x2 = explosion.center.x - explosion.radius
    val y1 = explosion.center.y + explosion.radius
    val y2 = explosion.center.y - explosion.radius

    assertAll(
      "Explosion should be symmetrical",
      { assertEquals(x1, explosion.calculateSymmetricalPointX(x2), 1e-6) },
      { assertEquals(y1, explosion.calculateSymmetricalPointY(y2), 1e-6) }
    )
    }
}






