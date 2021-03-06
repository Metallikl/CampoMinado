package view

import model.Tabuleiro
import model.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

fun main(args: Array<String>) {
    TelaPrincipal()
}

class TelaPrincipal : JFrame() {
    private val tabuleiro = Tabuleiro(qtdLinhas = 16, qtdColunas = 30, qtdMinas = 89)
    private val painelTabuleiro = PainelTabuleiro(tabuleiro)

    //
    init {
        tabuleiro.onEvento(this::mostrarResultado)
        add(painelTabuleiro)
        //
        setSize(690, 438)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        title = "Campo Minado"
        isVisible = true
    }

    private fun mostrarResultado(evento: TabuleiroEvento) {
        SwingUtilities.invokeLater {
            val msg = when (evento) {
                TabuleiroEvento.VITORIA -> "Você ganhou"
                TabuleiroEvento.DERROTA -> "Você Perdeu... =P"
            }
            //
            JOptionPane.showMessageDialog(this, msg)
            tabuleiro.reiniciar()
            //
            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}