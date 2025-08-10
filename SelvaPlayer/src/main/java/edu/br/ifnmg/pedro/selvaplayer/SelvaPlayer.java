/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.br.ifnmg.pedro.selvaplayer;

import io.github.guisso.jankenpon.AbstractPlayer;
import io.github.guisso.jankenpon.Move;

/**
 *
 * @author Pedro Henrique Nunes Ribeiro
 */
public class SelvaPlayer extends AbstractPlayer {

    public int contPedra = 0;
    public int contPapel = 0;
    public int contTesoura = 0;

    @Override
    public String getDeveloperName() {
        return "Pedro Ribeiro";
    }

    @Override
    public Move makeMyMove(Move opponentPreviousMove) {
        //começo jogando papel
        if (opponentPreviousMove == null) {
            return Move.PAPER;
        }

        if (opponentPreviousMove == Move.ROCK && contPedra >= 1) {
            contPedra = 0;
            return Move.PAPER;
        }

        if (opponentPreviousMove == Move.PAPER && contPapel >= 1) {
            contPapel = 0;
            return Move.SCISSORS;
        }

        if (opponentPreviousMove == Move.SCISSORS && contTesoura >= 1) {
            contTesoura = 0;
            return Move.ROCK;
        }

        // vou jogar a mesma mão que o meu oponente jogou na rodada passada
        switch (opponentPreviousMove) {
            case ROCK:
                this.contPedra++;
                this.contPapel = 0;
                this.contTesoura = 0;
                return Move.ROCK;
            case PAPER:
                this.contPapel++;
                this.contPedra = 0;
                this.contTesoura = 0;
                return Move.PAPER;
            case SCISSORS:
                this.contTesoura++;
                this.contPapel = 0;
                this.contPedra = 0;
                return Move.SCISSORS;
            default:
                return Move.PAPER;
        }
    }
}
