package br.com.ccs.exemploteste.desconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class CalculadoraDescontoTest {
    private final BigDecimal valor = BigDecimal.valueOf(100);
    @InjectMocks
    private CalculadoraDesconto calculadoraDesconto;

    @Test
    void aplicarDescontoMaiorQuePermitido() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculadoraDesconto.aplicarDesconto(valor, 101f));
    }

    @Test
    void aplicarDescontoMenorQuePermitido() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculadoraDesconto.aplicarDesconto(valor, 0.9f));
    }

    @Test
    void aplicarDescdontoSucesso() {
        var expected = BigDecimal.valueOf(90).setScale(2);
        var actual = calculadoraDesconto.aplicarDesconto(valor, 10f);

        Assertions.assertEquals(expected, actual);
    }
}
