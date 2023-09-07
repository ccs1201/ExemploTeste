package br.com.ccs.exemploteste.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraDesconto {


    public BigDecimal aplicarDesconto(BigDecimal valor, Float percentual) {

        validarDescontoMaximo(percentual);
        validarDescontoMinimimo(percentual);

        return valor.multiply(BigDecimal.valueOf(1 - (percentual / 100f))).setScale(2, RoundingMode.HALF_UP);
    }


    /**
     * Desconto não pode ser maior que 100%
     *
     * @param percentual
     */
    private void validarDescontoMaximo(Float percentual) {

        if (percentual > 100f) {
            throw new RuntimeException("Desconto não pode maior que cem por cento");
        }
    }

    /**
     * Desconto não pode ser menor que 1%
     *
     * @param percentual
     */
    private void validarDescontoMinimimo(Float percentual) {
        if (percentual < 1f) {
            throw new RuntimeException("Desconto não pode ser menor que um por cento");
        }
    }
}
