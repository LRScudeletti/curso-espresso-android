package br.com.lrssoftwares.expressoandroidtests;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void teste_01_verificarCamposVisiveis() {
        onView(withId(R.id.edtUsuario)).check(matches(isDisplayed()));
        onView(withId(R.id.edtSenha)).check(matches(isDisplayed()));
        onView(withId(R.id.cbManterLogado)).check(matches(isDisplayed()));
        onView(withId(R.id.btnEntrar)).check(matches(isDisplayed()));
    }

    @Test
    public void teste_02_verificarCamposObrigatorios() {
        ViewInteraction edtUsuario = onView(withId(R.id.edtUsuario));
        edtUsuario.perform(replaceText("Teste"), closeSoftKeyboard());

        ViewInteraction btnSalvar = onView(withId(R.id.btnEntrar));
        btnSalvar.perform(click());

        onView(withText(R.string.preencha_todos_campos_login)).check(matches(isDisplayed()));
    }

    @Test
    public void teste_03_verificarDadosInvalidos() {
        ViewInteraction edtUsuario = onView(withId(R.id.edtUsuario));
        edtUsuario.perform(replaceText("Teste"));

        ViewInteraction edtSenha = onView(withId(R.id.edtSenha));
        edtSenha.perform(replaceText("12345"));

        ViewInteraction btnSalvar = onView(withId(R.id.btnEntrar));
        btnSalvar.perform(click());

        onView(withText(R.string.usuario_senha_invalidos)).check(matches(isDisplayed()));
    }

    @Test
    public void teste_04_verificarAcessoValido() {
        ViewInteraction edtUsuario = onView(withId(R.id.edtUsuario));
        edtUsuario.perform(replaceText("Teste"));

        ViewInteraction edtSenha = onView(withId(R.id.edtSenha));
        edtSenha.perform(replaceText("123456"));

        ViewInteraction btnSalvar = onView(withId(R.id.btnEntrar));
        btnSalvar.perform(click());

        onView(withText(R.string.bem_vindo)).check(matches(isDisplayed()));
    }
}
