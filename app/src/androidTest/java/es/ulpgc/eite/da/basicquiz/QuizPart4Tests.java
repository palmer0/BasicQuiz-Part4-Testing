package es.ulpgc.eite.da.basicquiz;


import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
@SuppressWarnings("ALL")
public class QuizPart4Tests {


    @Rule
    public ActivityTestRule<QuestionActivity> testRule =
        new ActivityTestRule<>(QuestionActivity.class);

    public QuizSteps steps = new QuizSteps();



    private Activity activity;


    @Before
    public void setUp() {

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());
            device.setOrientationNatural();

        } catch (RemoteException e) {
        }

        testRule.launchActivity(new Intent());
        activity = testRule.getActivity();


    }

    @After
    public void tearDown() {

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());
            device.setOrientationNatural();

        } catch (RemoteException e) {
        }

        testRule.finishActivity();
    }



    
    @Test
    public void testResponderAPreguntaEnPantallaQuestion() {
        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question>"
        String[] questions =
            activity.getResources().getStringArray(R.array.question_array);
        steps.mostrarPregunta(questions[0]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton "<button>"
        steps.pulsarBoton(R.id.trueButton);
        //steps.pulsarBoton("<button>", activity.getString(R.string.true_button_text));
        // And mostrar resultado "<result>" a respuesta "<answer>"
        //steps.mostrarResultadoARespuesta("<result>", "<answer>");
        steps.mostrarResultadoARespuesta(activity.getString(R.string.correct_text));
        // And mostrar botones True y False y Cheat desactivados
        steps.mostrarBotonesTrueYFalseYCheatDesactivados();
        // And mostrar boton Next activado
        steps.mostrarBotonNextActivado();
        // When girar pantalla
        steps.girarPantalla(activity.getRequestedOrientation());
        // Then mostrar resultado "<result>" a respuesta "<answer>"
        //steps.mostrarResultadoARespuesta("<result>", "<answer>");
        steps.mostrarResultadoARespuesta(activity.getString(R.string.correct_text));
        // And mostrar botones True y False y Cheat desactivados
        steps.mostrarBotonesTrueYFalseYCheatDesactivados();
        // And mostrar boton Next activado
        steps.mostrarBotonNextActivado();


//        Examples:
//        | question           | button | answer | result    |
//        | Question #1: True  | True   | True   | Correct   |
//        | Question #1: True  | False  | True   | Incorrect |
        
    }

    
    @Test
    public void testPasarAPantallaCheatSinResponderAPreguntaEnPantallaQuestion() {
        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question>"
        String[] questions =
            activity.getResources().getStringArray(R.array.question_array);
        steps.mostrarPregunta(questions[0]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton Cheat
        steps.pulsarBotonCheat();
        // And iniciar pantalla Cheat
        steps.iniciarPantallaCheat();
        // And mostrar mensaje Warning
        steps.mostrarMensajeWarning(activity.getString(R.string.warning_text));
        // And ocultar respuesta
        steps.ocultarRespuesta(activity.getString(R.string.empty_text));
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // When girar pantalla
        steps.girarPantalla(activity.getRequestedOrientation());
        // Then mostrar mensaje Warning
        steps.mostrarMensajeWarning(activity.getString(R.string.warning_text));
        // And ocultar respuesta
        steps.ocultarRespuesta(activity.getString(R.string.empty_text));
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // And pulsar boton Back
        steps.pulsarBotonBack();

//        Examples:
//      | question          |
//      | Question #1: True |
            
    }

    @Test
    public void testVolverAPantallaQuestionSinMostrarRespuestaEnPantallaCheat() {
        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question>"
        String[] questions =
            activity.getResources().getStringArray(R.array.question_array);
        steps.mostrarPregunta(questions[0]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton Cheat
        steps.pulsarBotonCheat();
        // And iniciar pantalla Cheat
        steps.iniciarPantallaCheat();
        // And mostrar mensaje Warning
        steps.mostrarMensajeWarning(activity.getString(R.string.warning_text));
        // And ocultar respuesta
        steps.ocultarRespuesta(activity.getString(R.string.empty_text));
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // When pulsar boton No
        steps.pulsarBotonNo();
        // Then finalizar pantalla Cheat
        steps.finalizarPantallaCheat();
        // And resumir pantalla Question
        steps.resumirPantallaQuestion();
        // And mostrar pregunta "<question>"
        steps.mostrarPregunta(questions[0]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();


//        Examples:
//      | question          |
//      | Question #1: True |
        
    }

    @Test
    public void testMostrarRespuestaEnPantallaCheat() {
        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question>"
        String[] questions =
            activity.getResources().getStringArray(R.array.question_array);
        steps.mostrarPregunta(questions[0]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton Cheat
        steps.pulsarBotonCheat();
        // And iniciar pantalla Cheat
        steps.iniciarPantallaCheat();
        // And mostrar mensaje Warning
        steps.mostrarMensajeWarning(activity.getString(R.string.warning_text));
        // And ocultar respuesta
        steps.ocultarRespuesta(activity.getString(R.string.empty_text));
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // When pulsar boton Yes
        steps.pulsarBotonYes();
        // Then mostrar respuesta "<answer>" a pregunta "<question>"
        //steps.mostrarRespuestaAPregunta("<answer>", "<question>");
        int[] answers = activity.getResources().getIntArray(R.array.reply_array);
        String answer = (answers[0] == 1)
            ? activity.getString(R.string.true_text)
            : activity.getString(R.string.false_text);
        steps.mostrarRespuestaAPregunta(answer);
        // And mostrar botones Yes y No desactivados
        steps.mostrarBotonesYesYNoDesactivados();
        // And pulsar boton Back
        steps.pulsarBotonBack();

//        Examples:
//      | question          | answer |
//      | Question #1: True | True   |
        
    }

    @Test
    public void testVolverAPantallaQuestionMostrandoRespuestaEnPantallaCheat() {
        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question1>"
        String[] questions =
            activity.getResources().getStringArray(R.array.question_array);
        steps.mostrarPregunta(questions[0]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton Cheat
        steps.pulsarBotonCheat();
        // And iniciar pantalla Cheat
        steps.iniciarPantallaCheat();
        // And mostrar mensaje Warning
        steps.mostrarMensajeWarning(activity.getString(R.string.warning_text));
        // And ocultar respuesta
        steps.ocultarRespuesta(activity.getString(R.string.empty_text));
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // And pulsar boton Yes
        steps.pulsarBotonYes();
        // And mostrar botones Yes y No desactivados
        steps.mostrarBotonesYesYNoDesactivados();
        // And mostrar respuesta "<answer>" a pregunta "<question1>"
        //steps.mostrarRespuestaAPregunta("<answer>", "<question1>");
        int[] answers = activity.getResources().getIntArray(R.array.reply_array);
        String answer = (answers[0] == 1)
            ? activity.getString(R.string.true_text)
            : activity.getString(R.string.false_text);
        steps.mostrarRespuestaAPregunta(answer);
        // When pulsar boton Back
        steps.pulsarBotonBack();
        // Then finalizar pantalla Cheat
        steps.finalizarPantallaCheat();
        // And resumir pantalla Question
        steps.resumirPantallaQuestion();
        // And mostrar pregunta "<question2>"
        steps.mostrarPregunta(questions[1]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();

//        Examples:
//      | question1         | answer | question2          |
//      | Question #1: True | True   | Question #2: False |
            
    }

    @Test
    public void testPasarASiguientePreguntaEnPantallaQuestion() {
        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question1>"
        String[] questions =
            activity.getResources().getStringArray(R.array.question_array);
        steps.mostrarPregunta(questions[0]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton "<button>"
        steps.pulsarBoton(R.id.trueButton);
        //steps.pulsarBoton("<button>", activity.getString(R.string.true_button_text));
        // And mostrar resultado "<result>" a respuesta "<answer>"
        //steps.mostrarResultadoARespuesta("<result>", "<answer>");
        steps.mostrarResultadoARespuesta(activity.getString(R.string.correct_text));
        // And mostrar botones True y False y Cheat desactivados
        steps.mostrarBotonesTrueYFalseYCheatDesactivados();
        // And mostrar boton Next activado
        steps.mostrarBotonNextActivado();
        // And girar pantalla
        steps.girarPantalla(activity.getRequestedOrientation());
        // And mostrar resultado "<result>" a respuesta "<answer>"
        steps.mostrarResultadoARespuesta(activity.getString(R.string.correct_text));
        //steps.mostrarResultadoARespuesta("<result>", "<answer>");
        // And mostrar botones True y False y Cheat desactivados
        steps.mostrarBotonesTrueYFalseYCheatDesactivados();
        // And mostrar boton Next activado
        steps.mostrarBotonNextActivado();
        // And pulsar boton Next
        steps.pulsarBotonNext();
        // And mostrar pregunta "<question2>"
        steps.mostrarPregunta(questions[1]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // When girar pantalla
        steps.girarPantalla(activity.getRequestedOrientation());
        // Then mostrar pregunta "<question2>"
        steps.mostrarPregunta(questions[1]);
        // And ocultar resultado
        steps.ocultarResultado(activity.getString(R.string.empty_text));
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();

//        Examples:
//      | question1         | button  | answer  | result    | question2          |
//      | Question #1: True | True    | True    | Correct   | Question #2: False |
//      | Question #1: True | False   | True    | Incorrect | Question #2: False |
            
    }
}