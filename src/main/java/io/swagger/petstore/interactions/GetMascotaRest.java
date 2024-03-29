package io.swagger.petstore.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetMascotaRest implements Interaction {


  // dentro de la url correspondiente se coloca "PostMascotaRest.getId()",
  // para utilizar la id (ya generado aleatoriamente) que se uso en el post y consultar la mascota que se creo.
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.resource("v2/pet/" + PostMascotaRest.getId())
            .with(
                request ->
                    request.header("Content-Type", "application/json").header("Accept", "*/*")));
    System.out.println(SerenityRest.lastResponse().asString());
  }

  public static Performable on() {
    return Instrumented.instanceOf(GetMascotaRest.class).withProperties();
  }
}
