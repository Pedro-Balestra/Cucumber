package steps;

import br.com.inatel.udemyCucumber.entities.Filme;
import br.com.inatel.udemyCucumber.entities.NotaAluguel;
import br.com.inatel.udemyCucumber.entities.TipoAluguel;
import br.com.inatel.udemyCucumber.service.AluguelService;
import br.com.inatel.udemyCucumber.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AlugarFilmesSteps {
    private final AluguelService aluguel = new AluguelService();
    private Filme filme;
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel;

    @Given("um filme com estoque de {int} unidades")
    public void um_filme_com_estoque_de_unidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Given("que o preço do aluguel seja R$ {int}")
    public void que_o_preço_do_aluguel_seja_r$(Integer int1) {
        filme.setAluguel(int1);
    }

    @Given("um filme")
    public void um_filme(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Integer.parseInt(map.get("preco")));
        String tipo = map.get("tipo");
        tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL : tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;

    }

    @When("alugar")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }

    }

    @Then("o preço do aluguel será R$ {int}")
    public void o_preço_do_aluguel_será_r$(Integer int1) {
        Assert.assertEquals(int1, Integer.valueOf(nota.getPreco()));
    }


    @Then("o estoque do filme sera {int} unidade")
    public void o_estoque_do_filme_sera_unidade(Integer int1) {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Then("não sera possivel por falta de estoque")
    public void não_sera_possivel_por_falta_de_estoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Given("que o tipo do aluguel seja (.*)$")
    public void que_o_tipo_do_aluguel_seja_extendido(String tipo) {
        tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL : tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
    }

    @Then("a data de entrega sera em {int} dia(s)")
    public void a_data_de_entrega_sera_em_dias(Integer int1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));

    }

    @Then("a pontuacao sera de {int} pontos")
    public void a_pontuacao_sera_de_pontos(Integer int1) {
        Assert.assertEquals(int1, nota.getPontuação());
    }

}
