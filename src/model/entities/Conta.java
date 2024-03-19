package model.entities;

import model.exceptions.DomainException;

public class Conta {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta() {
    }

    public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double valor){
        saldo += valor;
    }

    public void sacar(Double valor){
        if (valor > getLimiteSaque()){
            throw new DomainException("O valor excede o Limite de Saque");
        }
        if (valor > getSaldo()){
            throw new DomainException("Saldo insuficiente");
        }
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "Novo saldo: R$ " + String.format("%.2f", saldo);
    }
}
