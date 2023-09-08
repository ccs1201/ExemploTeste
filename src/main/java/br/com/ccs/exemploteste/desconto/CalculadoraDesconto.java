package br.com.ccs.exemploteste.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraDesconto {

    /**
     * Aplica o desconto no valor informado.
     *
     * @param valor      valor original que tera o desconto calculado.
     * @param percentual percentual do desconto que deve ser aplicado.
     * @return valor com desconto aplicado.
     * @throws RuntimeException se o desconto informado for menor que 1% ou maior que 100%.
     */
    public BigDecimal aplicarDesconto(BigDecimal valor, Float percentual) {

        validarDescontoMaximo(percentual);
        validarDescontoMinimimo(percentual);

        return valor.multiply(BigDecimal.valueOf(1 - (percentual / 100f))).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Valida o percentual máximo de desconto permitido.
     *
     * @param percentual
     * @throws RuntimeException se desconto for maior que 100%
     */
    private void validarDescontoMaximo(Float percentual) {

        if (percentual > 100f) {
            throw new RuntimeException("Desconto não pode ser maior que cem por cento");
        }
    }

    /**
     * Valida o percentual mínimo de desconto permitido.
     *
     * @param percentual
     * @throws RuntimeException se o desconto for menor que 1%
     */
    private void validarDescontoMinimimo(Float percentual) {
        if (percentual < 1f) {
            throw new RuntimeException("Desconto não pode ser menor que um por cento");
        }
    }
}
