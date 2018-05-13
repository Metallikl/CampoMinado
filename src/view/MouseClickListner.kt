package view

import model.Campo
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

class MouseClickListner(
        private val campo: Campo,
        private val onBotaoEsquerdo: (Campo) -> Unit,
        private val onBotaoDireito: (Campo) -> Unit
) : MouseListener{

    override fun mousePressed(e: MouseEvent?) {
        when(e?.button){
            MouseEvent.BUTTON1 -> onBotaoEsquerdo(campo)
            MouseEvent.BUTTON3 -> onBotaoDireito(campo)//se não funcionar, usar button2
        }
    }

    override fun mouseReleased(e: MouseEvent?) {}

    override fun mouseEntered(e: MouseEvent?) {}

    override fun mouseClicked(e: MouseEvent?) {}

    override fun mouseExited(e: MouseEvent?) {}

}