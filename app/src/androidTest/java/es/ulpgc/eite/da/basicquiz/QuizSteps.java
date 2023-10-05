package es.ulpgc.eite.da.basicquiz;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.not;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.RemoteException;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.Rule;

import es.ulpgc.eite.da.basicquiz.QuestionActivity;
import es.ulpgc.eite.da.basicquiz.R;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SuppressWarnings("ALL")
public class QuizSteps {

  private static final int DELAY_IN_SECS = 0 * 1000;

  @Rule
  public ActivityTestRule<QuestionActivity> testRule =
      new ActivityTestRule(QuestionActivity.class, true, false);

  private Activity activity;


  @Before("@quiz-feature")
  public void setUp() {

    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();

    } catch (RemoteException e) {
    }

    testRule.launchActivity(new Intent());
    activity = testRule.getActivity();
  }

  @After("@quiz-feature")
  public void tearDown() {

    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();

    } catch (RemoteException e) {
    }

    testRule.finishActivity();
  }


  @Given("^iniciar pantalla Question$")
  public void iniciarPantallaQuestion() {

    /*
    try {
      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();
    } catch (RemoteException e) {
    }
    */

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }

  }

  @And("^mostrar pregunta \"([^\"]*)\"$")
  public void mostrarPregunta(String q) {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.questionText)).check(matches(isDisplayed()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.questionText)).check(matches(withText(q)));
  }

  @And("^ocultar resultado$")
  public void ocultarResultado() {
    //onView(withId(R.id.questionText)).check(matches(not(isDisplayed())));
    //onView(withId(R.id.replyText)).check(matches(isDisplayed()));
    //onView(withId(R.id.replyText)).check(matches(withText("???")));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.replyText))
        .check(matches(withText(activity.getString(es.ulpgc.eite.da.basicquiz.R.string.empty_text))));
  }


  @And("^ocultar respuesta$")
  public void ocultarRespuesta() {
    //onView(withId(R.id.answerText)).check(matches(isDisplayed()));
    //onView(withId(R.id.answerText)).check(matches(withText("???")));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.answerText))
        .check(matches(withText(activity.getString(es.ulpgc.eite.da.basicquiz.R.string.empty_text))));
  }

  @And("^mostrar botones True y False y Cheat activados$")
  public void mostrarBotonesTrueYFalseYCheatActivados() {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.trueButton)).check(matches(isEnabled()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.falseButton)).check(matches(isEnabled()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.cheatButton)).check(matches(isEnabled()));
  }

  @And("^mostrar boton Next desactivado$")
  public void mostrarBotonNextDesactivado() {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.nextButton)).check(matches(not(isEnabled())));
  }

  @When("^pulsar boton \"([^\"]*)\"$")
  public void pulsarBoton(String b) {

    String tb = activity.getString(es.ulpgc.eite.da.basicquiz.R.string.true_button_text);
    //int button = (b.equals("True")) ? R.id.trueButton : R.id.falseButton;
    int button = (b.equals(tb)) ? es.ulpgc.eite.da.basicquiz.R.id.trueButton : es.ulpgc.eite.da.basicquiz.R.id.falseButton;
    onView(withId(button)).check(matches(isDisplayed()));
    onView(withId(button)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @Then("^mostrar resultado \"([^\"]*)\" a respuesta \"([^\"]*)\"$")
  public void mostrarResultadoARespuesta(String r, String a) {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.replyText)).check(matches(isDisplayed()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.replyText)).check(matches(withText(r)));
  }

  @And("^mostrar botones True y False y Cheat desactivados$")
  public void mostrarBotonesTrueYFalseYCheatDesactivados() {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.trueButton)).check(matches(not(isEnabled())));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.falseButton)).check(matches(not(isEnabled())));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.cheatButton)).check(matches(not(isEnabled())));

  }

  @And("^mostrar boton Next activado$")
  public void mostrarBotonNextActivado() {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.nextButton)).check(matches(isEnabled()));
  }

  @When("^pulsar boton Cheat$")
  public void pulsarBotonCheat() {

    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.cheatButton)).check(matches(isDisplayed()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.cheatButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @Then("^iniciar pantalla Cheat$")
  public void iniciarPantallaCheat() {
    //getInstrumentation().waitForIdleSync();

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @And("^mostrar mensaje Warning$")
  public void mostrarMensajeWarning() {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.warningText)).check(matches(isDisplayed()));
    //onView(withId(R.id.warningText))
    //    .check(matches(withText("Are you sure?")));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.warningText))
        .check(matches(withText(activity.getString(es.ulpgc.eite.da.basicquiz.R.string.warning_text))));
  }

  @And("^mostrar botones Yes y No activados$")
  public void mostrarBotonesYesYNoActivados() {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.yesButton)).check(matches(isEnabled()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.noButton)).check(matches(isEnabled()));
  }

  @When("^pulsar boton No$")
  public void pulsarBotonNo() {

    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.noButton)).check(matches(isDisplayed()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.noButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @Then("^finalizar pantalla Cheat$")
  public void finalizarPantallaCheat() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @And("^resumir pantalla Question$")
  public void resumirPantallaQuestion() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @When("^pulsar boton Yes$")
  public void pulsarBotonYes() {

    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.yesButton)).check(matches(isDisplayed()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.yesButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @Then("^mostrar respuesta \"([^\"]*)\" a pregunta \"([^\"]*)\"$")
  public void mostrarRespuestaAPregunta(String a, String q) {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.answerText)).check(matches(isDisplayed()));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.answerText)).check(matches(withText(a)));
  }

  @And("^mostrar botones Yes y No desactivados$")
  public void mostrarBotonesYesYNoDesactivados() {
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.yesButton)).check(matches(not(isEnabled())));
    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.noButton)).check(matches(not(isEnabled())));

  }

  @When("^pulsar boton Back$")
  public void pulsarBotonBack() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }

    //getInstrumentation().waitForIdleSync();
    pressBack();
  }

  @When("^pulsar boton Next$")
  public void pulsarBotonNext() {

    onView(ViewMatchers.withId(es.ulpgc.eite.da.basicquiz.R.id.nextButton)).check(matches(isDisplayed()));
    onView(ViewMatchers.withId(R.id.nextButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  @When("^girar pantalla$")
  public void girarPantalla() {

    int orientation = activity.getRequestedOrientation();

//    if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//      orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
//
//    } else {
//      orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
//    }
//
//    activity.setRequestedOrientation(orientation);

    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());

      if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
        device.setOrientationNatural();

      } else {
        device.setOrientationLeft();
      }

    } catch (RemoteException e) {

    }

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }


}
