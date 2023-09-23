import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import transferencia.Cliente;
import transferencia.Conta;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaTest {
    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;
    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa","12345678909","9876543211");
        silvioSantos = new Cliente("Silvio Santos","12345678999","9876543222");
        contaXuxa = new Conta("0025", "2254", 2500, xuxa);
        contaSilvio = new Conta("0026", "2251", 3500, silvioSantos);
    }

    @Test
    void getProprietarioXuxa() {
        assertEquals(xuxa, contaXuxa.getProprietario());
    }

    @Test
    void getAgenciaXuxa() {
        assertEquals("0025", contaXuxa.getAgencia());
    }

    @Test
    void getNumeroContaXuxa() {
        assertEquals("2254", contaXuxa.getNumeroConta());
    }

    @Test
    void getSaldoXuxa() {
        assertEquals(2500, contaXuxa.getSaldo());
    }


    @Test
    void realizarDeposito() {
        contaXuxa.realizarDeposito(1000);
        assertEquals(3500, contaXuxa.getSaldo());
    }

    @Test
    void realizarSaque() {
        contaXuxa.realizarSaque(1000);
        assertEquals(1500, contaXuxa.getSaldo());
    }
    @Test
    @DisplayName("Realizar transação válida")
    public void realizarTransacao(){
        contaXuxa.realizarTransferencia(1000, contaSilvio);
        assertEquals(1500, contaXuxa.getSaldo(),"Saldo da conta Xuxa incorreto");
        assertEquals(4500, contaSilvio.getSaldo(),"Saldo da conta Silvio incorreto");
    }
    @Test
    @DisplayName("Realizar transação inválida")
    public void realizarTransacaoInvalida(){
        contaXuxa.realizarTransferencia(2501, contaSilvio);
        assertEquals(2500, contaXuxa.getSaldo(),"Saldo da conta Xuxa");
        assertEquals(3500, contaSilvio.getSaldo(),"Saldo da conta Silvio");
    }
    @Test
    void getProprietarioSilvio() {
        assertEquals(silvioSantos, contaSilvio.getProprietario());
    }

    @Test
    void getAgenciaSilvio() {
        assertEquals("0026", contaSilvio.getAgencia());
    }

    @Test
    void getNumeroContaSilvio() {
        assertEquals("2251", contaSilvio.getNumeroConta());
    }

    @Test
    void getSaldoSilvio() {
        assertEquals(3500, contaSilvio.getSaldo());
    }
}
