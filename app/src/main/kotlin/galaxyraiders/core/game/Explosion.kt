package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D

class Explosion(initialPosition: Point2D, radius: Double, timeLive: Double) :
  SpaceObject("Explosion", '*', initialPosition, Vector2D(0.0, 0.0), radius, mass = 0.0) {

  var isTriggered = true
  var timeLeft = timeLive

  fun isTriggeredExplosion(): Boolean {
    return this.isTriggered
  }

  fun update() {
    if (this.timeLeft <= 0.0) {
      this.isTriggered = false
    }
    this.timeLeft -= 1.0
  }
}
