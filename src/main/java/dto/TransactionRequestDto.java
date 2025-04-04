package dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransactionRequestDto {

    @NotNull
    @Min(0)
    private double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }
}
