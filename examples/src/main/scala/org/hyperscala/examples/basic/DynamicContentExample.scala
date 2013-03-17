package org.hyperscala.examples.basic

import org.hyperscala.html._
import org.powerscala.property.Property

import org.hyperscala.ui.binder._
import org.powerscala.property.event.PropertyChangeEvent
import org.hyperscala.ui.dynamic.{DynamicContent, DynamicString}
import org.hyperscala.examples.Example

/**
 * @author Matt Hicks <mhicks@outr.com>
 */
class DynamicContentExample extends Example {
  val form = new SimpleDynamicForm
  contents += form
}

class SimpleDynamicForm extends DynamicContent(null) {
  def dynamicString = DynamicString.url("dynamic.html", SimpleDynamicForm.content)

  val person = Property[Person]("person", Person("John Doe", 123))
  person.listeners.synchronous {
    case evt: PropertyChangeEvent => println("Person changed from %s to %s".format(evt.oldValue, evt.newValue))
  }

  val nameInput = bind[tag.Input, String]("i1", person, "name")
  val ageInput = bind[tag.Input, Int]("i2", person, "age")
  val button = load[tag.Button]("b1")

  button.contents.replaceWith("Do Something")
}

object SimpleDynamicForm {
  val content = getClass.getClassLoader.getResource("dynamic.html")
}

case class Person(name: String, age: Int)