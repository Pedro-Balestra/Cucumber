package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumberSteps {
    Date entrega = new Date();
    private int contador = 0;

    @Given("que criei o arquivo corretamente")
    public void que_criei_o_arquivo_corretamente() {
    }

    @When("executa-lo")
    public void executa_lo() {

    }

    @Then("a especificacao deve finalizar com sucesso")
    public void a_especificacao_deve_finalizar_com_sucesso() {

    }

    @Given("que o valor do contador e {int}")
    public void que_o_valor_do_contador_e(Integer int1) {
        contador = int1;
    }

    @When("eu incrementar em {int}")
    public void eu_incrementar_em(Integer int1) {
        contador += int1;
    }

    @Then("o valor do contador sera {int}")
    public void o_valor_do_contador_sera(Integer int1) {
        Assert.assertEquals(int1, Integer.valueOf(contador));
    }

//    @Given("que a entrega e dia (.*)$")
//    public void que_a_entrega_e_dia(@Transform(DateConverter.class) Date data) {
//        entrega = data;
//    }

    @When("a entrega atrasar em {int} {word}")
    public void a_entrega_atrasar_em(int int1, String tempo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if (tempo.startsWith("dia")) {
            cal.add(Calendar.DAY_OF_MONTH, int1);
        } else if (tempo.startsWith("mes")) {
            cal.add(Calendar.MONTH, int1);
        }
        entrega = cal.getTime();
    }

    @Then("a entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void a_entrega_sera_efetuada_em(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }

    @Given("que o ticket( especial)? é (A.\\d{3})$")
    public void que_o_ticket_é_af345(String tipo, String ticket) {

    }

    @Given("que o valor da passagem é R$ {double}")
    public void que_o_valor_da_passagem_é_r$(Double double1) {

    }

    @Given("que o nome do passageiro é {string}")
    public void que_o_nome_do_passageiro_é(String string) {

    }

    @Given("que o telefone do passageiro é (9\\d{3}-\\d{4})$")
    public void que_o_telefone_do_passageiro_é(String telefone) {

    }

    @When("criar os steps")
    public void criar_os_steps() {

    }

    @Then("o teste vai funcionar")
    public void o_teste_vai_funcionar() {

    }


}
