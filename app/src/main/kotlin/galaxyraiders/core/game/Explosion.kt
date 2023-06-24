package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D
import kotlin.math.PI
import kotlin.math.abs



class Explosion(initialPosition: Point2D, radius: Double, timeLive: Double) :
  SpaceObject("Explosion", '*', initialPosition, Vector2D(0.0, 0.0), radius, mass = 0.0) {

  var isTriggered = true
  var timeLeft = timeLive

  fun isTriggeredExplosion(): Boolean {
    return this.isTriggered
  }

  fun Explosion.calculateSymmetricalPointX(x: Double): Double {
    return center.x + abs(center.x - x)
  }


  fun update() {
    if (this.timeLeft <= 0.0) {
      this.isTriggered = false
    }
    this.timeLeft -= 1.0
  }

  fun calculateSymmetricalPointY(y: Double): Double {
    return center.y + abs(center.y - y)
  }

  fun calculateSymmetricalPointX(x: Double): Double {
  return center.x + abs(center.x - x)
  }
}
